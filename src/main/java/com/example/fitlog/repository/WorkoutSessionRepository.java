package com.example.fitlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitlog.entity.WorkoutSession;

@Repository

public interface WorkoutSessionRepository extends JpaRepository <WorkoutSession, Long>
{

}


