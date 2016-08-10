package oop.ex5.filters;

import java.io.File;

/**
 * This class extends the the super class IsAFileFilter. it checks if the given
 * file is executable.
 * 
 * @author orlykor12
 *
 */
public class ExecutableFilter extends IsAFileFilter implements Filter {
	

	/**
	 * The constructor
	 *
	 * @param name  the name of the filter
	 * @throws FilterException 
	 */
	public ExecutableFilter(String value) throws FilterException {
		checkValue(value);
		
	}

	@Override
	public boolean isFilePassFilter(File f) {
		
		if (flag && f.canExecute()
				|| (!flag && !f.canExecute())) {
			return true;
		}
		return false;
	}

}
