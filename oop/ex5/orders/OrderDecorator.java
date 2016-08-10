package oop.ex5.orders;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class implements the Order interface.
 * it uses as a decorator and reverse the action the order classes do.
 * 
 * @author orlykor12
 * 
 */
public class OrderDecorator implements Order {

    private Order order;

    /**
     * The constructor
     * 
     * @param order the order needs to be done
     */
    public OrderDecorator(Order order) {
	this.order = order;
    }

    @Override
    public int compare(File o1, File o2) {
	return (order.compare(o1, o2));
    }

    @Override
    public void getItemsSorted(ArrayList<File> items) {
	order.getItemsSorted(items);
	Collections.reverse(items);

    }

}
