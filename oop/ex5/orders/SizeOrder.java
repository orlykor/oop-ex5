package oop.ex5.orders;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

//import java.util.Comparator;

/**
 * The class implements the Order interface.
 * this class sort the files by their size, from the smallest to the largest.
 * 
 * @author orlykor12
 * 
 */
public class SizeOrder implements Order {

    /**The first file is smaller then the second one**/
    private final static int SMALLER = -1;
    
    /**The first file is bigger then the second one**/
    private final static int BIGGER = 1;
    
    
    
    private static SizeOrder instance = new SizeOrder();
    AbsOrder absOrder = AbsOrder.getInstance();

    /* A private Constructor prevents any other class from instantiating. */
    private SizeOrder() {
    }

    /* Static 'instance' method */
    public static SizeOrder getInstance() {
	return instance;
    }

    @Override
    public int compare(File file1, File file2) {
	Long sizeFile1 = file1.length();
	Long sizeFile2 = file2.length();
	if (sizeFile1 < sizeFile2) {
	    return SMALLER;
	} else if (sizeFile1 > sizeFile2) {
	    return BIGGER;
	} else {
	    return absOrder.compare(file1, file2);
	}
    }

    @Override
    public void getItemsSorted(ArrayList<File> items) {
	Collections.sort(items, this);

    }

}
