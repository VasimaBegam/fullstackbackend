package com.example.fitlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.fitlog.entity.WorkoutRoutine;
import com.example.fitlog.exception.ResourceNotFoundException;
import com.example.fitlog.repository.WorkoutRoutineRepository;

@Service

public class WorkoutRoutineService {
    @Autowired
    WorkoutRoutineRepository repo;

    public WorkoutRoutine saveData(WorkoutRoutine data) {
        return repo.save(data);
    }

    public List<WorkoutRoutine> GetAlData() {
        return repo.findAll();
    }

    public WorkoutRoutine getRoutineDetails(Long id) {
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException ("WorkoutRoutine not found"));
        

    }

    public WorkoutRoutine updateDatabase(Long id, WorkoutRoutine data) {

        WorkoutRoutine viewData =repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        
        
        viewData.setTitle(data.getTitle());
        viewData.setDescription(data.getDescription());
        viewData.setDifficultyLevel(data.getDifficultyLevel());
        viewData.setTargetGoal(data.getTargetGoal());
        viewData.setPublic(data.isPublic());

        return repo.save(viewData);
    }
     public WorkoutRoutine patchData(Long id,
        WorkoutRoutine data) {

    WorkoutRoutine oldData =
            repo.findById(id).orElse(null);

    if (oldData != null) {

        if (data.getTitle() != null) {
            oldData.setTitle(data.getTitle());
        }

        if (data.getDescription() != null) {
            oldData.setDescription(data.getDescription());
        }

        if (data.getDifficultyLevel() != null) {
            oldData.setDifficultyLevel(
                    data.getDifficultyLevel());
        }

        if (data.getTargetGoal() != null) {
            oldData.setTargetGoal(
                    data.getTargetGoal());
        }

        return repo.save(oldData);
    }

    return null;
}


        

    public WorkoutRoutine getDelete(Long id) {

        WorkoutRoutine data = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("WorkoutRoutine Not Found"));


        repo.delete(data);

        return data;
    }
}
    
