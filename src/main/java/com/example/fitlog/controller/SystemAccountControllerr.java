package com.example.fitlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.fitlog.entity.SystemAccount;
import com.example.fitlog.service.SystemAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class SystemAccountControllerr {

    @Autowired
    private SystemAccountService accountService;

    
    @PostMapping("/postData")
    @PreAuthorize("hasRole('ADMIN')")
    
    public SystemAccount saveData( @Valid @RequestBody SystemAccount data) {
        return accountService.saveData(data);
    }
    

    
    @GetMapping("/get")
    public List<SystemAccount> getData() {
        return accountService.GetAlData();
    }

    @GetMapping("/get/{id}")
    public SystemAccount getUserData(@PathVariable Long id) {
        return accountService.getAccountDetails(id);
    }

    
    @PutMapping("/get/{id}")
    public SystemAccount updateData(
            @PathVariable Long id, @Valid
            @RequestBody SystemAccount data) {

        return accountService.updateDatabase(id, data);
    }

    
    @PatchMapping("/get/{id}")
    public SystemAccount patchUser(
            @PathVariable Long id,
            @RequestBody SystemAccount data) {

        return accountService.patchData(id, data);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Long id) {

        try {

            accountService.getDelete(id);

            return ResponseEntity.ok("Deleted Successfully");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User Not Found");
        }
    }

}