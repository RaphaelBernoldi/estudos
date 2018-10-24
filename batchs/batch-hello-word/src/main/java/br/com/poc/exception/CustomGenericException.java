package br.com.poc.exception;

public class CustomGenericException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CustomGenericException(String msg) {
		super(msg);
	}
}
