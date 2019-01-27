package ppljoss.ppl2_pmb.Pendaftaran_pack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class Formulir_test_online extends AppCompatActivity {

    private WebView webviewtestonline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_test_online);

        webviewtestonline = (WebView) findViewById(R.id.webviewtestonline);

        webviewtestonline.setWebViewClient(new WebViewClient());
        webviewtestonline.getSettings().setJavaScriptEnabled(true);
        webviewtestonline.getSettings().setDomStorageEnabled(true);
        webviewtestonline.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewtestonline.loadUrl("https://pmbonline.uai.ac.id/");
    }

}
