package ppljoss.ppl2_pmb.Pendaftaran_pack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class Formulir_blended_learning extends AppCompatActivity {

    private WebView webviewblended;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_blended_learning);

        webviewblended = (WebView) findViewById(R.id.webviewblended);

        webviewblended.setWebViewClient(new WebViewClient());
        webviewblended.getSettings().setJavaScriptEnabled(true);
        webviewblended.getSettings().setDomStorageEnabled(true);
        webviewblended.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewblended.loadUrl("http://blendedlearning.uai.ac.id/");
    }
}
