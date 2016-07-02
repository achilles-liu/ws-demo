package org.ws.core.file;

/**
 * the supported type manager. the default supported types are as follows,
 * (1) the text file[.txt];
 * (2) the excel file[.xls];
 * (3) the excel file[.xlsx];
 * (4) the xml file[.xml];
 * (5) the csv file[.csv];
 * (6) the gz file[.gz].
 * of course, you can register new <code>FileEval</code> to parse the specified file.it's really very flexible.
 * @author Achilles Liu
 *
 */
public class TypeMgr{
	/**
	 * the path of package of file parser.
	 */
	private final static String EVAL_PKG = FileEval.class.getPackage().getName()+".eval";
	
	/**
	 * the class name of text file parser.
	 */
	private final static String TXT_EVAL = EVAL_PKG+".TextFileEval";
	
	/**
	 * the class name of xls file parser.
	 */
	private final static String XLS_EVAL = EVAL_PKG+".XlsExcelFileEval";
	
	/**
	 * the class name of xlsx file parser.
	 */
	private final static String XLSX_EVAL = EVAL_PKG+".XlsxExcelFileEval";
	
	/**
	 * the class name of xml file parser.
	 */
	private final static String XML_EVAL = EVAL_PKG+".XmlFileEval";
	
	/**
	 * the class name of csv file parser.
	 */
	private final static String CSV_EVAL = EVAL_PKG+".CsvFileEval";
	
	/**
	 * the class name of gz file parser.
	 */
	private final static String GZ_EVAL = EVAL_PKG+".GzFileEval";
	
	/**
	 * store which file type will be supported.
	 */
	private ObjectRepo<String> supportedFormat = new ObjectRepo<String>();
	private boolean hasUpdated = false;
	
	public TypeMgr(){
		supportedFormat.assign("txt",TXT_EVAL);
		supportedFormat.assign("xls",XLS_EVAL);
		supportedFormat.assign("xlsx",XLSX_EVAL);
		supportedFormat.assign("xml",XML_EVAL);
		supportedFormat.assign("csv",CSV_EVAL);
		supportedFormat.assign("gz",GZ_EVAL);
	}
	
	public void register(String ext, String name){
		if(!this.hasUpdated){
			this.hasUpdated = true;
		}
		supportedFormat.assign(ext, name);
	}
	
	public String retrieve(String ext){
		return supportedFormat.lookup(ext);
	}
	
	public boolean containsType(String type){
		return supportedFormat.contains(type);
	}

	public boolean isHasUpdated() {
		return hasUpdated;
	}

	public void setHasUpdated(boolean hasUpdated) {
		this.hasUpdated = hasUpdated;
	}
	
}
