package org.ws.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ws.api.IHello;
import org.ws.client.file.FileProcessor;
import org.ws.scripting.Calculator;

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
    	
    	Calculator calc = (Calculator) cxt.getBean("calculator");
    	System.out.println(calc.add(2, 8));
    	
    	FileProcessor fp = (FileProcessor) cxt.getBean("fileProcessor");
    	fp.process();
    	
    	FileProcessor excelfp = (FileProcessor) cxt.getBean("excelProcessor");
    	excelfp.process();
    }
}
