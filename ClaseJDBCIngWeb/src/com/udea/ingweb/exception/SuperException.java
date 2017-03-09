package com.udea.ingweb.exception;

/**
 * Clase que hereda de Exception para manejar las excepciones internamente
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 *
 */
public class SuperException extends Exception {

	public SuperException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SuperException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SuperException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SuperException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
