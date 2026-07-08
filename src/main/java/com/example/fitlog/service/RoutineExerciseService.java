package com.example.fitlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;




import com.example.fitlog.entity.RoutineExersice;
import com.example.fitlog.exception.ResourceNotFoundException;
import com.example.fitlog.repository.RoutineExerciseRepository;

@Service

public class RoutineExerciseService {
    @Autowired
     RoutineExerciseRepository re;

    public RoutineExersice  saveData(RoutineExersice data) {
        return re.save(data);
    }

    public List<RoutineExersice > GetAlData() {
        return re.findAll();
    }

    public RoutineExersice getRoutineDetails(Long id) {
        return re.findById(id).orElseThrow(()-> new ResourceNotFoundException("Routine not found"));
        

    }

    public RoutineExersice updateDatabase(Long id,  RoutineExersice data) {

        RoutineExersice viewData =re.findById(id).orElseThrow(()-> new ResourceNotFoundException("Routine not found"));
        
        
        
        
        viewData.setExerciseName(data.getExerciseName());
        viewData.setTargetSets(data.getTargetSets());
        viewData.setTargetReps(data.getTargetReps());
        viewData.setTargetWeightKg(data.getTargetWeightKg());
        viewData.setRestDurationSeconds(data.getRestDurationSeconds());

        

        return re.save(viewData);
    }


public RoutineExersice patchData(Long id,
        RoutineExersice data) {

    RoutineExersice oldData =
            re.findById(id).orElse(null);

    if (oldData != null) {

        if (data.getExerciseName() != null) {
            oldData.setExerciseName(
                    data.getExerciseName());
        }

        if (data.getTargetSets() != 0) {
            oldData.setTargetSets(
                    data.getTargetSets());
        }

        if (data.getTargetReps() != 0) {
            oldData.setTargetReps(
                    data.getTargetReps());
        }

        if (data.getTargetWeightKg() != 0) {
            oldData.setTargetWeightKg(
                    data.getTargetWeightKg());
        }

        if (data.getRestDurationSeconds() != 0) {
            oldData.setRestDurationSeconds(
                    data.getRestDurationSeconds());
        }

        return re .save(oldData);
    }

    return null;
}
        

    public RoutineExersice getDelete(Long id) {

        RoutineExersice data = re.findById(id).orElseThrow(()-> new ResourceNotFoundException("Routine  Not Found"));


        re.delete(data);

        return data;
    }
    
}

    

    
    

