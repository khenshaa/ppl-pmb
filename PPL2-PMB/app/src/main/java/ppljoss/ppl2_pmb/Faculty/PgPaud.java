package ppljoss.ppl2_pmb.Faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class PgPaud extends AppCompatActivity {
    private WebView webviewpgpaud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgpaud);

        webviewpgpaud = (WebView) findViewById(R.id.webviewpgpaud);

        webviewpgpaud.setWebViewClient(new WebViewClient());
        webviewpgpaud.getSettings().setJavaScriptEnabled(true);
        webviewpgpaud.getSettings().setDomStorageEnabled(true);
        webviewpgpaud.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewpgpaud.loadUrl("http://fpp.uai.ac.id/");
    }
}
