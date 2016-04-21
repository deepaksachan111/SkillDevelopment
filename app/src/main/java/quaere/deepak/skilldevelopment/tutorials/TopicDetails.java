package quaere.deepak.skilldevelopment.tutorials;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import quaere.deepak.skilldevelopment.R;

/**
 * Created by intex on 3/26/2016.
 */
public class TopicDetails extends Activity{
TextView titleTv,bodytv;
    String title,body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_details_layout);
        titleTv = (TextView) findViewById(R.id.topic_detail_headerTv);
        bodytv = (TextView) findViewById(R.id.topic_detail_detailTv);

        title = getIntent().getStringExtra("title");
        body = getIntent().getStringExtra("detail");
        titleTv.setText(title);
        bodytv.setText(body);

        findViewById(R.id.topic_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
