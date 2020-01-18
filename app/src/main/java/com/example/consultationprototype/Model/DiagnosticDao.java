package com.example.consultationprototype.Model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DiagnosticDao {
    @Insert
    void insererDiag(Diagnostic diagnostic);

    @Update
    void modifierDiag(Diagnostic diagnostic);

    @Delete
    void supprimerDiag(Diagnostic diagnostic);

    @Query("SELECT * FROM lesdiagnostics")
    LiveData<List<Diagnostic>> listerDiag();
}
