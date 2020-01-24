package com.example.consultationprototype;

import android.content.Intent;
import android.os.Bundle;

import com.example.consultationprototype.model.Addresse;
import com.example.consultationprototype.model.Diagnostic;
import com.example.consultationprototype.model.Malnutrition;
import com.example.consultationprototype.model.Patient;
import com.example.consultationprototype.ViewModel.ActivityAddresseViewModel;
import com.example.consultationprototype.ViewModel.ActivityDiagnosticViewModel;
import com.example.consultationprototype.ViewModel.ActivityMalnutritionViewModel;
import com.example.consultationprototype.ViewModel.ActivityPatientViewModel;
import com.example.consultationprototype.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityAddresseViewModel activityAddresseViewModel;
    private ActivityDiagnosticViewModel activityDiagnosticViewModel;
    private ActivityMalnutritionViewModel activityMalnutritionViewModel;
    private ActivityPatientViewModel activityPatientViewModel;
    private ActivityMainBinding activityMainBinding;
    private MainActivityApresClick mainActivityApresClick;
    private Addresse addressechoisie;
    private ArrayList<Addresse> addresseList;
    private ArrayList<Patient> patientAddresseArrayList;
    private RecyclerView patientRecycleview;
    private PatientAdapter patientAdapter;
    private long patientIdAjout;

    private static final int ADD_PATIENT_REQUEST_CODE = 1;
    private static final int EDIT_PATIENT_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityApresClick = new MainActivityApresClick();
        activityMainBinding.setPisterClick(mainActivityApresClick);

        activityDiagnosticViewModel = ViewModelProviders.of(this).get(ActivityDiagnosticViewModel.class);
        activityDiagnosticViewModel.getToutDiagnostic().observe(this, new Observer<List<Diagnostic>>() {
            @Override
            public void onChanged(List<Diagnostic> diagnostics) {
                for (Diagnostic d: diagnostics){
                    Log.i("MY Diagnostic",d.getCategory_diagnostic());
                }
            }
        });
        activityAddresseViewModel = ViewModelProviders.of(this).get(ActivityAddresseViewModel.class);
        activityAddresseViewModel.getTouteAdresse().observe(this, new Observer<List<Addresse>>() {
            @Override
            public void onChanged(List<Addresse> addresses) {
                addresseList=(ArrayList<Addresse>) addresses;
                for (Addresse a: addresses){
                    Log.i("MY Addresse",a.getHammeau());
                }
                afficheSurSpinner();
            }
        });
        activityMalnutritionViewModel = ViewModelProviders.of(this).get(ActivityMalnutritionViewModel.class);
        activityMalnutritionViewModel.getToutMalnutrition().observe(this, new Observer<List<Malnutrition>>() {
            @Override
            public void onChanged(List<Malnutrition> malnutritions) {
                for (Malnutrition m:malnutritions){
                    Log.i("La Malnutrition",m.getPoids_taille());
                }
            }
        });
        activityPatientViewModel = ViewModelProviders.of(this).get(ActivityPatientViewModel.class);
        activityPatientViewModel.getToutPatient().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                for (Patient p:patients) {
                    Log.i("My patients",p.getAgePatient());
                }
            }
        });

    }
    public  void afficheSurSpinner(){
        ArrayAdapter<Addresse> addresseArrayAdapter = new  ArrayAdapter<Addresse> (this,R.layout.spinner_item,addresseList);
        addresseArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setChoixAdapter(addresseArrayAdapter);
    }
    public void loadDataPatientArraylist(long idAddrPatient){

        activityPatientViewModel.getToutPatientAddr(idAddrPatient).observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                patientAddresseArrayList = (ArrayList<Patient>)patients;
                loadRecycleView();
            }
        });
    }
    public void loadRecycleView(){
        patientRecycleview = activityMainBinding.secondaryLayout.rvPatient;
        patientRecycleview.setLayoutManager(new LinearLayoutManager(this));
        patientRecycleview.setHasFixedSize(true);

        patientAdapter = new PatientAdapter();
        patientRecycleview.setAdapter(patientAdapter);;

        patientAdapter.setPatientArrayList(patientAddresseArrayList);
        patientAdapter.setListener(new PatientAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Patient patient) {
                patientIdAjout = patient.getIdPatient();
                Intent intent = new Intent(MainActivity.this, AjouterModifierActivity.class);
                intent.putExtra(AjouterModifierActivity.PATIENT_ID,patientIdAjout);
                intent.putExtra(AjouterModifierActivity.PATIENT_AGE,patient.getAgePatient());
                intent.putExtra(AjouterModifierActivity.PATIENT_POIDS,patient.getPoidsPatient());
                intent.putExtra(AjouterModifierActivity.PATIENT_SEXE,patient.getSexePatient());
                intent.putExtra(AjouterModifierActivity.PATIENT_TAILLE,patient.getTaillePatient());
                intent.putExtra(AjouterModifierActivity.PATIENT_PB,patient.getPbPatient());
                intent.putExtra(AjouterModifierActivity.PATIENT_ID_ADDRESSE,patient.getIdAddrPatient());
                intent.putExtra(AjouterModifierActivity.PATIENT_ID_DIAG,patient.getIdDiagPatient());
                intent.putExtra(AjouterModifierActivity.PATIENT_DATECONSULT,patient.getDateconsultPatient());
                startActivityForResult(intent,EDIT_PATIENT_REQUEST_CODE);
            }
        });
    }
    public  class MainActivityApresClick {
        public void clickBouton (View view){
//            Toast.makeText(getApplicationContext(), "click de la bouton", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AjouterModifierActivity.AjouteretModifierParClick.class);
            startActivityForResult(intent,ADD_PATIENT_REQUEST_CODE);



        }
        public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {

            addressechoisie = (Addresse) parent.getItemAtPosition(pos);

            String message = " id is " + addressechoisie.getId_addr() + "\n name is " + addressechoisie.getFokontany() + "\n email is " + addressechoisie.getHammeau();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), message, Toast.LENGTH_LONG).show();

            loadDataPatientArraylist(addressechoisie.getId_addr());

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
