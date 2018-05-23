package net.krearive.crudwithrealm;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by idn on 5/23/2018.
 */

public class RealmHelper {
    private Context context;
    private Realm realm;
    private RealmResults<ModelSiswa> realmResults;

    //logt
    private static final String TAG = "RealmHelper";

    public RealmHelper(Context context) {
        this.context = context;
        realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void inputDataAwal(){
        ModelSiswa siswa = new ModelSiswa();
        siswa.setId(1);
        siswa.setNama("Joni");
        siswa.setAlamat("Ambarawa");

        realm.beginTransaction();
        realm.copyToRealm(siswa);
        realm.commitTransaction();

        //logd
        Log.d(TAG, "inputDataAwal: Data berhasil ditambah");
    }

    public ArrayList<ModelSiswa> tampilDataSiswa(){
        ArrayList<ModelSiswa> data = new ArrayList<>();
        realmResults = realm.where(ModelSiswa.class).findAll();
        realmResults.sort("id", Sort.ASCENDING);

        if(realmResults.size() > 0){
            Log.d(TAG, "tampilDataSiswa: Size :"+ realmResults.size());
            for (int i = 0; i < realmResults.size(); i++) {
                ModelSiswa siswa = new ModelSiswa();
                siswa.setId(realmResults.get(i).getId());
                siswa.setNama(realmResults.get(i).getNama());
                siswa.setAlamat(realmResults.get(i).getAlamat());
                data.add(siswa);

            }
        } else {
            Log.d(TAG, "tampilDataSiswa: Data Kosong");
        }
        return data;
    }


    public void tambahSiswa(String nama, String alamat){
        ModelSiswa siswa = new ModelSiswa();
        siswa.setId((int) (System.currentTimeMillis()/1000));
        siswa.setNama(nama);
        siswa.setAlamat(alamat);

        realm.beginTransaction();
        realm.copyToRealm(siswa);
        realm.commitTransaction();

        //logd
        Log.d(TAG, "Data berhasil ditambah");
    }

    public void updateSiswa(int id, String nama, String alamat){
        realm.beginTransaction();
        ModelSiswa siswa = realm.where(ModelSiswa.class).equalTo("id", id).findFirst();
        siswa.setNama(nama);
        siswa.setAlamat(alamat);
        realm.copyToRealm(siswa);
        realm.commitTransaction();

        //logd
        Log.d(TAG, "Data berhasil diupdate");
    }

    public void deleteSiswa(int id){
        realm.beginTransaction();
        RealmResults<ModelSiswa> siswa = realm.where(ModelSiswa.class).equalTo("id", id).findAll();
        siswa.deleteAllFromRealm();
        realm.commitTransaction();

        //logd
        Log.d(TAG, "Data berhasil diupdate");
    }

}
