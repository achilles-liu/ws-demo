package org.ws.core.file;

import org.ws.core.Factory;

/**
 * the factory class used to produce the instance of <code>FileEval</code> interface.
 * @author Achilles Liu
 *
 */
public class FileEvalFactory implements Factory<FileEval> {
	private TypeMgr supportedEvals;
	public FileEvalFactory(TypeMgr supportedEvals){
		this.supportedEvals = supportedEvals;
	}
	
	public FileEval create(String type){
		try {
			String clzz = supportedEvals.retrieve(type);
			Class<?> clz = Class.forName(clzz);
			return (FileEval) clz.newInstance();
		} catch (Exception e) {
			throw new UnsupportedFileException("unknown type!");
		}
	}
}
