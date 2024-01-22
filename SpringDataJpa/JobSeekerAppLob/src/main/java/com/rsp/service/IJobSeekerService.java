package com.rsp.service;

import com.rsp.bo.JobSeeker;

import java.util.Optional;

public interface IJobSeekerService {
    public String registerJobSeeker(JobSeeker jobSeeker);
    public Optional<JobSeeker> getDetailsById(Integer id);
}
