package com.example.fitlog.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "exercise_log")
public class ExerciseLog {

    @Id
    private Long id;

    @NotBlank(message = "Exercise name is required")
    private String exerciseName;

    @NotNull(message = "Actual sets is required")
    @Min(value = 1, message = "Actual sets must be at least 1")
    private Integer actualSets;

    @NotNull(message = "Actual reps is required")
    @Min(value = 1, message = "Actual reps must be at least 1")
    private Integer actualReps;

    @NotNull(message = "Actual weight is required")
    @Positive(message = "Actual weight must be greater than 0")
    private Double actualWeightKg;

    private boolean isPersonalRecord;

    public ExerciseLog() {
    }

    public ExerciseLog(Long id, String exerciseName, Integer actualSets,
            Integer actualReps, Double actualWeightKg,
            boolean isPersonalRecord) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.actualSets = actualSets;
        this.actualReps = actualReps;
        this.actualWeightKg = actualWeightKg;
        this.isPersonalRecord = isPersonalRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Integer getActualSets() {
        return actualSets;
    }

    public void setActualSets(Integer actualSets) {
        this.actualSets = actualSets;
    }

    public Integer getActualReps() {
        return actualReps;
    }

    public void setActualReps(Integer actualReps) {
        this.actualReps = actualReps;
    }

    public Double getActualWeightKg() {
        return actualWeightKg;
    }

    public void setActualWeightKg(Double actualWeightKg) {
        this.actualWeightKg = actualWeightKg;
    }

    public boolean isPersonalRecord() {
        return isPersonalRecord;
    }

    public void setPersonalRecord(boolean personalRecord) {
        isPersonalRecord = personalRecord;
    }
}