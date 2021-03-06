package oop.ex5.filters;

import java.io.File;

/**
 * this class checks if the given file is smaller then the given value
 * 
 * @author orlykor12
 *
 */
public class SmallerThanFilter extends SizeFilters implements Filter {
	
	/**
	 * the constructor
	 * 
	 * @param name the name of the filter's order
	 * @throws FilterException
	 */
	public SmallerThanFilter(String value) throws FilterException {
		isRightIntegerValue(value);
	}
	
	/**
	 * checks if the file is smaller then the given criterion
	 * 
	 * @return true if the file matches the criterion
	 */
	public boolean isFilePassFilter(File f) {
		if (f.length() < value) {
			return true;
		}
		return false;
	}
	
}
