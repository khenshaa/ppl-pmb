package ppljoss.ppl2_pmb.Pendaftaran_pack;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import ppljoss.ppl2_pmb.Fragment.BiayaPerkuliahanFragment;
import ppljoss.ppl2_pmb.Fragment.JalurMasukFragment;
import ppljoss.ppl2_pmb.Fragment.PotonganBiayaFragment;
import ppljoss.ppl2_pmb.Pendaftaran;
import ppljoss.ppl2_pmb.R;

import static com.basgeekball.awesomevalidation.utility.RegexTemplate.*;


public class Formulir_test_onsite extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //INISIALISASI
    private static final String TAG = "Formulir_test_onlie";

    private LinearLayout tambah;
    Spinner spAgama, spjaket, sppilihan1, sppilihan2, spjalur, sptahun;
    private EditText tanggallahir;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private CheckBox checkbox;

    AwesomeValidation awesomeValidation;
    Button submit;
    EditText email, password, retypepassword, namalengkap, tempatlahir, tgllahir, nohpcamaru, nohportu, alamat, kecamatan;
    AutoCompleteTextView editTextsekolah;

    //API
    private String URLstring = "https://studentdesk.uai.ac.id/rest/index.php/api/camaru/getProdi/format/json"; //API
    private static ProgressBar mprogressBar; //API
    private ArrayList<String> names = new ArrayList<String>();//API

    /////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onsite);

        //*****************DrawerLayout MENUU Navigation BAR************************************************************************
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ///////************************************************************************************************************


        ///////////////////////FORMULIR************************************
        spAgama = (Spinner) findViewById(R.id.spinneragama);
        spjaket = (Spinner) findViewById(R.id.spinnerjaket);
        sppilihan1 = (Spinner) findViewById(R.id.spinerpilihan1);
        sppilihan2 = (Spinner) findViewById(R.id.spinerpilihan2);
        spjalur = (Spinner) findViewById(R.id.spinnerjalurmasuk);
        sptahun = (Spinner) findViewById(R.id.spinnertahun);
        email = (EditText) findViewById(R.id.etxemail);
        password = (EditText) findViewById(R.id.etxpassword);
        retypepassword = (EditText) findViewById(R.id.etxretype);
        namalengkap = (EditText) findViewById(R.id.etxnamalengkap);
        tempatlahir = (EditText) findViewById(R.id.etxtempatlahir);
        tgllahir = (EditText) findViewById(R.id.etxtanggallahir);
        nohpcamaru = (EditText) findViewById(R.id.etxnohp);
        nohportu = (EditText) findViewById(R.id.etxnohportu);
        alamat = (EditText) findViewById(R.id.etxalamat);
        kecamatan = (EditText) findViewById(R.id.etxkecamatan);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        submit = (Button) findViewById(R.id.btnselesai);

        editTextsekolah = (AutoCompleteTextView) findViewById(R.id.actxsekolah);
        getDataSekolah();
        getDataProdi();
        getDataJalurMasuk();

        //String Spinner
        String[] agama = new String[]{"Islam", "Katholik", "Protestan", "Budha", "Hindu", "Kepercayaan", "Lain-lain"};
        String[] jaket = new String[]{"S", "M", "L", "XL", "XXL", "3XL", "4XL", "5XL", "6XL", "7XL"};
        /*
        //String[] jurusan = new String[]{"Silahkan Pilih", "Teknik Industri", "Teknik Informatika", "Teknik Elektro",
               "Biologi (Biotek)", "Teknologi Pangan", "Gizi", "Manajemen", "Akuntansi", "Akuntansi (Kelas Sore)",
               "Sastra Arab", "Sastra Tiongkok", "Sastra Inggris", "Sastra Jepang", "Bimbingan Konseling Islam", "Pendidikan Agama Islam",
               /"Psikologi", "PG PAUD", "Ilmu Hukum", "Magister Ilmu Hukum", "Hubungan Internasional", "Ilmu Komunikasi"};
        String[] masuk = new String[]{"Test Seleksi", "Unggulan", "PMDK", "PMDK Prestasi Kelas", "PMDK Prestasi Seni dan Olah Raga",
                "PMDK OSIS", "Putra/i Guru/Karyawan YPI", "Putra/i Guru/Karyawan UAI", "Putra/i TNI/Polri non Perwira", "Putra/i Guru Non Sekolah YPI",
                "Alumni UAI", "SMAI Al Azhar", "Guru Al Azhar", "Bagi calon mahasiswa yang memiliki saudara kandung kuliah di UAI", "Bagi calon mahasiswa yang tidak memiliki ayah (yatim)",
                "Test Pindahan", "Pindahan", "OSC Metro TV"};
                */
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

        /*
        //Spinner Pilihan 1
        //ArrayAdapter<String> AdapterJurusan = new ArrayAdapter<String>(Formulir_test_onsite.this, android.R.layout.simple_list_item_1,jurusan);
       //AdapterJurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // sppilihan1.setAdapter(AdapterJurusan);
       // sppilihan2.setAdapter(AdapterJurusan);


        //Spinner Jalur
        ArrayAdapter<String> AdapterJalurmasuk = new ArrayAdapter<String>(Formulir_test_onsite.this, android.R.layout.simple_list_item_1,
                masuk);
        AdapterJalurmasuk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjalur.setAdapter(AdapterJalurmasuk);
        */
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

        ////////////////////////////////////////////*************


        //Validation

        String regexPassword = ".{8,}";
        awesomeValidation.addValidation(Formulir_test_onsite.this, R.id.etxemail, android.util.Patterns.EMAIL_ADDRESS, R.string.email);
        awesomeValidation.addValidation(Formulir_test_onsite.this, R.id.etxpassword, regexPassword, R.string.password);// tambahan di string.xml
        awesomeValidation.addValidation(Formulir_test_onsite.this, R.id.etxretype, R.id.etxpassword, R.string.retype);// tambahan di string.xml
        awesomeValidation.addValidation(Formulir_test_onsite.this, R.id.etxnamalengkap, "[a-zA-Z\\s]+", R.string.nama);// tambahan di string.xml
        awesomeValidation.addValidation(Formulir_test_onsite.this, R.id.etxnohp, TELEPHONE, R.string.nohpcamaru);// tambahan di string.xml
        awesomeValidation.addValidation(Formulir_test_onsite.this, R.id.etxnohportu, TELEPHONE, R.string.nohportu);// tambahan di string.xml

    }


    //*************************SETTING API******************************************
    //method API data sekolah
    private void getDataSekolah() {
        String url = "https://studentdesk.uai.ac.id/rest/index.php/api/camaru/getSekolah/format/json";
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("admin", "1234");

        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    List<String> sekolah = new ArrayList<String>();
                    JSONObject jsonObject = new JSONObject(response.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);

                        String namaSekolah = object.getString("sekolah");
                        sekolah.add(namaSekolah);
                        Log.d("DataNamaSekolah", namaSekolah + "");
                    }
                    ArrayAdapter<String> spinnersekolah = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, sekolah);
                    spinnersekolah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    editTextsekolah.setAdapter(spinnersekolah);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    //method API data jalur masuk
    private void getDataJalurMasuk() {
        String url = "https://studentdesk.uai.ac.id/rest/index.php/api/camaru/getJalurMasuk/format/json";
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("admin", "1234");

        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    List<String> jalurmasuk = new ArrayList<String>();
                    JSONObject jsonObject = new JSONObject(response.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);

                        String namaJalurMasuk = object.getString("JalurMasuk");
                        jalurmasuk.add(namaJalurMasuk);
                        Log.d("DataJalurMasuk", namaJalurMasuk + "");
                    }
                    ArrayAdapter<String> spinnerjalur = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, jalurmasuk);
                    spinnerjalur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spjalur.setAdapter(spinnerjalur);
                    spinnerjalur.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    //method API data prodi
    private void getDataProdi() {
        String url = "https://studentdesk.uai.ac.id/rest/index.php/api/camaru/getProdi/format/json";
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("admin", "1234");

        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    List<String> namaProdi = new ArrayList<String>();

                    JSONObject jsonObject = new JSONObject(response.toString());
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);

                        String namaProgramStudi = object.getString("NamaProgdi");
                        namaProdi.add(namaProgramStudi);
                        Log.d("DataProdi", namaProgramStudi + "");
                    }
                    ArrayAdapter<String> spinnerprodi1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, namaProdi);
                    spinnerprodi1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sppilihan1.setAdapter(spinnerprodi1);
                    spinnerprodi1.notifyDataSetChanged();

                    ArrayAdapter<String> spinnerprodi2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, namaProdi);
                    spinnerprodi2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sppilihan2.setAdapter(spinnerprodi2);
                    spinnerprodi2.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }


    //////////////*********************************************************************************************************************


    //SETTING DRAWER LAYOUT
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.halamanpendaftaran) {
            Toast.makeText(getApplicationContext(), "halaman pendaftaran", Toast.LENGTH_LONG).show();
            Intent tohamalanpendaftaran = new Intent(Formulir_test_onsite.this, Pendaftaran.class);
            startActivity(tohamalanpendaftaran);
        } else if (id == R.id.formulirpendaftaran) {
            Toast.makeText(getApplicationContext(), "Formulir Pendaftaran Test On Site", Toast.LENGTH_LONG).show();
            Intent todaftaronsite = new Intent(Formulir_test_onsite.this, Formulir_test_onsite.class);
            startActivity(todaftaronsite);
        } else if (id == R.id.biayaperkuliahan) {
            Toast.makeText(getApplicationContext(), "biaya perkuliahan", Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new BiayaPerkuliahanFragment()).commit();
        } else if (id == R.id.potonganbiaya) {
            Toast.makeText(getApplicationContext(), "potongan biaya", Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new PotonganBiayaFragment()).commit();
        } else if (id == R.id.jalurmasuk) {
            Toast.makeText(getApplicationContext(), "jalur masuk", Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new JalurMasukFragment()).commit();
        } else if (id == R.id.faq) {
            Toast.makeText(getApplicationContext(), "FAQ", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    ///////************************************************************************************************************
}
