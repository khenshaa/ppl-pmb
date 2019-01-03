package ppljoss.ppl2_pmb.Faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class Hukum extends AppCompatActivity {

    private WebView webviewhukum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum);

        webviewhukum = (WebView) findViewById(R.id.webviewhukum);

        webviewhukum.setWebViewClient(new WebViewClient());
        webviewhukum.getSettings().setJavaScriptEnabled(true);
        webviewhukum.getSettings().setDomStorageEnabled(true);
        webviewhukum.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewhukum.loadUrl("http://fh.uai.ac.id/");
    }
}
