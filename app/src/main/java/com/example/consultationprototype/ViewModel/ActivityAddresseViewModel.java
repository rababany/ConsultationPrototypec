package com.example.consultationprototype.ViewModel;

import android.app.Application;

import com.example.consultationprototype.model.Addresse;
import com.example.consultationprototype.model.AddresseRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ActivityAddresseViewModel extends AndroidViewModel {
    private AddresseRepository addresseRepository;
    private LiveData<List<Addresse>> touteAdresse;

    public ActivityAddresseViewModel(@NonNull Application application) {
        super(application);
        addresseRepository = new AddresseRepository(application);
    }
    public LiveData<List<Addresse>> getTouteAdresse() {
        touteAdresse = addresseRepository.getTab_addqresse();

        return touteAdresse;
    }

    public void ajouterAddresse (Addresse addresse){
        addresseRepository.ajouterAddresse(addresse);
    }
    public void supprimerAddresse (Addresse addresse){
        addresseRepository.enleverAddresse(addresse);
    }
    public void mettre_a_jourAddresse(Addresse addresse){
        addresseRepository.maj_Addresse(addresse);
    }
}
