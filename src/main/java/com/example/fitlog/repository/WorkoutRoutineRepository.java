package com.example.fitlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitlog.entity.WorkoutRoutine;

@Repository


    public interface WorkoutRoutineRepository extends JpaRepository<WorkoutRoutine, Long> {

}


