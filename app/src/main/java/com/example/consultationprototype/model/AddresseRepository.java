package com.example.consultationprototype.model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AddresseRepository {
    private AddresseDao addresseDao;
    private LiveData<List<Addresse>>tab_addqresse;

    public AddresseRepository(Application application) {
    ConsultationBDD consultationBDD = ConsultationBDD.getInstance(application);
    addresseDao = consultationBDD.addresseDao();

    }

    public LiveData<List<Addresse>> getTab_addqresse() {
        return addresseDao.listerAddr();
    }

    public void ajouterAddresse(Addresse addresse){
        new InsererAddrasynctask(addresseDao).execute(addresse);
    }

    private static class InsererAddrasynctask extends AsyncTask <Addresse,Void ,Void > {

        private AddresseDao addresseDao;

        public InsererAddrasynctask(AddresseDao addresseDao) {
            this.addresseDao = addresseDao;
        }

        @Override
        protected Void doInBackground(Addresse... addresses) {
            addresseDao.insererAddr(addresses[0]);
                return null;
        }
    }
    public void enleverAddresse(Addresse addresse){
        new SupprimerrAddrasynctask(addresseDao).execute(addresse);
    }

    private static class SupprimerrAddrasynctask extends AsyncTask <Addresse,Void ,Void > {

        private AddresseDao addresseDao;

        public SupprimerrAddrasynctask(AddresseDao addresseDao) {
            this.addresseDao = addresseDao;
        }

        @Override
        protected Void doInBackground(Addresse... addresses) {
            addresseDao.supprimerAddr(addresses[0]);
                return null;
        }
    }
    public void maj_Addresse(Addresse addresse){
        new Maj_Addrasynctask(addresseDao).execute(addresse);
    }

    private static class Maj_Addrasynctask extends AsyncTask <Addresse,Void ,Void > {

        private AddresseDao addresseDao;

        public Maj_Addrasynctask(AddresseDao addresseDao) {
            this.addresseDao = addresseDao;
        }

        @Override
        protected Void doInBackground(Addresse... addresses) {
            addresseDao.modifierAddr(addresses[0]);
                return null;
        }
    }


}
