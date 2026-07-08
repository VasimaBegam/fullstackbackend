package com.example.fitlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitlog.entity.ExerciseLog;


@Repository

public interface ExerciseLogRepository extends JpaRepository<ExerciseLog, Long> {

}
