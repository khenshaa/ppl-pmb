package ppljoss.ppl2_pmb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteUAIactivity extends AppCompatActivity {
    private WebView webviewWebUAI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_uaiactivity);

        webviewWebUAI = (WebView) findViewById(R.id.webviewWebUAI);

        webviewWebUAI.setWebViewClient(new WebViewClient());
        webviewWebUAI.getSettings().setJavaScriptEnabled(true);
        webviewWebUAI.getSettings().setDomStorageEnabled(true);
        webviewWebUAI.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewWebUAI.loadUrl("https://uai.ac.id/");

    }
}
