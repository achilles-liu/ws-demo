package org.ws.api;

import javax.jws.WebService;

@WebService
public interface IHello {
	String sayHi(String name);
}
