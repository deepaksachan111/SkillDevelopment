package quaere.deepak.skilldevelopment.programs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import quaere.deepak.skilldevelopment.R;

/**
 * Created by intex on 3/26/2016.
 */
public class Program extends Activity {
    ListView program_list;
    String[] values ;//= getResources().getStringArray(R.array.programs);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programs_layout);
        program_list = (ListView) findViewById(R.id.program_listview);

        values = getResources().getStringArray(R.array.programs);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        program_list.setAdapter(adapter);
        program_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String progName = (String) program_list.getItemAtPosition(position);
                exampleProgram(progName);
                Toast.makeText(getApplicationContext(), "Position :" + itemPosition + "  ListItem : " + progName, Toast.LENGTH_LONG).show();

            }

        });
        findViewById(R.id.programs_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void exampleProgram(String progName) {
        String title = progName;
        Intent i = new Intent(Program.this,ExampleProgram.class);
        if(title.equals("Hello World")){
            String program = getResources().getString(R.string.helloworl_exe);
            i.putExtra("title",title);
           i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Print Integer")){
            String program = getResources().getString(R.string.print_integer);
            i.putExtra("title",title);
             i.putExtra("program",program);
            startActivity(i);

        }
        else  if(title.equals("Addition of Two Numbers")){
            String program = getResources().getString(R.string.addition_of_two_number);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Area of Triangle")){
           String program = getResources().getString(R.string.area_of_triangle);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Odd or Even")){
            String program = getResources().getString(R.string.odd_even);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Add Subtract Multiply Divide")){
            String program = getResources().getString(R.string.add_sub_mul_div);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Greatest of 3 Numbers")){
            String program = getResources().getString(R.string.greatest_of_three);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Swapping Two numbers")){
            String program = getResources().getString(R.string.swapping_of_two_number);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Calculate Percentage")){
            String program = getResources().getString(R.string.calculate_percentage);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Simple Interest")){
            String program = getResources().getString(R.string.simple_interest);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Area of Rectangle")){
            String program = getResources().getString(R.string.area_of_rectangle);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);



        }
        else if(title.equals("Volume of Cylinder")){
            String program = getResources().getString(R.string.volume_of_cylinder);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("HCF and LCM")){
            String program = getResources().getString(R.string.lcm_hcf);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("nCr and nPr")){
            String program = getResources().getString(R.string.ncr_npr);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Reverse Number")){
            String program = getResources().getString(R.string.reverse_number);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Prime Number")){
            String program = getResources().getString(R.string.prime_number);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Perfect Numbers")){
            String program = getResources().getString(R.string.perfect_number);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Amstrong Number")){
            String program = getResources().getString(R.string.armstrong_number);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Factorial Of Number")){
            String program = getResources().getString(R.string.factorial_number);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Fibonacci Series")){
            String program = getResources().getString(R.string.fibonacci_series);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
        else if(title.equals("Print Pattern")){
            String program = getResources().getString(R.string.print_pattern);
            i.putExtra("title",title);
            i.putExtra("program",program);
            startActivity(i);

        }
    }
}
