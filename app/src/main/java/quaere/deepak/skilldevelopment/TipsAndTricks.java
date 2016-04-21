package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by intex on 3/26/2016.
 */
public class TipsAndTricks extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips_tricks_layout);
        TextView text = (TextView)findViewById(R.id.tips_tricks_bodyTv);
        String data = getResources().getString(R.string.tips_tricks_details);
        text.setText(data);
        findViewById(R.id.tips_tricks_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
