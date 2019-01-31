package ppljoss.ppl2_pmb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ppljoss.ppl2_pmb.BeritaUAI_RSS.ReadRss;

public class BeritaActivity extends AppCompatActivity {

    RecyclerView recyclerViewberita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        recyclerViewberita = (RecyclerView) findViewById(R.id.recyclerview_berita);

        //Call Read rss asyntask to fetch rss
        ReadRss readRss = new ReadRss(this, recyclerViewberita);
        readRss.execute();
    }
}
