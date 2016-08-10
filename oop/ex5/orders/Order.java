package oop.ex5.orders;

import java.io.File;
import java.util.*;

/**
 * The Order interface
 * 
 * @author orlykor12
 * 
 */
public interface Order extends Comparator<File> {
    

    /**
     * sort the items in the right order according to the order command
     * 
     * @param items the items to sort
     */
    public void getItemsSorted(ArrayList<File> items);

}
