package ppljoss.ppl2_pmb.Faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class Feb extends AppCompatActivity {

    private WebView webviewfeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feb);

        webviewfeb = (WebView) findViewById(R.id.webviewfeb);

        webviewfeb.setWebViewClient(new WebViewClient());
        webviewfeb.getSettings().setJavaScriptEnabled(true);
        webviewfeb.getSettings().setDomStorageEnabled(true);
        webviewfeb.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewfeb.loadUrl("http://fe.uai.ac.id/");
    }
}
