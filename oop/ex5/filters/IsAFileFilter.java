package oop.ex5.filters;

//import java.io.File;

/**
 * This is a super class that checks if a file is standing of the specific criterion
 * also checks if the given values are of the right mode.
 * 
 * @author orlykor12
 *
 */
public abstract class IsAFileFilter implements Filter {
	
	/** The YES value **/
	private final static String NO = "NO";
	
	/** The NO value **/
	private final static String YES = "YES";
	
//	/** The NOT value to reverse the filter **/
//	private final static String NO = "NO";
	boolean flag = true;
	
	/* checks if the given value is of the right mode
	 * @param value the given value of the filter
	 * @throws FilterException */
	protected void checkValue(String value) throws FilterException {
		if (!value.equals(YES) && !value.equals(NO)) {
			throw new FilterException();
		}
		if (value.equals(NO)) {
			flag = false;
		}
	}
	
}
