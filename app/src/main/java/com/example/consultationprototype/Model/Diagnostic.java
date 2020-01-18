package com.example.consultationprototype.Model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "lesdiagnostics",indices = {@Index(value = {"id_diagnostic"},unique = true)})
public class Diagnostic extends BaseObservable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_diagnostic")
    private long id_diagnostic;
    @ColumnInfo(name = "category_diagnostic")
    private String category_diagnostic;
    @ColumnInfo(name = "signe")
    private String signe;
    @Ignore
    public Diagnostic() {
    }

    public Diagnostic(long id_diagnostic, String category_diagnostic, String signe) {
        this.id_diagnostic = id_diagnostic;
        this.category_diagnostic = category_diagnostic;
        this.signe = signe;
    }
    @Bindable
    public long getId_diagnostic() {
        return id_diagnostic;
    }

    public void setId_diagnostic(long id_diagnostic) {
        this.id_diagnostic = id_diagnostic;
        notifyPropertyChanged(BR.id_diagnostic);
            }
    @Bindable
    public String getCategory_diagnostic() {
        return category_diagnostic;
    }

    public void setCategory_diagnostic(String category_diagnostic) {
        this.category_diagnostic = category_diagnostic;
        notifyPropertyChanged(BR.category_diagnostic);

    }
    @Bindable
    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
        notifyPropertyChanged(BR.signe);
    }
}
