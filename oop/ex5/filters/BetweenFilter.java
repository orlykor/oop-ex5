package oop.ex5.filters;

import java.io.File;

/**
 * This class extends the super class SizeFilters. it checks whether the files
 * are between the given numbers
 * 
 * @author orlykor12
 *
 */
public class BetweenFilter extends SizeFilters implements Filter {
	
	double lowerval, upperval;
	
	/**
	 * The constructor
	 * 
	 * @param name the name of the filter's order
	 * @throws FilterException
	 */
	public BetweenFilter(String lowerval, String upperval) throws FilterException {
		this.lowerval = Double.parseDouble(lowerval) * KILO;
		this.upperval = Double.parseDouble(upperval) * KILO;
		if (this.upperval < this.lowerval && (this.upperval < 0 || this.lowerval < 0))
			throw new FilterException();
	}
	
	/**
	 * checks if the file matches the given criterion
	 * 
	 * @return true if the file matches the criterion, false otherwise.
	 */
	public boolean isFilePassFilter(File f) {
		if (lowerval <= f.length() && f.length() <= upperval)
			return true;
		return false;
	}
	
}
