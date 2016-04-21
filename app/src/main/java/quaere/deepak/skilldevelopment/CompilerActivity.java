package quaere.deepak.skilldevelopment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by intex on 3/28/2016.
 */
public class CompilerActivity extends Activity{
    private WebView webView;
    private ProgressBar progress;
    String url = "https://code.hackerearth.com/bf0658H?key=1918a50d2c10821860875998d47db54c";
   //String url = "https://codepad.remoteinterview.io/SurprisedNebulousCitrusFormal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_compiler);
        TextView noInternet = (TextView) findViewById(R.id.noInternetTv);
        webView = (WebView) findViewById(R.id.webView);
        progress = (ProgressBar)findViewById(R.id.progressBar);
        progress.setVisibility(View.GONE);
        webView.setWebViewClient(new MyWebViewClient(this, progress));
        webView.getSettings().setJavaScriptEnabled(true);


        ConnectivityManager conMgr = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null) {
            noInternet.setVisibility(View.VISIBLE);
            //noConnectionTv.setText(" Hey !!!.. Check your Connection");
        } else {
            noInternet.setVisibility(View.GONE);
            webView.loadUrl(url);
        }


        findViewById(R.id.compiler_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private class MyWebViewClient extends WebViewClient {
        private ProgressBar progress;
        Activity activity;

        public MyWebViewClient(Activity activity, ProgressBar progress) {
            this.activity = activity;
            this.progress = progress;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progress.setVisibility(View.VISIBLE);
            progress.setProgress(100);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progress.setVisibility(View.GONE);
            progress.setProgress(100);
            super.onPageFinished(view, url);
        }

        public void setValue(int progress) {
            this.progress.setProgress(progress);
        }
    }
}
