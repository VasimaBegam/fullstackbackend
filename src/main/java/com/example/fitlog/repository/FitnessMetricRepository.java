package com.example.fitlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitlog.entity.FitnessMetric;


@Repository

public interface FitnessMetricRepository extends JpaRepository<FitnessMetric, Long> 
{





}
