package com.example.consultationprototype.Model;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;

import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "lespatients",
        indices = {@Index("id_diag_patient"),@Index("id_addr_patient")}
        ,foreignKeys ={

        @ForeignKey(entity = Addresse.class,parentColumns = "id_add",childColumns = "id_addr_patient",onDelete = CASCADE),
        @ForeignKey(entity = Diagnostic.class,parentColumns = "id_diagnostic",childColumns = "id_diag_patient",onDelete = CASCADE )
})

public class Patient extends BaseObservable {
    @PrimaryKey(autoGenerate = true)
    private long id_patient;

    @ColumnInfo(name = "age_patient")
    private  String age_patient;

    @ColumnInfo(name = "sexe_patient")
    private  String sexe_patient;

    @ColumnInfo(name = "poids_patient")
    private  long poids_patient;

    @ColumnInfo(name = "taille_patient")
    private  long taille_patient;

    @ColumnInfo(name = "pb_patient")
    private  long pb_patient;

    @ColumnInfo(name = "id_diag_patient")
    private  long id_diag_patient;

    @ColumnInfo(name = "id_addr_patient")
    private long id_addr_patient;

    @ColumnInfo(name = "dateconsult_patient")
    private String dateconsult_patient;

    @Ignore
    public Patient() {
    }

    public Patient(long id_patient, String age_patient, String sexe_patient, long poids_patient, long taille_patient, long pb_patient, long id_diag_patient, long id_addr_patient, String dateconsult_patient) {
        this.id_patient = id_patient;
        this.age_patient = age_patient;
        this.sexe_patient = sexe_patient;
        this.poids_patient = poids_patient;
        this.taille_patient = taille_patient;
        this.pb_patient = pb_patient;
        this.id_diag_patient = id_diag_patient;
        this.id_addr_patient = id_addr_patient;
        this.dateconsult_patient = dateconsult_patient;
    }
    @Bindable
    public long getId_patient() {
        return id_patient;
    }

    public void setId_patient(long id_patient) {
        this.id_patient = id_patient;
        notifyPropertyChanged(BR.id_patient);

    }
    @Bindable
    public String getAge_patient() {
        return age_patient;
    }

    public void setAge_patient(String age_patient) {
        this.age_patient = age_patient;
        notifyPropertyChanged(BR.age_patient);

    }
    @Bindable
    public String getSexe_patient() {
        return sexe_patient;
    }

    public void setSexe_patient(String sexe_patient) {
        this.sexe_patient = sexe_patient;
        notifyPropertyChanged(BR.sexe_patient);

    }
    @Bindable
    public long getPoids_patient() {
        return poids_patient;
    }

    public void setPoids_patient(long poids_patient) {
        this.poids_patient = poids_patient;
        notifyPropertyChanged(BR.poids_patient);


    }
    @Bindable
    public long getTaille_patient() {
        return taille_patient;
    }

    public void setTaille_patient(long taille_patient) {
        this.taille_patient = taille_patient;
        notifyPropertyChanged(BR.taille_patient);

    }
    @Bindable
    public long getPb_patient() {
        return pb_patient;
    }

    public void setPb_patient(long pb_patient) {
        this.pb_patient = pb_patient;
        notifyPropertyChanged(BR.pb_patient);


    }
    @Bindable
    public long getId_diag_patient() {
        return id_diag_patient;
    }

    public void setId_diag_patient(long id_diag_patient) {
        this.id_diag_patient = id_diag_patient;
        notifyPropertyChanged(BR.id_diag_patient);


    }
    @Bindable
    public long getId_addr_patient() {
        return id_addr_patient;
    }

    public void setId_addr_patient(long id_addr_patient) {
        this.id_addr_patient = id_addr_patient;
        notifyPropertyChanged(BR.id_addr_patient);


    }
    @Bindable
    public String getDateconsult_patient() {
        return dateconsult_patient;
    }

    public void setDateconsult_patient(String dateconsult_patient) {
        this.dateconsult_patient = dateconsult_patient;
        notifyPropertyChanged(BR.dateconsult_patient);

    }
}
