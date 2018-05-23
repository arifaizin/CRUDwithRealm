package net.krearive.crudwithrealm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<ModelSiswa> dataSiswa = new ArrayList<>();
    private RealmHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahSiswaActivity.class));

            }
        });
        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        // data
//        ModelSiswa siswa1 = new ModelSiswa(1, "Dona", "Grogol");
//        dataSiswa.add(siswa1);
//
//        ModelSiswa siswa2 = new ModelSiswa();
//        siswa2.setId(2);
//        siswa2.setNama("Willy");
//        siswa2.setAlamat("Semarang");
//        dataSiswa.add(siswa2);


        helper = new RealmHelper(MainActivity.this);
//        helper.inputDataAwal();
//        dataSiswa = helper.tampilDataSiswa();

        // adapter
        recycler.setAdapter(new SiswaAdapter(MainActivity.this, dataSiswa));

        // layout manager
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        setData();
    }

    private void setData() {
        dataSiswa = helper.tampilDataSiswa();
        // adapter
        recycler.setAdapter(new SiswaAdapter(MainActivity.this, dataSiswa));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
