package oop.ex5.filters;

/**
 * This class is responsible for the errors of the Filter class.
 * 
 * @author orlykor12
 *
 */
public class FilterException extends Exception {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new exception with null as its detail message.
	 */
	public FilterException() {
		
	}
	
	/**
	 * Constructs a new exception with the specified detail message
	 * 
	 * @param message
	 */
	public FilterException(String message) {
		super(message);
	}
}
