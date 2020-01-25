package com.example.consultationprototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.consultationprototype.model.Patient;
import com.example.consultationprototype.databinding.PatientListAddrBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientTiroir>{
    private OnItemClickListener listener;
    private ArrayList<Patient> patientArrayList = new ArrayList<>();

    @NonNull
    @Override
    public PatientTiroir onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PatientListAddrBinding patientListAddrBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.patient_list_addr,parent,false);
        return new PatientTiroir(patientListAddrBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientTiroir holder, int position) {
        Patient patient = patientArrayList.get(position);
        holder.patientListAddrBinding.setPatient(patient);
    }

    @Override
    public int getItemCount() {
        return patientArrayList.size();
    }

    public void setPatientArrayList(ArrayList<Patient> nvpatientArrayList) {
//        this.patientArrayList = patientArrayList;
//        notifyDataSetChanged();
        final DiffUtil.DiffResult result= DiffUtil.calculateDiff(new PatientDifCallback(patientArrayList,nvpatientArrayList),false);
        patientArrayList = nvpatientArrayList;
        result.dispatchUpdatesTo(PatientAdapter.this);

    }

    class PatientTiroir extends RecyclerView.ViewHolder{
        private PatientListAddrBinding patientListAddrBinding;

        public PatientTiroir(@NonNull PatientListAddrBinding patientListAddrBinding) {
            super(patientListAddrBinding.getRoot());
            this.patientListAddrBinding = patientListAddrBinding;
            patientListAddrBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positionclick = getAdapterPosition();
                    if(listener!=null && positionclick != RecyclerView.NO_POSITION)
                    {
                        listener.onItemClick(patientArrayList.get(positionclick));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Patient patient);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
