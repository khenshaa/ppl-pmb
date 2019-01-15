package ppljoss.ppl2_pmb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import ppljoss.ppl2_pmb.BeritaUAI_RSS.ReadRss;

public class BeritaActivity extends AppCompatActivity {

    RecyclerView recyclerView_berita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        recyclerView_berita = (RecyclerView) findViewById(R.id.recyclerview_berita);
        //Call Read rss asyntask to fetch rss
        ReadRss readRss = new ReadRss(this, recyclerView_berita);
        readRss.execute();
    }
}
