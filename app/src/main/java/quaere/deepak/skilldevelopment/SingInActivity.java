package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import quaere.deepak.skilldevelopment.database.DatabaseHandler;
import quaere.deepak.skilldevelopment.database.Member;

/**
 * Created by intex on 3/26/2016.
 */
public class SingInActivity extends Activity {
    EditText mobileNoEt, pswdEt;
    Button singIn;
    TextView showTv;
    boolean show = true;
    String mobileNo, pswd, phone, pass;
    DatabaseHandler db;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        mobileNoEt = (EditText) findViewById(R.id.login_mobileEt);
        pswdEt = (EditText) findViewById(R.id.login_pswdEt);
        singIn = (Button) findViewById(R.id.login_cntneBtn);
        showTv = (TextView) findViewById(R.id.login_showPswdTv);

        db = new DatabaseHandler(this);

        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        if (sharedpreferences.getString("logged", "").toString().equals("logged")) {

            Intent intent = new Intent(SingInActivity.this, MainPage.class);
            intent.putExtra("email", sharedpreferences.getString("email", ""));
            startActivity(intent);

        }
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        });
        showTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
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

    private void signIn() {
        mobileNo = mobileNoEt.getText().toString().trim();
        pswd = pswdEt.getText().toString().trim();

        if (mobileNo.equals("") && pswd.equals("")) {

            Toast.makeText(getApplicationContext(),
                    "Please enter Mobile No and Password",
                    Toast.LENGTH_SHORT).show();
            mobileNoEt.requestFocus();
        } else if (mobileNo.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please enter Mobile No", Toast.LENGTH_SHORT)
                    .show();
            mobileNoEt.requestFocus();
        } else if (pswd.equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please enter Password", Toast.LENGTH_SHORT).show();
            pswdEt.requestFocus();
        } else if (mobileNo.length() < 10) {
            Toast.makeText(getApplicationContext(),
                    "Please enter Correct Mobile No", Toast.LENGTH_SHORT)
                    .show();
            mobileNoEt.requestFocus();
        } else {
            List<Member> contacts = db.getAllContacts();
            for (Member cn : contacts) {
               // String log = " Phone: " + cn.getEmail() + " , password: " + cn.getPswd();
                phone = cn.getMobileNo();
                pass = cn.getPswd();
                // Writing Contacts to log
               // Log.d("Name: ", log);
                if (mobileNo.equals(phone) && pswd.equals(pass)) {
                    editor = sharedpreferences.edit();
                    editor.putString("mobileNo", mobileNo);
                    editor.putString("pswd", pswd);
                    editor.putString("logged", "logged");
                    editor.commit();

                    startActivity(new Intent(SingInActivity.this, MainPage.class));
                    this.finish();
                }
                else{
                   // startActivity(new Intent(SingInActivity.this, MainPage.class));
                    //Toast.makeText(getApplicationContext(),"Enter Correct Mobile No and Password",Toast.LENGTH_SHORT).show();
                }

            }
        }

    }
}
