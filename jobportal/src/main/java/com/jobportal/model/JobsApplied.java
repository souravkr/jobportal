package com.jobportal.model;

public class JobsApplied {
	
	int jid;
	
	String userName;

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public JobsApplied() {
		super();
	}

	public JobsApplied(int jid, String userName) {
		super();
		this.jid = jid;
		this.userName = userName;
	}
	
	

}
