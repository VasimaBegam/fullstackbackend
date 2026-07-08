package com.example.fitlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitlog.entity.WorkoutRoutine;
import com.example.fitlog.service.WorkoutRoutineService;
 @RestController
 @RequestMapping("/workout")

public class WorkoutRoutineController {
    
    
    @Autowired
    WorkoutRoutineService service;

    @PostMapping("/postData")
    public WorkoutRoutine saveData(@RequestBody WorkoutRoutine data) {
        return service.saveData(data);
    }

    @GetMapping("/get")
    public List<WorkoutRoutine> getData() { 
        return service.GetAlData();
    }

    @GetMapping("/get/{id}")
    public WorkoutRoutine getUserData(@PathVariable Long id)
    {
        return service.getRoutineDetails(id);
    }

    @PutMapping("/get/{id}")
    public WorkoutRoutine updateData(
            @PathVariable Long id,
            @RequestBody WorkoutRoutine data) {

        return service.updateDatabase(id, data);
    }

@PatchMapping("/get/{id}")
public WorkoutRoutine patchData(
        @PathVariable Long id,
        @RequestBody WorkoutRoutine data) {

    return service.patchData(id, data);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<?> getdeleteData(@PathVariable Long id) {

        try {
             service.getDelete(id);

              
                return ResponseEntity.ok("Deleted successfully");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Routine not found");
        }
    }
}
    

