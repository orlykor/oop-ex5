package oop.ex5.filters;

import java.io.File;

/**
 * This class implements the Filter interface.
 * it returns all the files in the directory
 * 
 * @author orlykor12
 *
 */
public class AllFilter implements Filter {
	
	@Override
	public boolean isFilePassFilter(File f) {
		return true;
	}
	
}
