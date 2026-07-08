package com.example.fitlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.fitlog.entity.ExerciseLog;
import com.example.fitlog.exception.ResourceNotFoundException;
import com.example.fitlog.repository.ExerciseLogRepository;


@Service

public class ExerciseLogService {
    @Autowired
     ExerciseLogRepository ear;

    public  ExerciseLog saveData(ExerciseLog data) {
        return ear.save(data);
    }

    public List<ExerciseLog > GetAlData() {
        return ear.findAll();
    }

    public ExerciseLog  getExerciseDetails(Long id) {
        return ear.findById(id).orElseThrow(()-> new ResourceNotFoundException ("ExerciseLog not found"));
        

    }

    public ExerciseLog  updateDatabase(Long id, ExerciseLog data) {

        ExerciseLog viewData =ear.findById(id).orElseThrow(()-> new ResourceNotFoundException("ExerciseLog not found"));
        
        
        
        
        viewData.setExerciseName(data.getExerciseName());
        viewData.setActualSets(data.getActualSets());
        viewData.setActualReps(data.getActualReps());
        viewData.setActualWeightKg(data.getActualWeightKg());
        viewData.setPersonalRecord(data.isPersonalRecord());

        

        return ear.save(viewData);
    }

public ExerciseLog patchData(Long id,
        ExerciseLog data) {

    ExerciseLog oldData =
            ear.findById(id).orElse(null);

    if (oldData != null) {

        if (data.getExerciseName() != null) {
            oldData.setExerciseName(
                    data.getExerciseName());
        }

        if (data.getActualSets() != 0) {
            oldData.setActualSets(
                    data.getActualSets());
        }

        if (data.getActualReps() != 0) {
            oldData.setActualReps(
                    data.getActualReps());
        }

        if (data.getActualWeightKg() != 0) {
            oldData.setActualWeightKg(
                    data.getActualWeightKg());
        }

        oldData.setPersonalRecord(
                data.isPersonalRecord());

        return ear.save(oldData);
    }

    return null;
}

        

    public ExerciseLog getDelete(Long id) {

        ExerciseLog data = ear.findById(id).orElseThrow(()-> new ResourceNotFoundException("ExerciseLog Not Found"));


        ear.delete(data);

        return data;
    }
    
}

    