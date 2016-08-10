package oop.ex5.filescript;

import java.io.*;
import java.util.ArrayList;
import oop.ex5.filters.*;
import oop.ex5.orders.*;

/**
 * This class is responsible to read the given files and create sections with the
 * given "FILTER" and "ORDER" lines in the files.
 * 
 * @author orlykor12
 * 
 */
public class Parser {

    /** The first line of the file **/
    private final static int FIRST_LINE = 1;

    /** The subsection of the order **/
    private final static String ORDER_COMMAND = "ORDER";

    /** The subsection of the filter **/
    private final static String FILTER_COMMAND = "FILTER";

    /** This is the default filer **/
    private final static String DEFAULT_FILTER = "";

    /** This is the default filer **/
    private final static String DEFAULT_ORDER = "";

    Filter newFilter;
    Order newOrder;
    Section[] sec;

    /* A private Constructor prevents any other class from instantiating. */
    private Parser() {

    }

    /**
     * Reads the line from the file, checks if the input of "FILTER" and "ORDER" is as it should be,
     * if not throws an exception. if it is, then it creates sections with filters, orders and line-
     * to flag the line of the filter and order.
     * 
     * @param f the file to read from
     * @return sectionsList a list of sections
     * @throws FileScriptErrorException
     * @throws IOException
     */
    public static ArrayList<Section> parseFile(File f) throws FileScriptErrorException, IOException {
	ArrayList<Section> sectionsList = new ArrayList<Section>();
	FileReader file = new FileReader(f);

	BufferedReader reader = new BufferedReader(file);
	String filter = DEFAULT_FILTER, order = DEFAULT_ORDER;
	int lineNumber = FIRST_LINE;
	String line = reader.readLine();

	while (line != null) {
	    if (line.equals(FILTER_COMMAND)) {
		line = reader.readLine();
		lineNumber++;
	    } else {
		reader.close();
		throw new FileScriptErrorException();
	    }
	    if (line.equals(ORDER_COMMAND)) {
		filter = DEFAULT_FILTER;
	    } else {
		filter = line;
		line = reader.readLine();
		lineNumber++;

	    }
	    if(line == null){
		reader.close();

		throw new FileScriptErrorException();
	    }
	    else if (line.equals(ORDER_COMMAND)){
		line = reader.readLine();
		lineNumber++;
		if (line == null) {
		    if (filter.isEmpty()) {
			sectionsList.add(new Section(filter, order, lineNumber - 2));
		    }
		
		    sectionsList.add(new Section(filter, order, lineNumber - 3));
		}
		else if (line.equals(FILTER_COMMAND)){
//		    if (line.equals(FILTER_COMMAND)) {
			order = DEFAULT_ORDER;
			sectionsList.add(new Section(filter, order, lineNumber - 2));
			line = FILTER_COMMAND;
			
		    } 
		else {
			order = line;
		    
		    if (filter.isEmpty()) {
			sectionsList.add(new Section(filter, order, lineNumber - 2));
		    }
		    sectionsList.add(new Section(filter, order, lineNumber - 3));
		    line = reader.readLine();
		    lineNumber++;
		}
	    }else {
		reader.close();
		throw new FileScriptErrorException();
	    }
	}
	reader.close();
	return sectionsList;

    }
}
