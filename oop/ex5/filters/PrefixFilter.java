package oop.ex5.filters;

import java.io.File;

/**
 * Checks if the file's name starts with the given value
 * 
 * @author orlykor12
 *
 */
public class PrefixFilter implements Filter {
	private String partialname;

	/**
	 * The constructor
	 * 
	 * @param name the prefix name to check
	 */
	public PrefixFilter(String name){
		this.partialname = name;
	}
	
	@Override
	public boolean isFilePassFilter(File f) {

		return f.getName().startsWith(partialname);
	}
		
	
}
