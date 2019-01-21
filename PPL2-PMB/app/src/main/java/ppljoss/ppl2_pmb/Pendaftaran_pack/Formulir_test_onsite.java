package ppljoss.ppl2_pmb.Pendaftaran_pack;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.text.Normalizer;
import java.util.Calendar;
import java.util.List;

import ppljoss.ppl2_pmb.R;

public class Formulir_test_onsite extends AppCompatActivity {

    private static final String TAG = "Formulir_test_onlie";

    private LinearLayout tambah;
    Spinner spAgama, spjaket, sppilihan1, sppilihan2, spjalur, sptahun;
    private EditText tanggallahir;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private CheckBox checkbox;
    private ImageButton buttonsidemenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_test_onsite);

        spAgama = (Spinner) findViewById(R.id.spinneragama);
        spjaket = (Spinner) findViewById(R.id.spinnerjaket);
        sppilihan1 = (Spinner) findViewById(R.id.spinerpilihan1);
        sppilihan2 = (Spinner) findViewById(R.id.spinerpilihan2);
        spjalur = (Spinner) findViewById(R.id.spinnerjalurmasuk);
        sptahun = (Spinner) findViewById(R.id.spinnertahun);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pendaftaran Test-On Site");

//String Spinner
        String[] agama = new String[]{"Islam", "Katholik", "Protestan", "Budha", "Hindu", "Kepercayaan", "Lain-lain"};
        String[] jaket = new String[]{"S", "M", "L", "XL", "XXL", "3XL", "4XL", "5XL", "6XL", "7XL"};
        String[] jurusan = new String[]{"Silahkan Pilih", "Teknik Industri", "Teknik Informatika", "Teknik Elektro",
                "Biologi (Biotek)", "Teknologi Pangan", "Gizi", "Manajemen", "Akuntansi", "Akuntansi (Kelas Sore)",
                "Sastra Arab", "Sastra Tiongkok", "Sastra Inggris", "Sastra Jepang", "Bimbingan Konseling Islam", "Pendidikan Agama Islam",
                "Psikologi", "PG PAUD", "Ilmu Hukum", "Magister Ilmu Hukum", "Hubungan Internasional", "Ilmu Komunikasi"};
        String[] masuk = new String[]{"Test Seleksi", "Unggulan", "PMDK", "PMDK Prestasi Kelas", "PMDK Prestasi Seni dan Olah Raga",
                "PMDK OSIS", "Putra/i Guru/Karyawan YPI", "Putra/i Guru/Karyawan UAI", "Putra/i TNI/Polri non Perwira", "Putra/i Guru Non Sekolah YPI",
                "Alumni UAI", "SMAI Al Azhar", "Guru Al Azhar", "Bagi calon mahasiswa yang memiliki saudara kandung kuliah di UAI", "Bagi calon mahasiswa yang tidak memiliki ayah (yatim)",
                "Test Pindahan", "Pindahan", "OSC Metro TV"};
        String[] tahun = new String[]{" 2019", "2018", "2017", "2016", "2015", "2014", "2013", "2010", "2009"};

//Array Adapter Spinner
        //Spinner Agama
        ArrayAdapter<String> Adapteragama = new ArrayAdapter<String>(Formulir_test_onsite.this, android.R.layout.simple_list_item_1,
                agama);
        Adapteragama.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAgama.setAdapter(Adapteragama);

        //Spinner Jaket
        ArrayAdapter<String> AdapterJaket = new ArrayAdapter<String>(Formulir_test_onsite.this, android.R.layout.simple_list_item_1,
                jaket);
        AdapterJaket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjaket.setAdapter(AdapterJaket);

        //Spinner Pilihan 1
        ArrayAdapter<String> AdapterJurusan = new ArrayAdapter<String>(Formulir_test_onsite.this, android.R.layout.simple_list_item_1,
                jurusan);
        AdapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sppilihan1.setAdapter(AdapterJurusan);
        sppilihan2.setAdapter(AdapterJurusan);
        //Spinner Jalur
        ArrayAdapter<String> AdapterJalurmasuk = new ArrayAdapter<String>(Formulir_test_onsite.this, android.R.layout.simple_list_item_1,
                masuk);
        AdapterJalurmasuk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjalur.setAdapter(AdapterJalurmasuk);
        //Spinner Tahun
        ArrayAdapter<String> AdapterTahun = new ArrayAdapter<String>(Formulir_test_onsite.this, android.R.layout.simple_list_item_1,
                tahun);
        AdapterTahun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptahun.setAdapter(AdapterTahun);


        tanggallahir = (EditText) findViewById(R.id.etxtanggallahir);
        tanggallahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Formulir_test_onsite.this, android.R.style.Theme_Material_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                tanggallahir.setText(date);

            }
        };

        checkbox = (CheckBox) findViewById(R.id.cbcek);
        tambah = (LinearLayout) findViewById(R.id.layouttambahsekolah);

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox.isChecked()) {
                    tambah.setVisibility(View.VISIBLE);
                } else if (!checkbox.isChecked()) {
                    tambah.setVisibility(View.GONE);
                }

            }
        });


        buttonsidemenu = (ImageButton) findViewById(R.id.sidemenubtn);


    }


}


