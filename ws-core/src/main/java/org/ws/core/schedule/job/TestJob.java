package org.ws.core.schedule.job;


public class TestJob extends AbstractJob{

	public TestJob(String name) {
		super(name);
	}

	public JobInfo execute() {
		System.out.println("TestJob --->"+this.getName());
		try {
			System.out.println("sleep 5s.");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JobInfo ji = new JobInfo();
		ji.setStatus(JobStatus.SUCCESS);
		return ji;
	}
}
