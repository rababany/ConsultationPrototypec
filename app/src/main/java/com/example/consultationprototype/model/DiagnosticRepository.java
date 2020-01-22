package com.example.consultationprototype.model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class DiagnosticRepository {
    private DiagnosticDao diagnosticDao;
    private LiveData<List<Diagnostic>> tab_diagnostic;

    public DiagnosticRepository(Application application) {
        ConsultationBDD consultationBDD = ConsultationBDD.getInstance(application);
        diagnosticDao = consultationBDD.diagnosticDao();

    }

    public LiveData<List<Diagnostic>> getTab_diagnostic() {
        return diagnosticDao.listerDiag();
    }

    public void ajouterDiagnostic(Diagnostic diagnostic){
        new InsererDiagasynctask(diagnosticDao).execute(diagnostic);
    }

    private static class InsererDiagasynctask extends AsyncTask<Diagnostic,Void ,Void > {

        private DiagnosticDao diagnosticDao;


        public InsererDiagasynctask(DiagnosticDao diagnosticDao) {
            this.diagnosticDao = diagnosticDao;
        }

        @Override
        protected Void doInBackground(Diagnostic... diagnostics) {
            diagnosticDao.insererDiag(diagnostics[0]);
                return null;
        }
    }
    public void enleverDiagnostic(Diagnostic diagnostic){
        new EnleverDiagasynctask(diagnosticDao).execute(diagnostic);
    }

    private static class EnleverDiagasynctask extends AsyncTask<Diagnostic,Void ,Void > {

        private DiagnosticDao diagnosticDao;


        public EnleverDiagasynctask(DiagnosticDao diagnosticDao) {
            this.diagnosticDao = diagnosticDao;
        }

        @Override
        protected Void doInBackground(Diagnostic... diagnostics) {
            diagnosticDao.supprimerDiag(diagnostics[0]);
                return null;
        }
    }
    public void maj_Diagnostic(Diagnostic diagnostic){
        new Maj_Diagasynctask(diagnosticDao).execute(diagnostic);
    }

    private static class Maj_Diagasynctask extends AsyncTask<Diagnostic,Void ,Void > {

        private DiagnosticDao diagnosticDao;


        public Maj_Diagasynctask(DiagnosticDao diagnosticDao) {
            this.diagnosticDao = diagnosticDao;
        }

        @Override
        protected Void doInBackground(Diagnostic... diagnostics) {
            diagnosticDao.modifierDiag(diagnostics[0]);
                return null;
        }
    }



}
