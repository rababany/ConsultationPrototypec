package com.example.consultationprototype.ViewModel;

import android.app.Application;

import com.example.consultationprototype.Model.Patient;
import com.example.consultationprototype.Model.PatientRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ActivityPatientViewModel extends AndroidViewModel {
    private PatientRepository patientRepository;
    private LiveData<List<Patient>> toutPatient;

    public ActivityPatientViewModel(@NonNull Application application) {
        super(application);
        patientRepository = new PatientRepository(application);
    }
    public LiveData<List<Patient>> getToutPatient() {
        toutPatient = patientRepository.getTab_patient();
        return toutPatient;
    }
    public void ajouterPatient (Patient patient){
        patientRepository.ajouterPatient(patient);
    }
    public void supprimerPatient (Patient patient){
        patientRepository.enleverPatient(patient);
    }
    public void mettre_a_jourPatient(Patient patient){
        patientRepository.maj_Patient(patient);
    }
}
