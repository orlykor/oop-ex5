package oop.ex5.orders;

/**
 * This class is responsible for the errors of the Order class.
 * 
 * @author orlykor12
 *
 */
public class OrderException extends Exception {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new exception with null as its detail message.
	 */
	public OrderException() {
		
	}
	
	/**
	 * Constructs a new exception with the specified detail message
	 * 
	 * @param message
	 */
	public OrderException(String messegae) {
		super(messegae);
	}
	
}
