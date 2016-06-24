package org.ws.core;

import javax.jws.WebService;

import org.ws.api.IHello;

@WebService(endpointInterface="org.ws.api.IHello")
public class HelloImpl implements IHello {

	public String sayHi(String name) {
		return "Hi,"+name;
	}

}
