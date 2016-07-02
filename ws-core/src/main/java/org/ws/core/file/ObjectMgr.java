package org.ws.core.file;

import org.ws.core.Factory;

/**
 * this is the manager of object repository.
 * if the requested business object is existing in object repository,it will be directly returned;
 * else the factory of the type of the requested object will be invoked to create a new instance,
 * then the new instance will be stored into object repository.
 * @author Achilles Liu
 *
 * @param <T>
 */
public class ObjectMgr<T> {
	private ObjectRepo<T> objRepo = new ObjectRepo<T>();
	private Factory<T> factory;
	
	public ObjectMgr(Factory<T> factory){
		this.factory = factory;
	}
	
	public T take(String type){
		T t = objRepo.lookup(type);
		if(t == null){
			t = factory.create(type);
			objRepo.assign(type, t);
		}
		return t;
	}
	
	public void register(String type, T entity){
		objRepo.assign(type, entity);
	}
}
