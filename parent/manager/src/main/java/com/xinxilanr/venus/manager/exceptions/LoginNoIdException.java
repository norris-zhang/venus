/**
 * 
 */
package com.xinxilanr.venus.manager.exceptions;

/**
 * @author norris
 *
 */
public class LoginNoIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public LoginNoIdException() {
		super();
	}

	public LoginNoIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginNoIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginNoIdException(String message) {
		super(message);
	}

	public LoginNoIdException(Throwable cause) {
		super(cause);
	}
	
}
