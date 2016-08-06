package org.ws.core.schedule.job;

import java.util.EventObject;

public class JobEvent extends EventObject{

	private static final long serialVersionUID = 1L;

	public JobEvent(Object source) {
		super(source);
	}

}
