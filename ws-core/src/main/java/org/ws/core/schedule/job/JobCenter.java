package org.ws.core.schedule.job;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JobCenter {
	Queue<Job> queue = new LinkedList<Job>();
	
	public void register(Job job){
		this.queue.offer(job);
	}
	
	public void register(List<Job> jobs){
		this.queue.addAll(jobs);
	}
	
	public void dispatch(JobEvent event){
		Job job = queue.poll();
		if(job != null){
			job.fire(event);
		}
	}
	
}
