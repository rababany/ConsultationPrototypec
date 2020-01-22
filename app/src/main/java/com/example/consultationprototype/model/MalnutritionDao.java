package com.example.consultationprototype.model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface MalnutritionDao {
    @Insert
    void insererMalt(Malnutrition malnutrition);

    @Update
    void modifierMalt(Malnutrition malnutrition);

    @Delete
    void supprimerMalt(Malnutrition malnutrition);

    @Query("SELECT * FROM lesmalnutritions")
    LiveData<List<Malnutrition>> listerMalt();

}
