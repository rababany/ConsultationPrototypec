package com.example.consultationprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.consultationprototype.databinding.ActivityAjouterModifierBinding;
import com.example.consultationprototype.model.Patient;

public class AjouterModifierActivity extends AppCompatActivity {
    private Patient patient;
    public   static final String PATIENT_ID  = "idPatient";
    public   static final String PATIENT_AGE  = "agePatient";
    public   static final String PATIENT_SEXE  = "sexePatient";
    public   static final String PATIENT_POIDS  = "poidsPatient";
    public   static final String PATIENT_PB  = "pbPatient";
    public   static final String PATIENT_TAILLE  = "taillePatient";
    public   static final String PATIENT_ID_ADDRESSE  = "idDiagPatient";
    public   static final String PATIENT_ID_DIAG  = "idAddrPatient";
    public   static final String PATIENT_DATECONSULT  = "dateconsultPatient";
    private ActivityAjouterModifierBinding activityAjouterModifierBinding;
    private AjouteretModifierParClick ajouteretModifierParClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_modifier);
        patient = new Patient();
        activityAjouterModifierBinding = DataBindingUtil.setContentView(this,R.layout.activity_ajouter_modifier);
        activityAjouterModifierBinding.setPatient(patient);
        ajouteretModifierParClick = new AjouteretModifierParClick(this);
        activityAjouterModifierBinding.setClickHandler(ajouteretModifierParClick);
        Intent intent= getIntent();
        if(intent.hasExtra(PATIENT_ID)){
            setTitle("Modification Patient");
            patient.setAgePatient(intent.getStringExtra(PATIENT_AGE));
            patient.setSexePatient(intent.getStringExtra(PATIENT_SEXE));
            patient.setPoidsPatient(intent.getLongExtra(PATIENT_POIDS,0));
            patient.setPbPatient(intent.getLongExtra(PATIENT_PB,0));
            patient.setTaillePatient(intent.getLongExtra(PATIENT_TAILLE,0));
            patient.setIdAddrPatient(intent.getLongExtra(PATIENT_ID_ADDRESSE,0));
            patient.setIdDiagPatient(intent.getLongExtra(PATIENT_ID_DIAG,0));
            patient.setDateconsultPatient(intent.getStringExtra(PATIENT_DATECONSULT));
        } else {
            setTitle("Ajout Patient");
        }
    }
    public  class AjouteretModifierParClick {
        Context context;

        public AjouteretModifierParClick(Context context) {
            this.context = context;
        }
        public void boutonSauvegarder(View view){
            if(patient.getAgePatient()==null){
                Toast.makeText(context,"cette ligne ne peut etre vide",Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra(PATIENT_AGE,patient.getAgePatient());
                intent.putExtra(PATIENT_SEXE,patient.getSexePatient());
                intent.putExtra(PATIENT_POIDS,patient.getPoidsPatient());
                intent.putExtra(PATIENT_PB,patient.getPbPatient());
                intent.putExtra(PATIENT_TAILLE,patient.getTaillePatient());
                intent.putExtra(PATIENT_ID_ADDRESSE,patient.getIdAddrPatient());
                intent.putExtra(PATIENT_ID_DIAG,patient.getIdDiagPatient());
                intent.putExtra(PATIENT_DATECONSULT,patient.getDateconsultPatient());
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    }
}
