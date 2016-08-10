package oop.ex5.filescript;

/**
 * This class is responsible for making the sections that are made of order and filter for
 * each section
 * 
 * @author orlykor12
 *
 */
public class Section {
	
	/**Get the next line in the text**/
	private final static int ONE_MORE_LINE = 1;
	
	/**Get two more lines in the text**/
	private final static int TWO_MORE_LINES = 2;
	
	
	private String order, filter;
	private int line;
	
	/**
	 * The constructor
	 * 
	 * @param filter the name of the filter
	 * @param order the name of the order
	 * @param line the first line the section starts from
	 */
	public Section(String filter, String order, int line) {
		
		
		this.order = order;
		this.filter = filter;
		this.line = line;
	}
	
	/**
	 * 
	 * @return order the order name
	 */
	public String getOrder() {
		return order;
	}
	
	/**
	 * 
	 * @return filter the filter name
	 */
	public String getFilter() {
		return filter;
	}
	
	/**
	 * 
	 * @return filterLine the line of the filter name
	 */
	public int getFilterLine() {
		int filterLine = line + ONE_MORE_LINE;
		return filterLine;
	}
	
	/**
	 * 
	 * @return orderLine the line of the order name
	 */
	public int getOrderLine() {
		int orderLine = line + TWO_MORE_LINES;
		if (!filter.isEmpty()) {
			orderLine++;
		}
		return orderLine;
	}
	
}
