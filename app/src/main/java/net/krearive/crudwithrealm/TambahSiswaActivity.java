package net.krearive.crudwithrealm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

public class TambahSiswaActivity extends AppCompatActivity {

    private MaterialEditText tvNama;
    private MaterialEditText tvAlamat;
    private Button btnTambah;
    private RealmHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);
        initView();

        helper = new RealmHelper(this);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tvNama.getText().toString();
                String alamat = tvAlamat.getText().toString();
                helper.tambahSiswa(nama, alamat);
                finish();
            }
        });
    }


    private void initView() {
        tvNama = (MaterialEditText) findViewById(R.id.tv_nama);
        tvAlamat = (MaterialEditText) findViewById(R.id.tv_alamat);
        btnTambah = (Button) findViewById(R.id.btn_tambah);
    }
}
