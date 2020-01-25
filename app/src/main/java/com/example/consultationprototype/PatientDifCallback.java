package com.example.consultationprototype;

import com.example.consultationprototype.model.Patient;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class PatientDifCallback extends DiffUtil.Callback {
    ArrayList<Patient> nvPatientArrayList;
    ArrayList<Patient> acPatientArrayList;

    public PatientDifCallback(ArrayList<Patient> nvPatientArrayList, ArrayList<Patient> acPatientArrayList) {
        this.nvPatientArrayList = nvPatientArrayList;
        this.acPatientArrayList = acPatientArrayList;
    }

    @Override
    public int getOldListSize() {

        return acPatientArrayList ==null?0:acPatientArrayList.size();
    }

    @Override
    public int getNewListSize() {
        return nvPatientArrayList ==null?0:nvPatientArrayList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return acPatientArrayList.get(oldItemPosition).getIdPatient()==nvPatientArrayList.get(newItemPosition).getIdPatient();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return acPatientArrayList.get(oldItemPosition).equals(nvPatientArrayList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
