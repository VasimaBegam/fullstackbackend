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


import com.example.fitlog.entity.WorkoutSession;
import com.example.fitlog.service.WorkoutSessionService;
 @RestController
 @RequestMapping("/session")

public class WorkoutSessionController {
    @Autowired
    WorkoutSessionService ser;

    @PostMapping("/postData")
    public WorkoutSession saveData(@RequestBody WorkoutSession data) {
        return ser.saveData(data);
    }

    @GetMapping("/get")
    public List <WorkoutSession> getData() {
        return ser.GetAlData();
    }

    @GetMapping("/get/{id}")
    public WorkoutSession getUserData(@PathVariable Long id)
    {
        return ser.getSessionDetails(id);
    }
    

    @PutMapping("/get/{id}")
    public WorkoutSession updateData(
            @PathVariable Long id,
            @RequestBody WorkoutSession data) {

        return ser.updateDatabase(id, data);
    }
    @PatchMapping("/get/{id}")
public WorkoutSession patchData(
        @PathVariable Long id,
        @RequestBody WorkoutSession data) {

    return ser.patchData(id, data);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getdeleteData(@PathVariable Long id) {

        try {
             ser.getDelete(id);

              
                return ResponseEntity.ok("Deleted successfully");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Routine not found");
        }
    }
}
    


    
    

