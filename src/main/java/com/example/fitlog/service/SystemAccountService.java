
package com.example.fitlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fitlog.entity.SystemAccount;
import com.example.fitlog.exception.ResourceNotFoundException;
import com.example.fitlog.repository.SystemAccountRepository;

@Service
public class SystemAccountService {

    @Autowired
    private SystemAccountRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    // Add User
    public SystemAccount saveData(SystemAccount data) {

        data.setPassword(encoder.encode(data.getPassword()));

        return repo.save(data);
    }

    // Get All Users
    public List<SystemAccount> GetAlData() {
        return repo.findAll();
    }

    // Get User By Id
    public SystemAccount getAccountDetails(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));
    }

    // Update User
    public SystemAccount updateDatabase(Long id, SystemAccount data) {

        SystemAccount oldData = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        oldData.setUsername(data.getUsername());
        oldData.setEmail(data.getEmail());

        if (data.getPassword() != null) {
            oldData.setPassword(encoder.encode(data.getPassword()));
        }

        oldData.setRole(data.getRole());

        return repo.save(oldData);
    }

    // Patch User
    public SystemAccount patchData(Long id, SystemAccount data) {

        SystemAccount oldData = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        if (data.getUsername() != null) {
            oldData.setUsername(data.getUsername());
        }

        if (data.getEmail() != null) {
            oldData.setEmail(data.getEmail());
        }

        if (data.getPassword() != null) {
            oldData.setPassword(encoder.encode(data.getPassword()));
        }

        if (data.getRole() != null) {
            oldData.setRole(data.getRole());
        }

        return repo.save(oldData);
    }

    // Delete User
    public SystemAccount getDelete(Long id) {

        SystemAccount user = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        repo.delete(user);

        return user;
    }
}


    

