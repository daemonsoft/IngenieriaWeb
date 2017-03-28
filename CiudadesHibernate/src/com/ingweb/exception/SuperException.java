package com.ingweb.exception;

import org.apache.log4j.Logger;

/**
 * Clase que hereda de Exception para manejar las excepciones internamente
 * 
 * @author daemonsoft
 * @since 1.8
 * @version 1.0
 *
 */
public class SuperException extends Exception {

	Logger log = Logger.getLogger(this.getClass());

	public SuperException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		log.error(message, cause);
	}

	public SuperException(String message, Throwable cause) {
		super(message, cause);
		log.error(message, cause);
	}

	public SuperException(String message) {
		super(message);
		log.error(message);
	}

	public SuperException(Throwable cause) {
		super(cause);
		log.error(cause);
	}

}