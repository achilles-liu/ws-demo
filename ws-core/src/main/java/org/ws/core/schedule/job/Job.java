package org.ws.core.schedule.job;

public interface Job extends JobListener{
	JobInfo execute();
	String getName();
}
