package com.example.consultationprototype;

import android.os.Bundle;

import com.example.consultationprototype.Model.Addresse;
import com.example.consultationprototype.Model.Diagnostic;
import com.example.consultationprototype.Model.Malnutrition;
import com.example.consultationprototype.Model.Patient;
import com.example.consultationprototype.ViewModel.ActivityAddresseViewModel;
import com.example.consultationprototype.ViewModel.ActivityDiagnosticViewModel;
import com.example.consultationprototype.ViewModel.ActivityMalnutritionViewModel;
import com.example.consultationprototype.ViewModel.ActivityPatientViewModel;
import com.example.consultationprototype.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;


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
                    Log.i("My patients",p.getAge_patient());
                }
            }
        });

    }
    public  void afficheSurSpinner(){
        ArrayAdapter<Addresse> addresseArrayAdapter = new  ArrayAdapter<Addresse> (this,R.layout.spinner_item,addresseList);
        addresseArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setChoixAdapter(addresseArrayAdapter);
    }
    public  class MainActivityApresClick {
        public void clickBouton (View view){
            Toast.makeText(getApplicationContext(), "click de la bouton", Toast.LENGTH_SHORT).show();
        }
        public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {

            addressechoisie = (Addresse) parent.getItemAtPosition(pos);

            String message = " id is " + addressechoisie.getId_addr() + "\n name is " + addressechoisie.getFokontany() + "\n email is " + addressechoisie.getHammeau();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), message, Toast.LENGTH_LONG).show();


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
