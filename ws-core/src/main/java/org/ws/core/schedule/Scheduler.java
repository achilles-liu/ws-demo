package org.ws.core.schedule;

import java.util.ArrayList;
import java.util.List;

import org.ws.core.schedule.job.Job;
import org.ws.core.schedule.job.JobCenter;
import org.ws.core.schedule.job.JobEvent;


public class Scheduler{
	
	JobCenter jobCenter = new JobCenter();
	
	public void sequence(List<Job> jobs){
		jobCenter.register(jobs);
		jobCenter.dispatch(new JobEvent(jobCenter));
	}
	
	public void schedule(Job job){
		List<Job> jobs = new ArrayList<Job>();
		sequence(jobs);
	}
}
