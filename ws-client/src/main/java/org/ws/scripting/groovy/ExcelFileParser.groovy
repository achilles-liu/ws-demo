package org.ws.scripting.groovy

import org.ws.file.api.FileEval
import java.io.FileInputStream
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ExcelFileParser implements FileEval{

	void eval(String path){
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));
		(0..<wb.numberOfSheets).each{ s ->
			XSSFSheet sheet = wb.getSheetAt(s)
			int rows = sheet.physicalNumberOfRows
			println "sheet:"+wb.getSheetName(s)+" has "+rows+" row(s)."
			(1..<rows).each{r ->
				XSSFRow row = sheet.getRow(r)
				if (row != null) {
					int cells = row.physicalNumberOfCells
					def line = "The "+r+"th row :"
					(0..<cells).each{ c ->
						XSSFCell cell = row.getCell(c);
						if(cell != null){
							line += cell
							if(c < cells-1){
								line +="|"
							}
						}
					}
					println line
				}
			}
		}
	}
}