package com.example.consultationprototype.Model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AddresseDao {

    @Insert
    void insererAddr(Addresse addresse);

    @Update
    void modifierAddr(Addresse addresse);

    @Delete
    void supprimerAddr(Addresse addresse);

    @Query("SELECT * FROM lesAddresses")

    LiveData <List<Addresse>>listerAddr();
}
