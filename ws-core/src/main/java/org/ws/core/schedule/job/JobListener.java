package org.ws.core.schedule.job;

import java.util.EventListener;

public interface JobListener extends EventListener {
	void fire(JobEvent event);
}
