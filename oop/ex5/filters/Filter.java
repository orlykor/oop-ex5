package oop.ex5.filters;
import java.io.File;

/**
 * The Filter interface
 * 
 * @author orlykor12
 *
 */
public interface Filter {
	
	/**
	 * Checks if the file passes the filter conditions.
	 * 
	 * @param f the file to check if fits
	 * @return true if the file fits, false otherwise.
	 */
	public boolean isFilePassFilter(File f);

}
