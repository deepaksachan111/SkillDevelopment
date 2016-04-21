package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class MainActivity extends Activity {

    String JSON_URL ="http://rsmile.quaeretech.com/RealtorSmile.svc/GetContactRecords/rahulmiddha.eng@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.singinBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingInActivity.class));
            }
        });
        findViewById(R.id.signupBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
    sendRequest();
       // new RelatedToAsyncTask().execute("http://rsmile.quaeretech.com/RealtorSmile.svc/GetContactRecords/rahulmiddha.eng@gmail.com");
    }
    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){

        String j = json;
        Log.v("JSON DATA>>>>>>>>>>",json);
       ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomList cl = new CustomList(this,R.layout.custum_list_row_parsedata, ParseJSON.ids,ParseJSON.names,ParseJSON.emails);

        ListView listView =(ListView)findViewById(R.id.lst_lisyview);
         listView.setAdapter(cl);
    }

    private class CustomList extends  ArrayAdapter{
    Context context;
        String[] r1;
        String[] r2;
        String[] r3;
        public CustomList(Context context,int Resourse, String[] r1,String[] r2,String[] r3) {
            super(context,Resourse,r2);
            this.context = context;
            this.r1=r1;
            this.r2 = r2;
            this.r3 = r3;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
  String hellp = "";
            View row = convertView;
            if(convertView == null){


            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.custum_list_row_parsedata, parent, false);

            }

            TextView textView =(TextView)row.findViewById(R.id.fullNameTv);
            TextView lastname=(TextView)row.findViewById(R.id.lastnamess);
            TextView type =(TextView)row.findViewById(R.id.email);


           String rrr1 = r1[position];
            textView.setText(rrr1);

            String rr2 = r2[position];
            lastname.setText(rr2);

            String rr3 = r3[position];
            type.setText(rr3);


            return row;
        }
    }
}
