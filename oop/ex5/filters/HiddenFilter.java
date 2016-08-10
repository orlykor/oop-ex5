package oop.ex5.filters;

import java.io.File;

/**
 * this class checks if the given file is classified as a hidden file
 * 
 * @author orlykor12
 *
 */
public class HiddenFilter extends IsAFileFilter implements Filter {
	
	/**
	 * The constructor
	 *
	 * @param name the name of the filter
	 * @throws FilterException
	 */
	public HiddenFilter(String value) throws FilterException {
		checkValue(value);
	}
	
	@Override
	public boolean isFilePassFilter(File f) {
		if (flag && f.isHidden() || (!flag && !f.isHidden())) {
			return true;
		}
		return false;
	}
}
