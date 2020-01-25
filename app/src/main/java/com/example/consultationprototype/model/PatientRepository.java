package com.example.consultationprototype.model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;

public class PatientRepository {
    private PatientDao patientDao;
    private LiveData<List<Patient>> tab_patient;
    private Executor executor;

    public PatientRepository(Application application) {
        executor = Executors.newFixedThreadPool(5);
        ConsultationBDD consultationBDD = ConsultationBDD.getInstance(application);
        patientDao = consultationBDD.patientDao();


    }

    public LiveData<List<Patient>> getTab_patient() {
        return patientDao.listerPat();
    }
    public LiveData<List<Patient>> getTab_patientAddr(long idAddrPatient) {
        return patientDao.listerPatAddr(idAddrPatient);
    }

    public void ajouterPatient(final Patient patient){

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                patientDao.insererPat(patient);
            }
        });
    }


    public void enleverPatient(final Patient patient){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                patientDao.supprimerPat(patient);
            }
        });
    }


    public void maj_Patient(final Patient patient){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                patientDao.modifierPat(patient);
            }
        });
    }


}
