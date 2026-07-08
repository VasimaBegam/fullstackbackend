package com.example.fitlog.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity


public class FitnessMetric {
    @Id
    private Long id;
private LocalDate recordedDate;
private Double bodyWeightKg;
private Double bodyFatPercentage;
private Double chestCircumferenceCm;
private Double waistCircumferenceCm;
public FitnessMetric(Long id, LocalDate recordedDate, Double bodyWeightKg, Double bodyFatPercentage,
        Double chestCircumferenceCm, Double waistCircumferenceCm) {
    this.id = id;
    this.recordedDate = recordedDate;
    this.bodyWeightKg = bodyWeightKg;
    this.bodyFatPercentage = bodyFatPercentage;
    this.chestCircumferenceCm = chestCircumferenceCm;
    this.waistCircumferenceCm = waistCircumferenceCm;
}
public FitnessMetric() {
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public LocalDate getRecordedDate() {
    return recordedDate;
}
public void setRecordedDate(LocalDate recordedDate) {
    this.recordedDate = recordedDate;
}
public Double getBodyWeightKg() {
    return bodyWeightKg;
}
public void setBodyWeightKg(Double bodyWeightKg) {
    this.bodyWeightKg = bodyWeightKg;
}
public Double getBodyFatPercentage() {
    return bodyFatPercentage;
}
public void setBodyFatPercentage(Double bodyFatPercentage) {
    this.bodyFatPercentage = bodyFatPercentage;
}
public Double getChestCircumferenceCm() {
    return chestCircumferenceCm;
}
public void setChestCircumferenceCm(Double chestCircumferenceCm) {
    this.chestCircumferenceCm = chestCircumferenceCm;
}
public Double getWaistCircumferenceCm() {
    return waistCircumferenceCm;
}
public void setWaistCircumferenceCm(Double waistCircumferenceCm) {
    this.waistCircumferenceCm = waistCircumferenceCm;
}

    
}
