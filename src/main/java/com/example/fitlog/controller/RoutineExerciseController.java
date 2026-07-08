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


import com.example.fitlog.entity.RoutineExersice;
import com.example.fitlog.service.RoutineExerciseService;

import jakarta.validation.Valid;

 @RestController
 @RequestMapping("/routine")

public class RoutineExerciseController {
    @Autowired
     RoutineExerciseService rs;

    @PostMapping("/postData")
    public  RoutineExersice saveData(@Valid @RequestBody RoutineExersice  data) {
        return rs.saveData(data);
    }

    @GetMapping("/get")
    public List <RoutineExersice> getData() {
        return rs.GetAlData();
    }

    @GetMapping("/get/{id}")
    public RoutineExersice getUserData(@PathVariable Long id)
    {
        return rs.getRoutineDetails(id);
    }

    @PutMapping("/get/{id}")
    public  RoutineExersice updateData(
            @PathVariable Long id, @Valid
            @RequestBody RoutineExersice data) {

        return rs.updateDatabase(id, data);
    }

    
    @PatchMapping("/get/{id}")
public RoutineExersice patchData(
        @PathVariable Long id,
        @RequestBody RoutineExersice data) {

    return rs.patchData(id, data);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getdeleteData(@PathVariable Long id) {

        try {
                 rs.getDelete(id);
                return ResponseEntity.ok("Deleted successfully");
        
                    

        } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exercise log not found");

            
        }
    }
}
    

    

    
    

