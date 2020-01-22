package com.example.consultationprototype.ViewModel;

import android.app.Application;

import com.example.consultationprototype.model.Malnutrition;
import com.example.consultationprototype.model.MalnutritionRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ActivityMalnutritionViewModel extends AndroidViewModel {
    private MalnutritionRepository malnutritionRepository;
    private LiveData<List<Malnutrition>> toutMalnutrition;

    public ActivityMalnutritionViewModel(@NonNull Application application) {
        super(application);
        malnutritionRepository = new MalnutritionRepository(application);
    }
    public LiveData<List<Malnutrition>> getToutMalnutrition() {
        toutMalnutrition =malnutritionRepository.getTab_malnutrition();
        return toutMalnutrition;
    }

    public void ajouterMalnutrion (Malnutrition malnutrition){
        malnutritionRepository.ajouterMalnutrition(malnutrition);
    }
    public void supprimerMalnutrition (Malnutrition malnutrition){
        malnutritionRepository.enleverMalnutrition(malnutrition);
    }
    public void mettre_a_jourMalnutrition(Malnutrition malnutrition){
        malnutritionRepository.maj_Malnutrition(malnutrition);
    }
}
