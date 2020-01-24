package com.example.consultationprototype.model;


import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
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
    private long idPatient;

    @ColumnInfo(name = "age_patient")
    private  String agePatient;

    @ColumnInfo(name = "sexe_patient")
    private  String sexePatient;

    @ColumnInfo(name = "poids_patient")
    private  long poidsPatient;

    @ColumnInfo(name = "taille_patient")
    private  long taillePatient;

    @ColumnInfo(name = "pb_patient")
    private  long pbPatient;

    @ColumnInfo(name = "id_diag_patient")
    private  long idDiagPatient;

    @ColumnInfo(name = "id_addr_patient")
    private long idAddrPatient;

    @ColumnInfo(name = "dateconsult_patient")
    private String dateconsultPatient;

    @Ignore
    public Patient() {
    }

    public Patient(long idPatient, String agePatient, String sexePatient, long poidsPatient, long taillePatient, long pbPatient, long idDiagPatient, long idAddrPatient, String dateconsultPatient) {
        this.idPatient = idPatient;
        this.agePatient = agePatient;
        this.sexePatient = sexePatient;
        this.poidsPatient = poidsPatient;
        this.taillePatient = taillePatient;
        this.pbPatient = pbPatient;
        this.idDiagPatient = idDiagPatient;
        this.idAddrPatient = idAddrPatient;
        this.dateconsultPatient = dateconsultPatient;
    }
    @Bindable
    public long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(long idPatient) {
        this.idPatient = idPatient;
        notifyPropertyChanged(BR.idPatient);
    }
    @Bindable
    public String getAgePatient() {
        return agePatient;
    }

    public void setAgePatient(String agePatient) {
        this.agePatient = agePatient;
        notifyPropertyChanged(BR.agePatient);
    }
    @Bindable
    public String getSexePatient() {
        return sexePatient;
    }

    public void setSexePatient(String sexePatient) {
        this.sexePatient = sexePatient;
        notifyPropertyChanged(BR.sexePatient);
    }
    @Bindable
    public long getPoidsPatient() {
        return poidsPatient;
    }

    public void setPoidsPatient(long poidsPatient) {
        this.poidsPatient = poidsPatient;
        notifyPropertyChanged(BR.poidsPatient);
    }
    @Bindable
    public long getTaillePatient() {
        return taillePatient;
    }

    public void setTaillePatient(long taillePatient) {
        this.taillePatient = taillePatient;
        notifyPropertyChanged(BR.taillePatient);
    }
    @Bindable
    public long getPbPatient() {
        return pbPatient;
    }

    public void setPbPatient(long pbPatient) {
        this.pbPatient = pbPatient;
        notifyPropertyChanged(BR.pbPatient);
    }
    @Bindable
    public long getIdDiagPatient() {
        return idDiagPatient;
    }

    public void setIdDiagPatient(long idDiagPatient) {
        this.idDiagPatient = idDiagPatient;
        notifyPropertyChanged(BR.idDiagPatient);
    }
    @Bindable
    public long getIdAddrPatient() {
        return idAddrPatient;
    }

    public void setIdAddrPatient(long idAddrPatient) {
        this.idAddrPatient = idAddrPatient;
        notifyPropertyChanged(BR.idAddrPatient);
    }
    @Bindable
    public String getDateconsultPatient() {
        return dateconsultPatient;
    }

    public void setDateconsultPatient(String dateconsultPatient) {
        this.dateconsultPatient = dateconsultPatient;
        notifyPropertyChanged(BR.dateconsultPatient);
    }
    @BindingAdapter("android:text")
    public static void setText(TextView view, long value) {
        boolean setValue = view.getText().length() == 0;
        try {
            if (!setValue){
                setValue = Long.parseLong(view.getText().toString()) !=value;
            }
        } catch (NumberFormatException e){

        }
        if (setValue){
            view.setText(String.valueOf(value));
        }

    }

    @InverseBindingAdapter(attribute = "android:text")
    public static long getText(TextView view) {

        try {
            return Long.parseLong(view.getText().toString());
        } catch (NumberFormatException e)
        {
            return 0;
        }
    }

}
