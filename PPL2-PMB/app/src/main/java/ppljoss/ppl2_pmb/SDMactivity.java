package ppljoss.ppl2_pmb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SDMactivity extends AppCompatActivity {
    private WebView webviewSDM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdmactivity);


        webviewSDM = (WebView) findViewById(R.id.webviewSDM);

        webviewSDM.setWebViewClient(new WebViewClient());
        webviewSDM.getSettings().setJavaScriptEnabled(true);
        webviewSDM.getSettings().setDomStorageEnabled(true);
        webviewSDM.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewSDM.loadUrl("https://sdm.uai.ac.id/");
    }


}
