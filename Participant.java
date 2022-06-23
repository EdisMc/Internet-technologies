package models;

import java.io.Serializable;

public class Participant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String job;
	private String reason;
	
	public Participant() {
		
	}
	
	public Participant(String name, String job, String reason) {
		super();
		this.name = name;
		this.job = job;
		this.reason = reason;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
