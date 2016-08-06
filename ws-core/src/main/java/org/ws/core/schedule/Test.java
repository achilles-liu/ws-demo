package org.ws.core.schedule;

import java.util.ArrayList;
import java.util.List;

import org.ws.core.schedule.job.Job;
import org.ws.core.schedule.job.TestJob;

public class Test {

	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(new TestJob("Mail Job"));
		jobs.add(new TestJob("Parse File Job"));
		jobs.add(new TestJob("Restrieve DB Job"));
		
		Scheduler sl = new Scheduler();
		sl.sequence(jobs);
	}

}
