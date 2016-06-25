package org.ws.scripting.groovy

import org.ws.file.api.FileEval

class TextFileParser implements FileEval{
	void eval(String path){
		try{
			new File(path).eachLine{
				println it
			}
		}catch(Exception e){
			println e
		}
	}
}