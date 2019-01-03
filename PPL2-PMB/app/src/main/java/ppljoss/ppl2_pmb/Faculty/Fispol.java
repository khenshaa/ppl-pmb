package ppljoss.ppl2_pmb.Faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class Fispol extends AppCompatActivity {

    private WebView webviewfispol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fispol);

        webviewfispol = (WebView) findViewById(R.id.webviewfispol);

        webviewfispol.setWebViewClient(new WebViewClient());
        webviewfispol.getSettings().setJavaScriptEnabled(true);
        webviewfispol.getSettings().setDomStorageEnabled(true);
        webviewfispol.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewfispol.loadUrl("http://fisip.uai.ac.id/");
    }
}
