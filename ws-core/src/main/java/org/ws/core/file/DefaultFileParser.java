package org.ws.core.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ws.core.Factory;
import org.ws.file.api.FileParser;

/**
 * this is the default implementation of <code>FileParser</code> interface.
 * @author Achilles Liu
 *
 */
public class DefaultFileParser implements FileParser {
	
	/**
	 * the object manager to fine the corresponding parser to parse file.
	 */
	private ObjectMgr<FileEval> evalMgr;
	/**
	 * the type manager to store the supported type.
	 */
	private TypeMgr typeMgr;
	
	/**
	 * the instance of <code>FileInfo</code> class.
	 */
	private FileInfo file;
	
	/**
	 * the file path
	 */
	private String path;
	
	/**
	 * whether or not the path is updated.
	 */
	private boolean hasUpdated = false;
	
	public DefaultFileParser(){
		this(null);
	}
	
	public DefaultFileParser(String path){
		this.path = path;
		this.hasUpdated = true;
		this.typeMgr = new TypeMgr();
		initEvalFactory();
	}
	
	private void initEvalFactory(){
		Factory<FileEval> factory = new FileEvalFactory(typeMgr);
		this.evalMgr = new ObjectMgr<FileEval>(factory);
	}
	
	private void init(){
		String ext = validate(path);
		file = new FileInfo(path,ext);
	}
	
	public void setPath(String path){
		this.hasUpdated = true;
		this.path = path;
	}
	
	private String validate(String path){
		if(null == path){
			throw new UnsupportedFileException("no any file to parser!");
		}
		String regex = ".+\\.(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(path);
		if(!matcher.find()){
			throw new UnsupportedFileException("unsupported file format!");
		}
		String extension = matcher.group(1);
		if(!typeMgr.containsType(extension)){
			throw new UnsupportedFileException("unsupported file format!");
		}
		return extension;
	}

	public void execute() {
		if(hasUpdated){
			init();
		}
		FileEval eval = evalMgr.take(file.getExtension());
		eval.eval(file);
	}

	public void register(String ext, String name) {
		try {
			Class<?> clz = Class.forName(name);
			register(ext, clz);
		} catch (ClassNotFoundException e) {
			throw new UnsupportedFileException(e);
		}
	}

	public void register(String ext, Class<?> clazz) {
		boolean isAvailable = FileEval.class.isAssignableFrom(clazz);
		if(!isAvailable) throw new UnsupportedFileException("the type should extend the FileEval interface!");
		if(!typeMgr.containsType(ext)){
			typeMgr.register(ext, clazz.getName());
		}
	}

}
