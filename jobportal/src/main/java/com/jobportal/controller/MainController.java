package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobportal.model.Company;
import com.jobportal.model.Jobs;
import com.jobportal.model.JobsApplied;
import com.jobportal.service.RestJobService;

@Controller
public class MainController {

	@Autowired
	RestJobService service;
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		
		return "fancy-login";
	}

	@GetMapping("/access-denied")
	public String accessDeniedPage() {
		return "joinPrime";
	}
	
	
	@RequestMapping("/home")
	public String displayHome(Model model) {

		/*
		 * model.addAttribute("jobs", service.getJobs());
		 * 
		 * 
		 */

		List<String> companies = service.getAllCompanies();

		model.addAttribute("companies", companies);

		Company company = new Company();

		model.addAttribute("company", company);

		
		/* service.postJobs(new Jobs(1,"QA Tester","Microfocus",45000)); */
		

		return "home";
	}

	@RequestMapping("/getJobs")
	public String displayHomeWithJobs(@ModelAttribute("company") Company company, Model model) {

		
		 List<String> companies = service.getAllCompanies();
		  
		  model.addAttribute("companies",companies);
		  
		  Company companyi = new Company();
		  
		  model.addAttribute("company",companyi);
		  
		  List<Jobs> jobs;
		 
		  if(company.getCompanyName().equalsIgnoreCase("ALL")) {
			   jobs = service.getJobs();
		  }
		  
		  else {
	        	 jobs = service.getJobByCompany(company.getCompanyName());
		  }
		model.addAttribute("jobs", jobs);

		return "home";

	}
	
	@RequestMapping("/postJob")
	public String postJob(Model model) {
		
		Jobs job = new Jobs();
		model.addAttribute("jobs",job);
		
		return "job-form";
	}
	
	@RequestMapping("/processForm")
	public String processPostJob(@ModelAttribute("jobs") Jobs jobs) {
		
		service.postJobs(jobs);
		return "redirect:home";
	}
	
	@GetMapping("/applyJob")
	public String applyJob(@RequestParam("jid") int id) {
		
		service.applyJob(new JobsApplied(2,"souravtest"));
		
		return "redirect:home";
	}
	

}
