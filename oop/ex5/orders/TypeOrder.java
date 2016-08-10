package oop.ex5.orders;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The class implements the Order interface this class sort the files by their
 * type name from a to z.
 * 
 * @author orlykor12
 * 
 */
public class TypeOrder implements Order {

    /**The first file is smaller then the second one**/
    private final static int SMALLER = -1;
    
    /**The first file is bigger then the second one**/
    private final static int BIGGER = 1;
    
    
    private static TypeOrder instance = new TypeOrder();
    AbsOrder absOrder = AbsOrder.getInstance();

    /* A private Constructor prevents any other class from instantiating. */
    private TypeOrder() {
    }

    /* Static 'instance' method */
    public static TypeOrder getInstance() {
	return instance;
    }

    @Override
    public int compare(File file1, File file2) {
	String[] name1 = file1.getName().split("\\.");
	String[] name2 = file2.getName().split("\\.");
	String type1 = name1[name1.length - 1];
	String type2 = name2[name2.length - 1];
	if (type1.compareTo(type2) < 0) {
	    return SMALLER;
	} else if (type1.compareTo(type2) > 0) {
	    return BIGGER;
	}

	else {
	    return absOrder.compare(file1, file2);
	}

    }

    @Override
    public void getItemsSorted(ArrayList<File> items) {
	Collections.sort(items, this);
	{

	}

    }

}
