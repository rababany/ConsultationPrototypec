package com.example.consultationprototype.ViewModel;

import android.app.Application;

import com.example.consultationprototype.Model.Addresse;
import com.example.consultationprototype.Model.AddresseRepository;
import com.example.consultationprototype.Model.ConsultationBDD;
import com.example.consultationprototype.Model.Diagnostic;
import com.example.consultationprototype.Model.DiagnosticRepository;
import com.example.consultationprototype.Model.Malnutrition;
import com.example.consultationprototype.Model.MalnutritionRepository;
import com.example.consultationprototype.Model.Patient;
import com.example.consultationprototype.Model.PatientRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ActivityMainViewModel extends AndroidViewModel {
    private PatientRepository patientRepository;
    private LiveData<List<Patient>> toutPatient;
    private AddresseRepository addresseRepository;
    private LiveData<List<Addresse>> touteAdresse;
    private DiagnosticRepository diagnosticRepository;
    private LiveData<List<Diagnostic>> toutDiagnostic;
    private MalnutritionRepository malnutritionRepository;
    private LiveData<List<Malnutrition>> toutMalnutrition;

    public ActivityMainViewModel(@NonNull Application application) {
        super(application);
        patientRepository = new PatientRepository(application);
        addresseRepository = new AddresseRepository(application);
        diagnosticRepository = new DiagnosticRepository(application);
        malnutritionRepository = new MalnutritionRepository(application);

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





    public LiveData<List<Diagnostic>> getToutDiagnostic() {
        toutDiagnostic =diagnosticRepository.getTab_diagnostic();
        return toutDiagnostic;
    }

    public void ajouterDiagnostic (Diagnostic diagnostic){
        diagnosticRepository.ajouterDiagnostic(diagnostic);
    }
    public void supprimerDiagnostic (Diagnostic diagnostic){
        diagnosticRepository.enleverDiagnostic(diagnostic);
    }
    public void mettre_a_jourDiagnostic(Diagnostic diagnostic){
        diagnosticRepository.maj_Diagnostic(diagnostic);
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
