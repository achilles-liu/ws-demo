package org.ws.core.file;

import org.ws.file.api.FileParser;

public class FileParserFactory{

	public static FileParser newFileParser(String path) {
		return new DefaultFileParser(path);
	}
	
	public static FileParser newFileParser(){
		return new DefaultFileParser();
	}
}
