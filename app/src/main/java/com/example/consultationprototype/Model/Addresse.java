package com.example.consultationprototype.Model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "lesAddresses",indices = {@Index(value = {"id_add"},unique = true)})
public class Addresse extends BaseObservable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_add")
    private long id_addr;
    @ColumnInfo(name = "fokontany")
    private  String fokontany;
    @ColumnInfo(name = "hammeau")
    private String hammeau;

    @Ignore
    public Addresse() {
    }

    public Addresse(long id_addr, String fokontany, String hammeau) {
        this.id_addr = id_addr;
        this.fokontany = fokontany;
        this.hammeau = hammeau;
    }
    @Bindable
    public long getId_addr() {
        return id_addr;
    }

    public void setId_addr(long id_addr) {
        this.id_addr = id_addr;
        notifyPropertyChanged(BR.id_addr);


    }
    @Bindable
    public String getFokontany() {
        return fokontany;
    }

    public void setFokontany(String fokontany) {
        this.fokontany = fokontany;
        notifyPropertyChanged(BR.fokontany);


    }
    @Bindable
    public String getHammeau() {
        return hammeau;
    }

    public void setHammeau(String hammeau) {
        this.hammeau = hammeau;
        notifyPropertyChanged(BR.hammeau);


    }
}
