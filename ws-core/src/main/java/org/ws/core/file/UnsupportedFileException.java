package org.ws.core.file;

public class UnsupportedFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsupportedFileException() {
		super();
	}

	public UnsupportedFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedFileException(String message) {
		super(message);
	}

	public UnsupportedFileException(Throwable cause) {
		super(cause);
	}
	
}	
