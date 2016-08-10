package oop.ex5.orders;

import java.io.File;
import java.util.*;

/**
 * The class is a singleton class that implements the Order interface this class
 * sorts the files from a-z.
 * 
 * @author orlykor12
 * 
 */
public class AbsOrder implements Order {

    /**The first file is smaller then the second one**/
    private final static int SMALLER = -1;
    
    /**The first file is bigger then the second one**/
    private final static int BIGGER = 1;
    
    private static AbsOrder instance = new AbsOrder();

    /* A private Constructor prevents any other class from instantiating. */
    private AbsOrder() {
    }

    /* Static 'instance' method */
    public static AbsOrder getInstance() {
	return instance;
    }

    @Override
    public int compare(File file1, File file2) {
	if (file1.compareTo(file2) < 0) {
	    return SMALLER;
	} else if (file1.compareTo(file2) > 0) {
	    return BIGGER;
	} else {
	    return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
	}
    }

    @Override
    public void getItemsSorted(ArrayList<File> items) {
	Collections.sort(items, this);

    }

}
