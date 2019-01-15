package ppljoss.ppl2_pmb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    public Button btn_kemahasiswaan, btn_risetpublikasi,btn_about,btn_fakultas, btn_berita;
    public ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_kemahasiswaan();
        init_risetpublikasi();
        init_About();
        init_Fakultas();
        init_Berita();


        v_flipper= (ViewFlipper) findViewById(R.id.v_flipper);
        int slide_images[] = {R.drawable.slide1, R.drawable.slide2,
               R.drawable.slide4, R.drawable.slide5, R.drawable.slide6,};

        for(int images: slide_images){
            flipperImages(images);
        }


    }


    public void init_kemahasiswaan() {
        btn_kemahasiswaan = (Button) findViewById(R.id.button_kemahasiswaan);
        btn_kemahasiswaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kekemahasiswaan = new Intent(MainActivity.this, kemahasiswaan.class);

                startActivity(kekemahasiswaan);
            }
        });
    }

    public void init_risetpublikasi() {
        btn_risetpublikasi = (Button) findViewById(R.id.button_riset);
        btn_risetpublikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kerisetpublikasi= new Intent(MainActivity.this, risetpublikasi.class);

                startActivity(kerisetpublikasi);
            }
        });
    }

    public void init_About() {
        btn_about = (Button) findViewById(R.id.button_about);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent toabout = new Intent(MainActivity.this, About.class);

                startActivity(toabout);
            }
        });
    }

    private void init_Fakultas() {
        btn_fakultas = (Button) findViewById(R.id.button_fakultas);
        btn_fakultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tofakultas = new Intent(MainActivity.this, Fakultas.class);

                startActivity(tofakultas);
            }
        });
    }

    private void init_Berita() {
        btn_berita = (Button) findViewById(R.id.button_berita);
        btn_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toberita = new Intent(MainActivity.this, BeritaActivity.class);

                startActivity(toberita);
            }
        });
    }


    public void  flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        //Animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);



    }



}

