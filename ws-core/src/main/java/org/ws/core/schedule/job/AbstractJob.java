package org.ws.core.schedule.job;


public abstract class AbstractJob implements Job{
	
	protected boolean nextJob = true;
	private String name;
	
	public AbstractJob(String name){
		this.name = name;
	}
	
	public void fire(JobEvent event) {
		if(nextJob()){
			JobInfo j = execute();
			if(j.getStatus() == JobStatus.SUCCESS){
				JobCenter jc = (JobCenter) event.getSource();
				JobEvent je = new JobEvent(event.getSource());
				jc.dispatch(je);
			}
		}
	}

	public boolean nextJob() {
		return this.nextJob;
	}

	public String getName() {
		return this.name;
	}
	
}
