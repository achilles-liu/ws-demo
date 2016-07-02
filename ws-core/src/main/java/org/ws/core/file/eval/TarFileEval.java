package org.ws.core.file.eval;

import org.ws.core.file.FileEval;
import org.ws.core.file.FileInfo;

public class TarFileEval implements FileEval{

	public void eval(FileInfo file) {
		// TODO
		System.out.println(this.getClass().getName()+"::"+file.getFile().getName());
	}

}
