package com.example.JobMicroservices.job.dto;

import com.example.JobMicroservices.job.external.company;
import com.example.JobMicroservices.job.job;

public class jobwithcompanydto {
    private job job;
    private company company;

    public job getJob() {
        return job;
    }

    public void setJob(job job) {
        this.job = job;
    }

    public company getCompany() {
        return company;
    }

    public void setCompany(company company) {
        this.company = company;
    }
}
