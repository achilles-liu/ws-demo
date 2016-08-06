package org.ws.core.schedule.job;

import java.util.Date;

public class JobInfo {
	private JobStatus status;
	private Date startTime;
	private Date endTime;
	private StackTraceElement exception;
	public JobStatus getStatus() {
		return status;
	}
	public void setStatus(JobStatus status) {
		this.status = status;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public StackTraceElement getException() {
		return exception;
	}
	public void setException(StackTraceElement exception) {
		this.exception = exception;
	}
	
}
