package org.ws.client.file;

import org.ws.file.api.FileEval;

/**
 * Actually, this class should be treated as a service that parse file with specified extension such as .txt or .xlsx,etc.
 * @author Achilles Liu
 *
 */
public class FileProcessor {
	private FileEval fileEval;
	private String path;
	
	public void setPath(String path){
		this.path = path;
	}
	
	public void setFileEval(FileEval fileEval){
		this.fileEval = fileEval;
	}
	
	public void process(){
		this.fileEval.eval(path);
	}
}
