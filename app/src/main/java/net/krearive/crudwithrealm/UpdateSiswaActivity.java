package net.krearive.crudwithrealm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

public class UpdateSiswaActivity extends AppCompatActivity {

    private MaterialEditText tvNama;
    private MaterialEditText tvAlamat;
    private Button btnUpdate, btnHapus;
    private RealmHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_siswa);

        final int id = getIntent().getIntExtra("DATA_ID", 0);
        String nama = getIntent().getStringExtra("DATA_NAMA");
        String alamat = getIntent().getStringExtra("DATA_ALAMAT");

        initView();

        tvNama.setText(nama);
        tvAlamat.setText(alamat);

        helper = new RealmHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tvNama.getText().toString();
                String alamat = tvAlamat.getText().toString();
                helper.updateSiswa(id, nama, alamat);
                finish();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.deleteSiswa(id);
                finish();
            }
        });
    }


    private void initView() {
        tvNama = (MaterialEditText) findViewById(R.id.tv_nama);
        tvAlamat = (MaterialEditText) findViewById(R.id.tv_alamat);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnHapus = (Button) findViewById(R.id.btn_hapus);
    }
}
