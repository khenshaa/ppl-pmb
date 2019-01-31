package ppljoss.ppl2_pmb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import ppljoss.ppl2_pmb.Pendaftaran_pack.BiayaPerkuliahan;
import ppljoss.ppl2_pmb.Pendaftaran_pack.EditPhoto;
import ppljoss.ppl2_pmb.Pendaftaran_pack.EditProfile;
import ppljoss.ppl2_pmb.Pendaftaran_pack.Formulir_blended_learning;
import ppljoss.ppl2_pmb.Pendaftaran_pack.Formulir_test_online;
import ppljoss.ppl2_pmb.Pendaftaran_pack.Formulir_test_onsite;
import ppljoss.ppl2_pmb.Pendaftaran_pack.JalurMasuk;

public class Pendaftaran extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    public Button btn_pendaftaran_form_test_on_site, btn_pendaftaran_form_test_online, btn_pendaftaran_blended_learning, btn_login_pendaftaran;
    public Button btn_infobiaya, btn_jalurmasuk, btn_faq, btn_edit_profile;

    ////MENU



    //ImageSlider Inisialisai
    SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);


        //Button Init, aktifin
        init_pendaftaran_test_onsite();
        init_pendaftaran_test_online();
        init_pendaftaran_blended_learning();
        init_login_pendaftaran();
        init_jalur_masuk();
        init_info_biaya();
        init_edit_profile();
        init_faq();

        //ImageSlider
        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        Hash_file_maps.put("Image1", "https://penerimaan.uai.ac.id/file/images/slide/Slider-01-Rev1.jpg");
        Hash_file_maps.put("Image2", "https://penerimaan.uai.ac.id/file/images/slide/8%20langkah%20pmb%20online.jpg");
        Hash_file_maps.put("Image3", "https://penerimaan.uai.ac.id/file/images/slide/ghi.jpg");
        Hash_file_maps.put("Image4", "https://penerimaan.uai.ac.id/file/images/slide/jkl.jpg");
        Hash_file_maps.put("Image5", "https://penerimaan.uai.ac.id/file/images/slide/mno.jpg");


        for (String name : Hash_file_maps.keySet()) {

            TextSliderView textSliderView = new TextSliderView(Pendaftaran.this);
            textSliderView
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle();
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);


    }


    //Activity yang ada pada menu pendaftaran

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

    public void init_jalur_masuk() {
        btn_jalurmasuk = (Button) findViewById(R.id.btn_jalurmasuk);
        btn_jalurmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tojalurmasuk = new Intent(Pendaftaran.this, JalurMasuk.class);

                startActivity(tojalurmasuk);
            }
        });
    }


    public void init_info_biaya() {
        btn_infobiaya = (Button) findViewById(R.id.btn_infobiaya);
        btn_infobiaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toinfobiaya = new Intent(Pendaftaran.this, BiayaPerkuliahan.class);

                startActivity(toinfobiaya);
            }
        });
    }

    public void init_edit_profile() {
        btn_edit_profile = (Button) findViewById(R.id.btn_editprofile);
        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toeditprofile = new Intent(Pendaftaran.this, EditProfile.class);

                startActivity(toeditprofile);
            }
        });
    }

    public void init_faq() {
        btn_faq = (Button) findViewById(R.id.btn_FAQ);
        btn_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tofaq = new Intent(Pendaftaran.this, Faq.class);

                startActivity(tofaq);
            }
        });
    }




    // Image Slider

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("UAI", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
