package com.jobportal.model;



public class Jobs {



     int id;
	

	String role;
	

	String company;
	

    int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Jobs() {
		super();
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", role=" + role + ", company=" + company + ", salary=" + salary + "]";
	}

	public Jobs(int id, String role, String company, int salary) {
		super();
		this.id = id;
		this.role = role;
		this.company = company;
		this.salary = salary;
	}
	
	
	
}
