package ppljoss.ppl2_pmb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class kemahasiswaan extends AppCompatActivity {

    private WebView webviewKemahasiswaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kemahasiswaan);

        webviewKemahasiswaan =(WebView)findViewById(R.id.webviewkemahasiswaan);

        webviewKemahasiswaan.setWebViewClient(new WebViewClient());
        webviewKemahasiswaan.getSettings().setJavaScriptEnabled(true);
        webviewKemahasiswaan.getSettings().setDomStorageEnabled(true);
        webviewKemahasiswaan.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webviewKemahasiswaan.loadUrl("http://kemahasiswaan.uai.ac.id/");
    }



}
