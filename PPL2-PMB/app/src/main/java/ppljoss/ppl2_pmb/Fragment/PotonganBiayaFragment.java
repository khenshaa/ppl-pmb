package ppljoss.ppl2_pmb.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.support.v4.app.Fragment;
import android.webkit.WebViewClient;

import ppljoss.ppl2_pmb.R;

/**
 * Created by khenshaa on 1/28/19.
 */

public class PotonganBiayaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_potongan_biaya, container, false);
    }
}
