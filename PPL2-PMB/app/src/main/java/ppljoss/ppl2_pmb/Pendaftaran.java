package ppljoss.ppl2_pmb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.List;

import ppljoss.ppl2_pmb.Pendaftaran_pack.Formulir_test_online;
import ppljoss.ppl2_pmb.Pendaftaran_pack.Formulir_test_onsite;
import ppljoss.ppl2_pmb.Pendaftaran_pack.LoginActivity;

public class Pendaftaran extends AppCompatActivity {
    public Button btn_pendaftaran_form_test_on_site, btn_pendaftaran_form_test_online, btn_pendaftaran_blended_learning, btn_login_pendaftaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        init_pendaftaran_test_onsite();
        init_pendaftaran_test_online();
        init_pendaftaran_blended_learning();
        init_login_pendaftaran();

    }

    public void init_pendaftaran_test_onsite() {
        btn_pendaftaran_form_test_on_site = (Button) findViewById(R.id.btn_daftar_test_on_site);
        btn_pendaftaran_form_test_on_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toform_testonsite = new Intent(Pendaftaran.this, Formulir_test_onsite.class);

                startActivity(toform_testonsite);
            }
        });
    }

    public void init_pendaftaran_test_online() {
        btn_pendaftaran_form_test_online = (Button) findViewById(R.id.btn_daftar_test_online);
        btn_pendaftaran_form_test_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toform_testonline = new Intent(Pendaftaran.this, Formulir_test_online.class);

                startActivity(toform_testonline);
            }
        });
    }

    public void init_pendaftaran_blended_learning() {
        btn_pendaftaran_blended_learning = (Button) findViewById(R.id.btn_blended_learning);
        btn_pendaftaran_blended_learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toblended_learning = new Intent(Pendaftaran.this, Formulir_blended_learning.class);

                startActivity(toblended_learning);
            }
        });
    }

    public void init_login_pendaftaran() {
        btn_login_pendaftaran = (Button) findViewById(R.id.btn_login_pendaftaran);
        btn_login_pendaftaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tologin = new Intent(Pendaftaran.this, LoginActivity.class);

                startActivity(tologin);
            }
        });
    }


}
