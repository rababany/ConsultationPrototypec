package com.example.consultationprototype.Model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Addresse.class,Diagnostic.class,Malnutrition.class,Patient.class},version = 1,exportSchema = false)
public abstract class ConsultationBDD extends RoomDatabase {
public abstract AddresseDao addresseDao();
public abstract DiagnosticDao diagnosticDao();
public abstract MalnutritionDao malnutritionDao();
public abstract PatientDao patientDao();
public  static ConsultationBDD instance;

    public static synchronized ConsultationBDD getInstance(Context context){
        if(instance==null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),ConsultationBDD.class,"BDD_consultation").fallbackToDestructiveMigration().allowMainThreadQueries().addCallback(callback).build();


        }
        return instance;
    }
    private static RoomDatabase.Callback callback= new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitialiserBDDasynctask(instance).execute();
        }
    };
    private static class InitialiserBDDasynctask extends AsyncTask <Void,Void,Void> {
        private AddresseDao addresseDao;

        private DiagnosticDao diagnosticDao;

        private MalnutritionDao malnutritionDao;

        private PatientDao patientDao;

        public InitialiserBDDasynctask(ConsultationBDD consultationBDD) {
                addresseDao = consultationBDD.addresseDao();
                diagnosticDao = consultationBDD.diagnosticDao();
                malnutritionDao = consultationBDD.malnutritionDao();
                patientDao = consultationBDD.patientDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
                Addresse addresse1 = new Addresse();
                addresse1.setFokontany("talapetraka");
                addresse1.setHammeau("tsiskozy");

            Addresse addresse2 = new Addresse();
            addresse2.setFokontany("talatsangana");
            addresse2.setHammeau("tsiskozy2");

            Addresse addresse3 = new Addresse();
            addresse3.setFokontany("talamatory");
            addresse3.setHammeau("tsiskozy3");

            Addresse addresse4 = new Addresse();
            addresse4.setFokontany("talamierotra");
            addresse4.setHammeau("tsiskoz4");

                addresseDao.insererAddr(addresse1);
                addresseDao.insererAddr(addresse2);
                addresseDao.insererAddr(addresse3);
                addresseDao.insererAddr(addresse4);

            Diagnostic diagnostic1 = new Diagnostic();
            diagnostic1.setCategory_diagnostic("localisationtete");
            diagnostic1.setSigne("cephalee");

            Diagnostic diagnostic2 = new Diagnostic();
            diagnostic2.setCategory_diagnostic("localisationtete");
            diagnostic2.setSigne("vertige");

            Diagnostic diagnostic3 = new Diagnostic();
            diagnostic3.setCategory_diagnostic("localisationtete");
            diagnostic3.setSigne("nevrose");

            Diagnostic diagnostic4 = new Diagnostic();
            diagnostic4.setCategory_diagnostic("localisationtronc");
            diagnostic4.setSigne("diarrhee");

            diagnosticDao.insererDiag(diagnostic1);
            diagnosticDao.insererDiag(diagnostic2);
            diagnosticDao.insererDiag(diagnostic3);
            diagnosticDao.insererDiag(diagnostic4);

            Patient patient = new Patient();
            patient.setAge_patient("roambinifolo");
            patient.setSexe_patient("homme");
            patient.setPoids_patient(40);
            patient.setTaille_patient(1);
            patient.setPb_patient(124);
            patient.setId_addr_patient(1);
            patient.setId_diag_patient(1);
            patient.setDateconsult_patient("nov2019");

            Patient patient2 = new Patient();
            patient2.setAge_patient("telombinifolo");
            patient2.setSexe_patient("femme");
            patient2.setPoids_patient(40);
            patient2.setTaille_patient(1);
            patient2.setPb_patient(124);
            patient2.setId_addr_patient(1);
            patient2.setId_diag_patient(1);
            patient2.setDateconsult_patient("nov2019");

            Patient patient3 = new Patient();
            patient3.setAge_patient("folo");
            patient3.setSexe_patient("homme");
            patient3.setPoids_patient(40);
            patient3.setTaille_patient(1);
            patient3.setPb_patient(124);
            patient3.setId_addr_patient(1);
            patient3.setId_diag_patient(1);
            patient3.setDateconsult_patient("nov2019");

            Patient patient4 = new Patient();
            patient4.setAge_patient("folo");
            patient4.setSexe_patient("homme");
            patient4.setPoids_patient(40);
            patient4.setTaille_patient(1);
            patient4.setPb_patient(124);
            patient4.setId_addr_patient(1);
            patient4.setId_diag_patient(1);
            patient4.setDateconsult_patient("nov2019");


            Patient patient5 = new Patient();
            patient5.setAge_patient("folo");
            patient5.setSexe_patient("homme");
            patient5.setPoids_patient(40);
            patient5.setTaille_patient(1);
            patient5.setPb_patient(124);
            patient5.setId_addr_patient(1);
            patient5.setId_diag_patient(1);
            patient5.setDateconsult_patient("nov2019");

            patientDao.insererPat(patient);
            patientDao.insererPat(patient2);
            patientDao.insererPat(patient3);
            patientDao.insererPat(patient4);
            patientDao.insererPat(patient5);

            Malnutrition malnutrition = new Malnutrition();
//            malnutrition.setId_malnutrition(1);
            malnutrition.setOedeme(false);
            malnutrition.setPoids_age("1ET");
            malnutrition.setPoids_taille("2ET");

            Malnutrition malnutrition2 = new Malnutrition();
//            malnutrition2.setId_malnutrition(2);
            malnutrition2.setOedeme(false);
            malnutrition2.setPoids_age("-2ET");
            malnutrition2.setPoids_taille("3ET");

            Malnutrition malnutrition3 = new Malnutrition();
//            malnutrition3.setId_malnutrition(3);
            malnutrition3.setOedeme(false);
            malnutrition3.setPoids_age("-4ET");
            malnutrition3.setPoids_taille("-2ET");

            malnutritionDao.insererMalt(malnutrition);
            malnutritionDao.insererMalt(malnutrition2);
            malnutritionDao.insererMalt(malnutrition3);

            return null;
            }


        }

    }



