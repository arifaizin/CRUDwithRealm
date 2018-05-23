package net.krearive.crudwithrealm;

import io.realm.RealmObject;

/**
 * Created by idn on 9/26/2017.
 */

public class ModelSiswa extends RealmObject {
    private int id;
    private String nama;
    private String alamat;

    public ModelSiswa(int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public ModelSiswa() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
