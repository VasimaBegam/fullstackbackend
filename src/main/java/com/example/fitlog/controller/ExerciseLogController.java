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

import com.example.fitlog.entity.ExerciseLog;
import com.example.fitlog.service.ExerciseLogService;

import jakarta.validation.Valid;

 @RestController
 @RequestMapping("/exercise")

public class ExerciseLogController {

     @Autowired
    ExerciseLogService es;

    @PostMapping("/postData")
    public  ExerciseLog saveData(@Valid @RequestBody ExerciseLog data) {
        return es.saveData(data);
    }

    @GetMapping("/get")
    public List< ExerciseLog > getData() {
        return es.GetAlData();
    }

    @GetMapping("/get/{id}")
    public ExerciseLog getUserData(@PathVariable Long id)
    {
        return es.getExerciseDetails(id);
    }

    @PutMapping("/get/{id}")
    public  ExerciseLog  updateData(
            @PathVariable Long id, @Valid
            @RequestBody ExerciseLog data) {

        return es.updateDatabase(id, data);
    }
    
     @PatchMapping("/get/{id}")
public ExerciseLog patchData(
        @PathVariable Long id,
        @RequestBody ExerciseLog data) {

    return es.patchData(id, data);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getdeleteData(@PathVariable Long id) {

        try {
                 es.getDelete(id);
                return ResponseEntity.ok("Deleted successfully");
        
                    

        } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exercise log not found");

            
        }
    }
}
    

    

