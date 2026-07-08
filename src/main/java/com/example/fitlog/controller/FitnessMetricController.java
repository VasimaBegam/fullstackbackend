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

import com.example.fitlog.entity.FitnessMetric;


import com.example.fitlog.service.FitnessMetricService;
 @RestController

 @RequestMapping("/fit")
public class FitnessMetricController {
    @Autowired
    FitnessMetricService fs;

    @PostMapping("/postData")
    public  FitnessMetric saveData(@RequestBody FitnessMetric data) {
        return fs.saveData(data);
    }

    @GetMapping("/get")
    public List<FitnessMetric> getData() {
        return fs.GetAlData();
    }

    @GetMapping("/get/{id}")
    public FitnessMetric getUserData(@PathVariable Long id)
    {
        return fs.getFitnessDetails(id);
    }

    @PutMapping("/get/{id}")
    public FitnessMetric updateData(
            @PathVariable Long id,
            @RequestBody FitnessMetric data) {

        return fs.updateDatabase(id, data);
    }
    @PatchMapping("/get/{id}")
public FitnessMetric patchData(
        @PathVariable Long id,
        @RequestBody FitnessMetric data) {

    return fs.patchData(id, data);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<?> getdeleteData(@PathVariable Long id) {

        try {
             fs.getDelete(id);

            
                return ResponseEntity.ok("Deleted successfully");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("fitnessmetric not found");
        }
    }
}
    


    
    
    


    
    

