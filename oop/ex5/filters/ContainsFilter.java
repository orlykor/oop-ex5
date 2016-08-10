package oop.ex5.filters;

import java.io.File;

/**
 * This class implements the Filter interface it checks if the given file name
 * contains the given string in it.
 * 
 * @author orlykor12
 *
 */
public class ContainsFilter implements Filter {
	private String partialname;

	/**
	 * The constructor
	 * 
	 * @param name the name of the filter
	 */
	public ContainsFilter(String name) {
		this.partialname = name;

	}

	@Override
	public boolean isFilePassFilter(File f) {
		return f.getName().contains(partialname);

	}

}
