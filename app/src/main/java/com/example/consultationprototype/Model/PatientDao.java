package com.example.consultationprototype.Model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface PatientDao {
    @Insert
    void insererPat(Patient patient);

    @Update
    void modifierPat(Patient patient);

    @Delete
    void supprimerPat(Patient patient);

    @Query("SELECT * FROM lespatients")
    LiveData<List<Patient>> listerPat();





}
