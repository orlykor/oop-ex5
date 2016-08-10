package oop.ex5.filters;

//import java.io.File;

/**
 * An abstract class that implements the Filter interface.
 * 
 * @author orlykor12
 *
 */
public abstract class SizeFilters implements Filter {
	
	/** The amount needed in order to convert the size **/
	protected final static double KILO = 1024;
	
	protected double value;
	
	/* Checks if the value is not negative
	 * @param value the size to be checked
	 * @throws FilterException */
	protected void isRightIntegerValue(String value) throws FilterException {
		try {
			this.value = Double.parseDouble(value) * KILO;
			if (this.value < 0)
				throw new FilterException();
		} catch (NumberFormatException e) {
		}
	}
}
