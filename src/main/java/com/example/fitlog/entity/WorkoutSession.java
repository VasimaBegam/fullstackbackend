package com.example.fitlog.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity


public class WorkoutSession {
    @Id
    private Long id;
private String routineTitle;
private LocalDate scheduledDate;
private LocalDateTime startedAt;
private LocalDateTime completedAt;
private String sessionStatus;
private Integer fatigueScore;
public WorkoutSession(Long id, String routineTitle, LocalDate scheduledDate, LocalDateTime startedAt,
        LocalDateTime completedAt, String sessionStatus, Integer fatigueScore) {
    this.id = id;
    this.routineTitle = routineTitle;
    this.scheduledDate = scheduledDate;
    this.startedAt = startedAt;
    this.completedAt = completedAt;
    this.sessionStatus = sessionStatus;
    this.fatigueScore = fatigueScore;
}
public WorkoutSession() {
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getRoutineTitle() {
    return routineTitle;
}
public void setRoutineTitle(String routineTitle) {
    this.routineTitle = routineTitle;
}
public LocalDate getScheduledDate() {
    return scheduledDate;
}
public void setScheduledDate(LocalDate scheduledDate) {
    this.scheduledDate = scheduledDate;
}
public LocalDateTime getStartedAt() {
    return startedAt;
}
public void setStartedAt(LocalDateTime startedAt) {
    this.startedAt = startedAt;
}
public LocalDateTime getCompletedAt() {
    return completedAt;
}
public void setCompletedAt(LocalDateTime completedAt) {
    this.completedAt = completedAt;
}
public String getSessionStatus() {
    return sessionStatus;
}
public void setSessionStatus(String sessionStatus) {
    this.sessionStatus = sessionStatus;
}
public Integer getFatigueScore() {
    return fatigueScore;
}
public void setFatigueScore(Integer fatigueScore) {
    this.fatigueScore = fatigueScore;
}


    
}
