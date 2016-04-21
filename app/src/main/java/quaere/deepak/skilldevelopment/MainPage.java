package quaere.deepak.skilldevelopment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import quaere.deepak.skilldevelopment.programs.Program;
import quaere.deepak.skilldevelopment.tutorials.Tutorials;

/**
 * Created by intex on 3/26/2016.
 */
public class MainPage extends AppCompatActivity implements View.OnClickListener{
    TextView tutorials,programs,tests,logics,questions,helps,tips_tricks,compileTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);
        tutorials = (TextView) findViewById(R.id.tutorials);
        programs = (TextView) findViewById(R.id.programs);
        tests = (TextView) findViewById(R.id.tests);
        logics = (TextView) findViewById(R.id.logics);
        questions = (TextView) findViewById(R.id.questions);
        helps = (TextView) findViewById(R.id.helps);
        tips_tricks = (TextView) findViewById(R.id.tips_tricks);
        compileTv = (TextView) findViewById(R.id.compile_hereTv);

        tutorials.setOnClickListener(this);
        programs.setOnClickListener(this);
        tests.setOnClickListener(this);
        logics.setOnClickListener(this);
        questions.setOnClickListener(this);
        helps.setOnClickListener(this);
        tips_tricks.setOnClickListener(this);
        compileTv.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                singOut();
               // Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void singOut() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainPage.this);
        builder.setTitle("Exit the app? ")
                .setMessage(
                        "Are you sure you want to sign out of your account ?")
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.remove("logged");
                                editor.remove("mobileNo");
                                editor.remove("pswd");
                                editor.commit();
                                finish();

                              /*  startActivity(new Intent(
                                        getApplicationContext(),
                                        LoginActivity.class));*/
                            }
                        });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tutorials:
              //  Toast.makeText(getApplicationContext(),"Tutorials",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainPage.this,Tutorials.class));
                break;
            case R.id.programs:
              //  Toast.makeText(getApplicationContext(),"Programs",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainPage.this, Program.class));
                break;
            case R.id.tests:
                //Toast.makeText(getApplicationContext(),"Tests",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainPage.this, Tests.class));
                break;
            case R.id.logics:
                startActivity(new Intent(MainPage.this, Logics.class));
                break;
            case R.id.questions:
                startActivity(new Intent(MainPage.this, Questions.class));
                break;
            case R.id.helps:
                Toast.makeText(getApplicationContext(),"Skill  Development  consists of the facilities that help an individual user to successfully increase their knowledge for their Career. This application is basically for computer students who want to increase their knowledge in c programming.\n" +
                        "\n",Toast.LENGTH_LONG).show();
                break;
            case R.id.compile_hereTv:
                startActivity(new Intent(MainPage.this,CompilerActivity.class));
                Toast.makeText(getApplicationContext(),"Functionality will be added soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tips_tricks:
                startActivity(new Intent(MainPage.this,TipsAndTricks.class));
                //Toast.makeText(getApplicationContext(),"Tips and Tricks",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
