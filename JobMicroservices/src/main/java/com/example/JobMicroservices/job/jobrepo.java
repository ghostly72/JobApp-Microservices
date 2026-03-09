package com.example.JobMicroservices.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface jobrepo extends JpaRepository<job,Long> {
}
