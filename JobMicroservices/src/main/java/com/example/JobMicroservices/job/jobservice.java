package com.example.JobMicroservices.job;

import com.example.JobMicroservices.job.dto.jobwithcompanydto;

import java.util.List;

public interface jobservice {
    List<jobwithcompanydto> findall();
    void createjob(job job);

    job getjobbyid(Long id);

    boolean deletejobbyid(Long id);

    boolean updatejobbyid(Long id, job updatedjob);
}
