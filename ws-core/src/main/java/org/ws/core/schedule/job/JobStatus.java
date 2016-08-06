package org.ws.core.schedule.job;

public enum JobStatus {
	
	/**
	 * the job is running.
	 */
	RUNNING(0,"running"),
	
	/**
	 * the job has invoked successfully.
	 */
	SUCCESS(1,"success"),
	
	/**
	 * the job failed.
	 */
	FAILURE(2,"failure");
	
	private int id;
	private String name;
	
	JobStatus(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
