package org.ws.core.file.eval;

import org.ws.core.file.FileEval;
import org.ws.core.file.FileInfo;

/**
 * I recommend to parse excel file using POI.
 * For POI information, please visit http://poi.apache.org/.
 * @author Achilles Liu
 *
 */
public abstract class AbstractExcelFileEval implements FileEval {

	public void eval(FileInfo file) {
		// TODO
	}
	
	public abstract void selectWorkSheet();
}
