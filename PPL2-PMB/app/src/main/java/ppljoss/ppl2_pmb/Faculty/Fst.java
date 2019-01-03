package ppljoss.ppl2_pmb.Faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class Fst extends AppCompatActivity {


    private WebView webviewfst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fst);


        webviewfst = (WebView) findViewById(R.id.webviewfst);

        webviewfst.setWebViewClient(new WebViewClient());
        webviewfst.getSettings().setJavaScriptEnabled(true);
        webviewfst.getSettings().setDomStorageEnabled(true);
        webviewfst.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewfst.loadUrl("https://fst.uai.ac.id/");

    }
}
