package org.ws.core.file;

import org.ws.core.file.eval.GroovyFileEval;
import org.ws.core.file.eval.TarFileEval;
import org.ws.file.api.FileParser;

public class Test {
	public static void main(String[] args) {
		String path = "text.txt";
		FileParser fp = FileParserFactory.newFileParser(path);
		fp.execute();
		
		String p = "text.tar";
		fp.register("tar", TarFileEval.class);
		fp.setPath(p);
		fp.execute();
		
		FileParser f = FileParserFactory.newFileParser();
		String p0 = "text1.txt";
		f.setPath(p0);
		f.execute();
		
		String p1 = "text.groovy";
		FileParser fp1 = FileParserFactory.newFileParser(p1);
		fp1.register("groovy", GroovyFileEval.class);
		fp1.execute();
		
		FileParser f2 = FileParserFactory.newFileParser();
		f2.setPath("test.gz");
		f2.execute();
		
		f2.setPath("test.csv");
		f2.execute();
	}
}
