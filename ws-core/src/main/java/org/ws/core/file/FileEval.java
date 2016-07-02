package org.ws.core.file;

/**
 * the file parser interface.
 * you can extend this interface to customize which file type you want to parse.
 * @author Achilles Liu
 *
 */
public interface FileEval {
	
	/**
	 * parse the specified file.
	 * @param file
	 */
	void eval(FileInfo file);
}
