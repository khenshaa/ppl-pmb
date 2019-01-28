package ppljoss.ppl2_pmb;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {

    private TextView textViewtahapan, textViewiformasi;
    private ImageView imageViewProfile;
    private static final int SELECTED_PICTURE = 1;
    public Button button_upload, button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //view
        imageViewProfile = (ImageView) findViewById(R.id.fotoprofileuser);
        textViewtahapan = (TextView) findViewById(R.id.tahapan);
        textViewiformasi = (TextView) findViewById(R.id.info_tes);
        button_upload = (Button) findViewById(R.id.btn_upload_foto);
        button_save = (Button) findViewById(R.id.btn_save_foto);

    }

    //fungsi pick gambar

    public void btnClick(View v) {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, SELECTED_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //stub method
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SELECTED_PICTURE:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    String[] projection = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(projection[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();

                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                    Drawable d = new BitmapDrawable(yourSelectedImage);

                    imageViewProfile.setBackground(d);
                }
                break;
        }

    }
}
