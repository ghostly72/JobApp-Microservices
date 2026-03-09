package com.example.JobMicroservices.job.impl;


import com.example.JobMicroservices.job.dto.jobwithcompanydto;
import com.example.JobMicroservices.job.external.company;
import com.example.JobMicroservices.job.job;
import com.example.JobMicroservices.job.jobrepo;
import com.example.JobMicroservices.job.jobservice;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class jobserviceimpl implements jobservice {
//    List<job> jobs=new ArrayList<>();
    jobrepo jobrepo;

    public jobserviceimpl(jobrepo jobrepo) {
        this.jobrepo = jobrepo;
    }

    @Override
    public List<jobwithcompanydto> findall() {
        List<job> jobs=jobrepo.findAll();
        List<jobwithcompanydto> jobwithcompanydtos=new ArrayList<>();
        //helps to communicate with company microservice
        RestTemplate restTemplate=new RestTemplate();

        for(job job:jobs){
            jobwithcompanydto jobwithcompanydto=new jobwithcompanydto();
            jobwithcompanydto.setJob(job);
            company company=restTemplate.getForObject("http:localhost:8081/companies/"+job.getCpyid(), company.class);
            jobwithcompanydto.setCompany(company);
            jobwithcompanydtos.add(jobwithcompanydto);
        }


//        company company=restTemplate.getForObject("http://localhost:8081/companies/1", company.class);
        return jobwithcompanydtos;
    }

    @Override
    public void createjob(job job) {
        jobrepo.save(job);
    }

    @Override
    public job getjobbyid(Long id) {
        return jobrepo.findById(id).orElse(null);
    }

    @Override
    public boolean deletejobbyid(Long id) {
        try{
            jobrepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatejobbyid(Long id, job updatedjob) {
        Optional<job> jobOptional=jobrepo.findById(id);

//        if(){
            if(jobOptional.isPresent()){
                job j=jobOptional.get();
                j.setDescription(updatedjob.getDescription());
                j.setLocation(updatedjob.getLocation());
                j.setMaxsalary(updatedjob.getMaxsalary());
                j.setMinsalary(updatedjob.getMinsalary());
                j.setTitle(updatedjob.getTitle());
                jobrepo.save(j);
                return true;
            }
//        }
        return false;
    }
}
