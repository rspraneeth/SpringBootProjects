package com.rsp.service;

import com.rsp.bo.JobSeeker;
import com.rsp.dao.JobSeekerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService{

    @Autowired
    private JobSeekerDao repo;
    @Override
    public String registerJobSeeker(JobSeeker jobSeeker) {
        return "Saved details with id "+repo.save(jobSeeker).getId();
    }

    @Override
    public Optional<JobSeeker> getDetailsById(Integer id) {
        return repo.findById(id);
    }
}
