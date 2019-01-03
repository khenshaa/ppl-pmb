package ppljoss.ppl2_pmb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ppljoss.ppl2_pmb.Faculty.Feb;
import ppljoss.ppl2_pmb.Faculty.Fispol;
import ppljoss.ppl2_pmb.Faculty.Fst;
import ppljoss.ppl2_pmb.Faculty.Hukum;


public class Fakultas extends AppCompatActivity{
    public Button btn_fst, btn_hukum, btn_feb, btn_pgpaud, btn_sasbud, btn_fispol;

    @Override

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakultas);

        init_Fst();
        init_Feb();
        init_Fispol();
        init_Hukum();

    }

    private void init_Hukum() {
        btn_hukum = (Button) findViewById(R.id.button_hukum);
        btn_hukum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tohukum = new Intent(Fakultas.this, Hukum.class);

                startActivity(tohukum);
            }
        });
    }

    private void init_Fispol() {
        btn_fispol = (Button) findViewById(R.id.button_fispol);
        btn_fispol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tofispol = new Intent(Fakultas.this, Fispol.class);

                startActivity(tofispol);
            }
        });
    }

    private void init_Feb() {
        btn_feb = (Button) findViewById(R.id.button_feb);
        btn_feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tofeb = new Intent(Fakultas.this, Feb.class);

                startActivity(tofeb);
            }
        });
    }

    private void init_Fst() {
        btn_fst = (Button) findViewById(R.id.button_fst);
        btn_fst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tofst = new Intent(Fakultas.this, Fst.class);

                startActivity(tofst);
            }
        });
    }



}
