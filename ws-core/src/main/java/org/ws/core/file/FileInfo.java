package org.ws.core.file;

import java.io.File;

public class FileInfo {
	private String extension;
	private File file;
	
	public FileInfo(){}
	
	public FileInfo(String path,String extension){
		this(new File(path),extension);
	}
	
	public FileInfo(File file, String extension){
		this.file = file;
		this.extension = extension;
	}
	
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
}
