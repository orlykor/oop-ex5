package oop.ex5.filters;

import java.io.File;

/**
 * This class extends the the super class IsAFileFilter. it checks if the given
 * file is writable.
 * 
 * @author orlykor12
 *
 */
public class WritableFilter extends IsAFileFilter implements Filter {
	
	/**
	 * The constructor
	 *
	 * @param name the name of the filter
	 * @throws FilterException
	 */
	public WritableFilter(String value) throws FilterException {
		checkValue(value);
	}
	
	@Override
	public boolean isFilePassFilter(File f) {
		if (flag && f.canWrite() || !flag && !f.canWrite()) {
			return true;
		}
		return false;
	}
	
}
