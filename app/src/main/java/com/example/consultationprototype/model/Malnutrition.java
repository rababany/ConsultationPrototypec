package com.example.consultationprototype.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "lesmalnutritions")
public class Malnutrition extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id_malnutrition")
    private long id_malnutrition;
    @ColumnInfo(name = "poids_taille")
    private String poids_taille;
    @ColumnInfo(name = "poids_age")
    private String poids_age;
    @ColumnInfo(name = "oedeme")
    private boolean oedeme;
    @Ignore
    public Malnutrition() {
    }

    public Malnutrition(long id_malnutrition, String poids_taille, String poids_age, boolean oedeme) {
        this.id_malnutrition = id_malnutrition;
        this.poids_taille = poids_taille;
        this.poids_age = poids_age;
        this.oedeme = oedeme;
    }
    @Bindable
    public long getId_malnutrition() {
        return id_malnutrition;
    }

    public void setId_malnutrition(long id_malnutrition) {
        this.id_malnutrition = id_malnutrition;
        notifyPropertyChanged(BR.id_malnutrition);

    }
    @Bindable
    public String getPoids_taille() {
        return poids_taille;
    }

    public void setPoids_taille(String poids_taille) {
        this.poids_taille = poids_taille;
        notifyPropertyChanged(BR.poids_taille);

    }
    @Bindable
    public String getPoids_age() {
        return poids_age;
    }

    public void setPoids_age(String poids_age) {
        this.poids_age = poids_age;
        notifyPropertyChanged(BR.poids_age);

    }
    @Bindable
    public boolean isOedeme() {
        return oedeme;
    }

    public void setOedeme(boolean oedeme) {
        this.oedeme = oedeme;
        notifyPropertyChanged(BR.oedeme);
    }
}
