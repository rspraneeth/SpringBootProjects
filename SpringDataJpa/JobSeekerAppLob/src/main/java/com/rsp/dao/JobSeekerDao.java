package com.rsp.dao;

import com.rsp.bo.JobSeeker;
import org.springframework.data.repository.CrudRepository;

public interface JobSeekerDao extends CrudRepository<JobSeeker, Integer> {
}
