package ppljoss.ppl2_pmb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class risetpublikasi extends AppCompatActivity {

    private WebView webviewRisetpublikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risetpublikasi);

        webviewRisetpublikasi =(WebView)findViewById(R.id.webviewrisetpublikasi);

        webviewRisetpublikasi.setWebViewClient(new WebViewClient());
        webviewRisetpublikasi.getSettings().setJavaScriptEnabled(true);
        webviewRisetpublikasi.getSettings().setDomStorageEnabled(true);
        webviewRisetpublikasi.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewRisetpublikasi.loadUrl("http://lp2m.uai.ac.id/");
    }


}
