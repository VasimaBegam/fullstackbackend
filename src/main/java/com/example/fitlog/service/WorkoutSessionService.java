package com.example.fitlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.example.fitlog.entity.WorkoutSession;
import com.example.fitlog.exception.ResourceNotFoundException;
import com.example.fitlog.repository.WorkoutSessionRepository;

@Service

public class WorkoutSessionService {
    @Autowired
    WorkoutSessionRepository ws;

    public WorkoutSession saveData(WorkoutSession  data) {
        return ws.save(data);
    }

    public List<WorkoutSession> GetAlData() {
        return ws.findAll();
    }

    public WorkoutSession getSessionDetails(Long id) {
        return ws.findById(id).orElseThrow(()-> new ResourceNotFoundException ("Session not found"));
        

    }

    public WorkoutSession updateDatabase(Long id, WorkoutSession data) {

        WorkoutSession viewData =ws.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        
        
        viewData.setRoutineTitle(data.getRoutineTitle());
        viewData.setScheduledDate(data.getScheduledDate());
        viewData.setStartedAt(data.getStartedAt());
        viewData.setCompletedAt(data.getCompletedAt());
        viewData.setFatigueScore(data.getFatigueScore());

        return ws.save(viewData);
    }
    public WorkoutSession patchData(Long id,
        WorkoutSession data) {

    WorkoutSession oldData =
            ws.findById(id).orElse(null);

    if (oldData != null) {

        if (data.getRoutineTitle() != null) {
            oldData.setRoutineTitle(
                    data.getRoutineTitle());
        }

        if (data.getScheduledDate() != null) {
            oldData.setScheduledDate(
                    data.getScheduledDate());
        }

        if (data.getStartedAt() != null) {
            oldData.setStartedAt(
                    data.getStartedAt());
        }

        if (data.getCompletedAt() != null) {
            oldData.setCompletedAt(
                    data.getCompletedAt());
        }

        if (data.getSessionStatus() != null) {
            oldData.setSessionStatus(
                    data.getSessionStatus());
        }

        if (data.getFatigueScore() != null) {
            oldData.setFatigueScore(
                    data.getFatigueScore());
        }

        return ws.save(oldData);
    }

    return null;
}



        

    public WorkoutSession getDelete(Long id) {

        WorkoutSession data = ws.findById(id).orElseThrow(()-> new  ResourceNotFoundException ("User Not Found"));


        ws.delete(data);

        return data;
    }
}
    

