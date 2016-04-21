package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by intex on 3/26/2016.
 */
public class Tests extends Activity implements RadioGroup.OnCheckedChangeListener {
    String ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9, ans10, ans11, ans12, ans13, ans14, ans15;
    static String selected1, selected2, selected3, selected4, selected5, selected6, selected7, selected8, selected9, selected10;
    RadioGroup gOne, gTwo, gThree, gFour, gFive, gSix, gSeven, gEight, gNine, gTen;
   static int right = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        gOne = (RadioGroup) findViewById(R.id.radio_group_one);
        gTwo = (RadioGroup) findViewById(R.id.radio_group_two);
        gThree = (RadioGroup) findViewById(R.id.radio_group_three);
        gFour = (RadioGroup) findViewById(R.id.radio_groupfour);
        gFive = (RadioGroup) findViewById(R.id.radio_group_five);
        gSix = (RadioGroup) findViewById(R.id.radio_group_six);
        gSeven = (RadioGroup) findViewById(R.id.radio_group_seven);
        gEight = (RadioGroup) findViewById(R.id.radio_groupeight);
        gNine = (RadioGroup) findViewById(R.id.radio_group_nine);
        gTen = (RadioGroup) findViewById(R.id.radio_group_ten);

        gTen.setOnCheckedChangeListener(this);
        gTwo.setOnCheckedChangeListener(this);
        gThree.setOnCheckedChangeListener(this);
        gFour.setOnCheckedChangeListener(this);
        gFive.setOnCheckedChangeListener(this);
        gSix.setOnCheckedChangeListener(this);
        gSeven.setOnCheckedChangeListener(this);
        gEight.setOnCheckedChangeListener(this);
        gNine.setOnCheckedChangeListener(this);
        gOne.setOnCheckedChangeListener(this);

        ans1 = "64";
        ans2 = "27";
        ans3 = "-121";
        ans4 = "Less Than";
        ans5 = "21";
        ans6 = "Compiler Error";
        ans7 = "12 11 11";
        ans8 = "Hello world11";
        ans9 = "(null)";
        ans10 = "1 2 3";
       /* ans11="6";
        ans12="8";
        ans13="Compiler error";
        ans14="40";
        ans15="Garbage value";*/

        findViewById(R.id.test_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.test_submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
        switch (group.getId()) {

            case R.id.radio_group_one:
                selected1 = radioButton.getText().toString();
                if (selected1.equals(ans1)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }

             //   Toast.makeText(getApplicationContext(), selected1, Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_group_two:
                selected2 = radioButton.getText().toString();
                if (selected2.equals(ans2)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
               // Toast.makeText(getApplicationContext(), selected2, Toast.LENGTH_SHORT).show();

                break;

            case R.id.radio_group_three:
                selected3 = radioButton.getText().toString();
                if (selected3.equals(ans3)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
               // Toast.makeText(getApplicationContext(), selected3, Toast.LENGTH_SHORT).show();

                break;

            case R.id.radio_groupfour:
                selected4 = radioButton.getText().toString();
                if (selected4.equals(ans4)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }

               // Toast.makeText(getApplicationContext(), selected4, Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_group_five:
                selected5 = radioButton.getText().toString();
                if (selected5.equals(ans5)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
                Toast.makeText(getApplicationContext(), selected5, Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_group_six:
                selected6 = radioButton.getText().toString();
                if (selected6.equals(ans6)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
              //  Toast.makeText(getApplicationContext(), selected6, Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_group_seven:
                selected7 = radioButton.getText().toString();
                if (selected7.equals(ans7)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
              //  Toast.makeText(getApplicationContext(), selected7, Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_groupeight:
                selected8 = radioButton.getText().toString();
                if (selected8.equals(ans8)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
              //  Toast.makeText(getApplicationContext(), selected8, Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_group_nine:
                selected9 = radioButton.getText().toString();
                if (selected9.equals(ans9)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
             //   Toast.makeText(getApplicationContext(), selected9, Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_group_ten:
                selected10 = radioButton.getText().toString();
                if (selected10.equals(ans10)) {
                    right = right + 1;
                    Log.d("right", "" + right);
                }
               // Toast.makeText(getApplicationContext(), selected10, Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void showResult() {

        Intent i = new Intent(Tests.this, TestResults.class);
        i.putExtra("result", right);
        startActivity(i);
        //  startActivity(new Intent(Tests.this, TestResults.class));
    }

}
