package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by intex on 4/5/2016.
 */
public class TestResults extends Activity{
    int marks;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_result_layout);
        tv1 = (TextView) findViewById(R.id.test_scoreTv);
        marks = getIntent().getIntExtra("result",0);
        String no = String.valueOf(marks);
        tv1.setText(no);
        findViewById(R.id.testResult_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
