package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by intex on 3/26/2016.
 */
public class Logics extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logics_layout);
        TextView text = (TextView)findViewById(R.id.logics_bodyTv);
        String data = getResources().getString(R.string.logics);
        text.setText(data);
        findViewById(R.id.logics_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
