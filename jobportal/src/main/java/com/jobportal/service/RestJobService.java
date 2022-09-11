package com.jobportal.service;

import java.util.List;

import com.jobportal.model.Jobs;
import com.jobportal.model.JobsApplied;

public interface RestJobService {

	
	 public List<Jobs> getJobs() ;

	public List<Jobs> getJobByCompany(String string);
	
	 public List<String> getAllCompanies();
	 
	 public Jobs postJobs(Jobs jobs);
	 
	 public void applyJob(JobsApplied jobs);
}
