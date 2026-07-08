package com.example.fitlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitlog.entity.RoutineExersice;

@Repository

public interface RoutineExerciseRepository extends JpaRepository <RoutineExersice, Long>{

}
