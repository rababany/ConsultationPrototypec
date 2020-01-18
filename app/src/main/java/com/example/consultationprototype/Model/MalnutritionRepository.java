package com.example.consultationprototype.Model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MalnutritionRepository {
    private MalnutritionDao malnutritionDao;
    private LiveData<List<Malnutrition>> tab_malnutrition;

    public MalnutritionRepository(Application application) {
        ConsultationBDD consultationBDD = ConsultationBDD.getInstance(application);
        malnutritionDao = consultationBDD.malnutritionDao();

    }

    public LiveData<List<Malnutrition>> getTab_malnutrition() {
        return malnutritionDao.listerMalt();
    }

    public void ajouterMalnutrition(Malnutrition malnutrition){
        new InsererMaltasynctask(malnutritionDao).execute(malnutrition);
    }

    private static class InsererMaltasynctask extends AsyncTask<Malnutrition,Void ,Void > {

        private MalnutritionDao malnutritionDao;


        public InsererMaltasynctask(MalnutritionDao malnutritionDao) {
            this.malnutritionDao = malnutritionDao;
        }

        @Override
        protected Void doInBackground(Malnutrition... malnutritions) {
            malnutritionDao.insererMalt(malnutritions[0]);
                return null;
        }
    }
    public void enleverAddresse(Malnutrition malnutrition){
        new EnleverMaltasynctask(malnutritionDao).execute(malnutrition);
    }

    private static class EnleverMaltasynctask extends AsyncTask<Malnutrition,Void ,Void > {

        private MalnutritionDao malnutritionDao;


        public EnleverMaltasynctask(MalnutritionDao malnutritionDao) {
            this.malnutritionDao = malnutritionDao;
        }

        @Override
        protected Void doInBackground(Malnutrition... malnutritions) {
            malnutritionDao.supprimerMalt(malnutritions[0]);
                return null;
        }
    }
    public void maj_Addresse(Malnutrition malnutrition){
        new Maj_Maltasynctask(malnutritionDao).execute(malnutrition);
    }

    private static class Maj_Maltasynctask extends AsyncTask<Malnutrition,Void ,Void > {

        private MalnutritionDao malnutritionDao;


        public Maj_Maltasynctask(MalnutritionDao malnutritionDao) {
            this.malnutritionDao = malnutritionDao;
        }

        @Override
        protected Void doInBackground(Malnutrition... malnutritions) {
            malnutritionDao.modifierMalt(malnutritions[0]);
                return null;
        }
    }

}
