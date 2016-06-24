package org.ws.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ws.api.IHello;

/**
 * cxf client
 * @author Achilles Liu
 */
public class App 
{
    public static void main( String[] args ){
    	@SuppressWarnings("resource")
		ApplicationContext cxt = new ClassPathXmlApplicationContext("cxf-client.xml");
    	IHello hl = (IHello) cxt.getBean("helloClient");
    	System.out.println(hl.sayHi("Achilles"));
    }
}
