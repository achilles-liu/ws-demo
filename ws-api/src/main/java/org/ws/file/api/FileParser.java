package org.ws.file.api;


/**
 * the file parser interface.
 * @author Achilles Liu
 *
 */
public interface FileParser {
	
	/**
	 * parse the specified file.
	 */
	void execute();
	
	/**
	 * register the new file parser.
	 * @param ext	the file type
	 * @param name	the class name of file parser.It should be the implementation of <code>FileEval</code> interface.
	 */
	void register(String ext, String name);
	
	/**
	 * register the new file parser.
	 * @param ext	the file type
	 * @param clazz	the class of file parser
	 */
	void register(String ext, Class<?> clazz);
	
	/**
	 * set the file's path.
	 * @param path
	 */
	void setPath(String path);
}
