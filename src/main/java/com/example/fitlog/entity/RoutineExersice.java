package com.example.fitlog.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "routine_exersice")

public class RoutineExersice {

    @Id
    
    private Long id;

    @NotBlank(message = "Exercise name is required")
    private String exerciseName;

    @NotNull(message = "Target sets is required")
    @Min(value = 1, message = "Target sets must be at least 1")
    private Integer targetSets;

    @NotNull(message = "Target reps is required")
    @Min(value = 1, message = "Target reps must be at least 1")
    private Integer targetReps;

    @NotNull(message = "Target weight is required")
    @Positive(message = "Target weight must be greater than 0")
    private Double targetWeightKg;

    @NotNull(message = "Rest duration is required")
    @Min(value = 10, message = "Rest duration must be at least 10 seconds")
    private Integer restDurationSeconds;

    public RoutineExersice() {
    }

    public RoutineExersice(Long id, String exerciseName, Integer targetSets,
            Integer targetReps, Double targetWeightKg,
            Integer restDurationSeconds) {

        this.id = id;
        this.exerciseName = exerciseName;
        this.targetSets = targetSets;
        this.targetReps = targetReps;
        this.targetWeightKg = targetWeightKg;
        this.restDurationSeconds = restDurationSeconds;
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

    public Integer getTargetSets() {
        return targetSets;
    }

    public void setTargetSets(Integer targetSets) {
        this.targetSets = targetSets;
    }

    public Integer getTargetReps() {
        return targetReps;
    }

    public void setTargetReps(Integer targetReps) {
        this.targetReps = targetReps;
    }

    public Double getTargetWeightKg() {
        return targetWeightKg;
    }

    public void setTargetWeightKg(Double targetWeightKg) {
        this.targetWeightKg = targetWeightKg;
    }

    public Integer getRestDurationSeconds() {
        return restDurationSeconds;
    }

    public void setRestDurationSeconds(Integer restDurationSeconds) {
        this.restDurationSeconds = restDurationSeconds;
    }
}