package com.example.fitlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.fitlog.entity.FitnessMetric;
import com.example.fitlog.exception.ResourceNotFoundException;
import com.example.fitlog.repository.FitnessMetricRepository;

@Service

public class FitnessMetricService {
     @Autowired
     FitnessMetricRepository sar;

    public  FitnessMetric saveData(FitnessMetric data) {
        return sar.save(data);
    }

    public List<FitnessMetric> GetAlData() {
        return sar.findAll();
    }

    public FitnessMetric getFitnessDetails(Long id) {
        return sar.findById(id).orElseThrow(()-> new ResourceNotFoundException("FitnessMetric not found"));
        

    }

    public FitnessMetric updateDatabase(Long id, FitnessMetric data) {

        FitnessMetric viewData =sar.findById(id).orElseThrow(()-> new ResourceNotFoundException("FitnessMetric not found"));
        
        
        
        viewData.setRecordedDate(data.getRecordedDate());
        viewData.setBodyWeightKg(data.getBodyWeightKg());
        viewData.setBodyFatPercentage(data.getBodyFatPercentage());
        viewData.setChestCircumferenceCm(data.getChestCircumferenceCm());
        viewData.setWaistCircumferenceCm(data.getWaistCircumferenceCm());
        

        return sar.save(viewData);
    }
     public FitnessMetric patchData(Long id,
        FitnessMetric data) {

    FitnessMetric oldData =
            sar.findById(id).orElse(null);

    if (oldData != null) {

        if (data.getBodyWeightKg() != null) {
            oldData.setBodyWeightKg(
                    data.getBodyWeightKg());
        }

        if (data.getBodyFatPercentage() != null) {
            oldData.setBodyFatPercentage(
                    data.getBodyFatPercentage());
        }

        return sar.save(oldData);
    }

    return null;
}


        

    public FitnessMetric getDelete(Long id) {

        FitnessMetric data = sar.findById(id).orElseThrow(()-> new ResourceNotFoundException("FitnessMetric Not Found"));


        sar.delete(data);

        return data;
    }
    
}
