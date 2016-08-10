package oop.ex5.orders;

/**
 * The class creates the right instance considering the given order.
 * 
 * @author orlykor12
 *
 */
public class OrderFactory {
	
	/** The reverse order **/
	private final static String REVERSE = "REVERSE";
	
	/** The abs order **/
	private final static String ABS = "abs";
	
	/** The type order **/
	private final static String TYPE = "type";
	
	/** The size order **/
	private final static String SIZE = "size";
	
	/** No order, the default order **/
	private final static String NO_LINE = "";
	
	/**
	 * Creates the default Order, the AbsOrder if no command was given
	 * 
	 * @return an instance of AbsOrder.
	 */
	public static Order createDefaultOrder() {
		return AbsOrder.getInstance();
	}
	
	/**
	 * Checks what order was given.
	 * if it has the string "reverse" in it, then delete that string, and call the
	 * method again in the decorator class.
	 * 
	 * @param orderString the order needs to be done
	 * @return instance of the correct order
	 */
	public static Order createOrder(String orderString) throws OrderException {
		if (orderString.contains(REVERSE)) {
			String newName = orderString.replace("#" + REVERSE, "");
			return new OrderDecorator(createOrder(newName));
		}
		switch (orderString) {
			case ABS:
				return AbsOrder.getInstance();
			case TYPE:
				return TypeOrder.getInstance();
			case SIZE:
				return SizeOrder.getInstance();
			case NO_LINE:
				return createDefaultOrder();
		}
		throw new OrderException();
	}
	
}
