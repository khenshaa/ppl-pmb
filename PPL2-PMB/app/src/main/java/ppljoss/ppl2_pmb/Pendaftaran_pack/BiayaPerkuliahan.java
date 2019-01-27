package ppljoss.ppl2_pmb.Pendaftaran_pack;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;

import ppljoss.ppl2_pmb.R;

/**
 * Created by khenshaa on 1/27/19.
 */

public class BiayaPerkuliahan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biaya_perkuliahan);


        ImageView imageView = (ImageView) findViewById(R.id.img_biaya);
        String url_img = "https://penerimaan.uai.ac.id/file/images/BiayaKuliah-19.jpg";

        Picasso.with(this).load(url_img).into(imageView);


    }
}

