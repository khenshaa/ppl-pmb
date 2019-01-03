package ppljoss.ppl2_pmb.Faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

public class SasBud extends AppCompatActivity {

    private WebView webviewsasbud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sasbud);


        webviewsasbud = (WebView) findViewById(R.id.webviewsasbud);

        webviewsasbud.setWebViewClient(new WebViewClient());
        webviewsasbud.getSettings().setJavaScriptEnabled(true);
        webviewsasbud.getSettings().setDomStorageEnabled(true);
        webviewsasbud.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewsasbud.loadUrl("http://fib.uai.ac.id//");

    }
}
