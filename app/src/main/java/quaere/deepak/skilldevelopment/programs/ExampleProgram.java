package quaere.deepak.skilldevelopment.programs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import quaere.deepak.skilldevelopment.R;

/**
 * Created by intex on 3/28/2016.
 */
public class ExampleProgram extends Activity {
    TextView titleTv, progTv;
    String title, program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_program_layout);
        title = getIntent().getStringExtra("title");
        program = getIntent().getStringExtra("program");
        titleTv = (TextView) findViewById(R.id.program_headerTv);
        progTv = (TextView) findViewById(R.id.program_detailTv);

        findViewById(R.id.ex_prog_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        titleTv.setText(title);
        progTv.setText(program);

    }
}
