package ppljoss.ppl2_pmb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class KantorInternasional extends AppCompatActivity {

    private WebView webviewKantorInternasinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kantor_internasional);

        webviewKantorInternasinal = (WebView) findViewById(R.id.webviewKantorInternasional);

        webviewKantorInternasinal.setWebViewClient(new WebViewClient());
        webviewKantorInternasinal.getSettings().setJavaScriptEnabled(true);
        webviewKantorInternasinal.getSettings().setDomStorageEnabled(true);
        webviewKantorInternasinal.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewKantorInternasinal.loadUrl("http://kantor-internasional.uai.ac.id/english/");
    }
}
