package com.example.consultationprototype.model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class PatientRepository {
    private PatientDao patientDao;
    private LiveData<List<Patient>> tab_patient;

    public PatientRepository(Application application) {
        ConsultationBDD consultationBDD = ConsultationBDD.getInstance(application);
        patientDao = consultationBDD.patientDao();

    }

    public LiveData<List<Patient>> getTab_patient() {
        return patientDao.listerPat();
    }
    public LiveData<List<Patient>> getTab_patientAddr(long idAddrPatient) {
        return patientDao.listerPatAddr(idAddrPatient);
    }

    public void ajouterPatient(Patient patient){
        new InsererPatientasynctask(patientDao).execute(patient);
    }

    private static class InsererPatientasynctask extends AsyncTask <Patient,Void ,Void > {

        private PatientDao patientDao;


        public InsererPatientasynctask(PatientDao patientDao) {
            this.patientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {
            patientDao.insererPat(patients[0]);
                return null;
        }
    }
    public void enleverPatient(Patient patient){
        new EnleverPatientasynctask(patientDao).execute(patient);
    }

    private static class EnleverPatientasynctask extends AsyncTask <Patient,Void ,Void > {

        private PatientDao patientDao;


        public EnleverPatientasynctask(PatientDao patientDao) {
            this.patientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {
            patientDao.supprimerPat(patients[0]);
            return null;
        }
    }
    public void maj_Patient(Patient patient){
        new Maj_Patientasynctask(patientDao).execute(patient);
    }

    private static class Maj_Patientasynctask extends AsyncTask <Patient,Void ,Void > {

        private PatientDao patientDao;


        public Maj_Patientasynctask(PatientDao patientDao) {
            this.patientDao = patientDao;
        }

        @Override
        protected Void doInBackground(Patient... patients) {
            patientDao.modifierPat(patients[0]);
            return null;
        }
    }
}
