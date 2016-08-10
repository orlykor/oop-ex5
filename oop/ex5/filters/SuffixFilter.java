package oop.ex5.filters;

import java.io.File;

/**
 * Checks if the file's name ends with the given value
 * 
 * @author orlykor12
 *
 */
public class SuffixFilter implements Filter {
	
	private String partialname;
	
	/**
	 * The constructor.
	 * 
	 * @param name the suffix name to check
	 */
	public SuffixFilter(String name) {
		this.partialname = name;
	}
	
	@Override
	public boolean isFilePassFilter(File f) {
		
		return f.getName().endsWith(partialname);
	}
	
}
