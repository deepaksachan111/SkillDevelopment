package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import quaere.deepak.skilldevelopment.database.DatabaseHandler;
import quaere.deepak.skilldevelopment.database.Member;

/**
 * Created by intex on 3/26/2016.
 */
public class SignUpActivity extends Activity {
    EditText nameEt, mobileEt, emailEt, pswdEt;
    Button signup;
    TextView showTv;
    boolean show = true;
    String name, mobile, email, pswd;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        signup = (Button) findViewById(R.id.signup_contneBtn);
        nameEt = (EditText) findViewById(R.id.signup_nameEt);
        mobileEt = (EditText) findViewById(R.id.signup_mobileEt);
        emailEt = (EditText) findViewById(R.id.signup_emailEt);
        pswdEt = (EditText) findViewById(R.id.signup_pswdEt);
        showTv = (TextView) findViewById(R.id.signup_showpswdTv);

        db = new DatabaseHandler(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                singUp();

            }
        });
        showTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show) {
                    pswdEt.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    show = false;
                } else {
                    pswdEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show = true;
                }

            }
        });
    }

    private void singUp() {
        name = nameEt.getText().toString();
        mobile = mobileEt.getText().toString();
        email = emailEt.getText().toString();
        pswd = pswdEt.getText().toString();
        if (name.equals("") && mobile.equals("") && email.equals("") && pswd.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please enter All Fields",
                    Toast.LENGTH_SHORT).show();
            nameEt.requestFocus();
        } else if (mobile.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please enter Mobile No", Toast.LENGTH_SHORT)
                    .show();
            mobileEt.requestFocus();
        } else if (email.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please enter Email", Toast.LENGTH_SHORT).show();
            emailEt.requestFocus();
        } else if (pswd.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please enter Password", Toast.LENGTH_SHORT).show();
            pswdEt.requestFocus();
        } else if (mobile.length() < 10) {
            Toast.makeText(getApplicationContext(),
                    "Please enter Correct Mobile No", Toast.LENGTH_SHORT)
                    .show();
            mobileEt.requestFocus();
        } else {

            // Inserting Contacts
            Log.d("Insert: ", "Inserting ..");
            db.addContact(new Member(name, mobile, email, pswd));

         /*   // Reading all contacts
            Log.d("Reading: ", "Reading all contacts..");
            List<Member> contacts = db.getAllContacts();
            for (Member cn : contacts) {
                String log = "Name: " + cn.getName() + " Email,: " + cn.getEmail() + " ,Phone: " + cn.getMobileNo() + " , password: " + cn.getPswd();
                // Writing Contacts to log
                Log.d("Name: ", log);
                 }*/

                startActivity(new Intent(SignUpActivity.this, SingInActivity.class));

        }

    }
}
