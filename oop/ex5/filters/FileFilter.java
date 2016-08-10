package oop.ex5.filters;

import java.io.File;

/**
 * This class implements the filter interface. it checks whether the name of the
 * file is the same as the name of the given string.
 * 
 * @author orlykor12
 *
 */
public class FileFilter implements Filter {
	private String filename;

	/**
	 * The constructor
	 * 
	 * @param name
	 *            the name of the filter
	 */
	public FileFilter(String name) {
		this.filename = name;
	}

	@Override
	public boolean isFilePassFilter(File f) {
		if (f.getName().equals(this.filename)) {
			return true;
		}
		return false;
	}

}
