package com.example.consultationprototype.ViewModel;

import android.app.Application;

import com.example.consultationprototype.Model.Diagnostic;
import com.example.consultationprototype.Model.DiagnosticRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ActivityDiagnosticViewModel extends AndroidViewModel {
    private DiagnosticRepository diagnosticRepository;
    private LiveData<List<Diagnostic>> toutDiagnostic;
    public ActivityDiagnosticViewModel(@NonNull Application application) {
        super(application);
        diagnosticRepository = new DiagnosticRepository(application);
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
}
