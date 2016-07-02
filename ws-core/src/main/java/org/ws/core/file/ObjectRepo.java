package org.ws.core.file;

import java.util.HashMap;
import java.util.Map;

/**
 * this is the business repository to store business object 
 * like the implementation of <code>FileEval</code> interface.
 * @author Achilles Liu
 *
 * @param <T>
 */
public class ObjectRepo<T> {
	private Map<String, T> cup = new HashMap<String, T>();
	
	public T lookup(String type){
		return cup.get(type);
	}
	
	public void assign(String type, T eval){
		if(!cup.containsKey(type)){
			cup.put(type, eval);
		}
	}
	
	public boolean contains(String type){
		return cup.containsKey(type);
	}
}
