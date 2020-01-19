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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityAddresseViewModel activityAddresseViewModel;
    private ActivityDiagnosticViewModel activityDiagnosticViewModel;
    private ActivityMalnutritionViewModel activityMalnutritionViewModel;
    private ActivityPatientViewModel activityPatientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                for (Addresse a: addresses){
                    Log.i("MY Addresse",a.getHammeau());
                }
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
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
