package oop.ex5.filters;

import java.io.File;

/**
 * This class uses as a decorator and reverse the action the filter classes do.
 * 
 * @author orlykor12
 *
 */
public class FilterDecorator implements Filter {
	private Filter filter;
	
	/**
	 * The constructor
	 * 
	 * @param filter the filter needed to be done
	 */
	public FilterDecorator(Filter filter){
		this.filter = filter;
	}
	
	@Override
	public boolean isFilePassFilter(File f) {
		return !filter.isFilePassFilter(f);
	}

}
