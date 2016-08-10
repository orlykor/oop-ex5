package oop.ex5.filescript;

import java.io.File;
import java.io.IOException;
//import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;

//import java.text.*;

import oop.ex5.filters.*;
import oop.ex5.orders.*;

/**
 * The main class which run the program.
 * it prints all the filtered files in the right order and handle the exceptions if needed.
 * 
 * @author orlykor12
 *
 */
public class MyFileScript {
	/**Type 1 of error exception**/
	private final static String TYPE1_ERROR = "Warning in line ";
	
	/**Type 2 of error exception**/
	private final static String TYPE2_ERROR = "ERROR";
	
	/**The maximum arguments allowed to insert**/
	private final static int MAX_ARGS = 2;
	
	/**The first argument is the directory **/
	private final static int DIRECTORY = 0;
	
	/**The seconds argument is the file name path**/
	private final static int FILE = 1;
	
	static Filter filter;
	static Order order;
	
	/* The method runs throw all the files in the directory, if it is not a file(for ex. its a folder)
	 * then its not added to the list of files.
	 * @param sourceDir the directory the files are in
	 * @return filesInDir all the files that in the directory. 
	 */
	private static ArrayList<File> getFiles(File sourceDir) {
		ArrayList<File> filesInDir = new ArrayList<File>();
		if (sourceDir.exists() && sourceDir.isDirectory()) {
			File[] allDirItems = sourceDir.listFiles();
			for (File file : allDirItems) {
				if (file.isFile() && file != null) {
					filesInDir.add(file);
				}
			}
		}
		return filesInDir;
	}
	
	/* Create a list of files from the files in the sourceDir, create a list of sections from the
	 * commandfile with the parser, then for each section it creates a certain section from it.
	 * @param sourceDir the directory the file's in it
	 * @param commandfile the file's name
	 * @throws FileScriptErrorException
	 * @throws IOException 
	 */
	private static void fileManager(File sourceDir, File commandfile) throws FileScriptErrorException,
			IOException {
		ArrayList<File> allSourceDirFiles = getFiles(sourceDir);
		ArrayList<Section> sections = Parser.parseFile(commandfile);
		for (Section currSection : sections) {
			createSection(allSourceDirFiles, currSection);
		}
	}
	
	/* creates the filters and the orders as needed, then sorts the filters in the right order, and
	 * prints them.
	 * if an exception was caught then its handled here.
	 * @param filesInDir all the files in the directory
	 * @param section the section to take the filter and order from it 
	 */
	private static void createSection(ArrayList<File> filesInDir, Section section) {
		
		try {
			filter = FilterFactory.createFilter(section.getFilter());
		} catch (FilterException e) {
			System.err.println(TYPE1_ERROR + section.getFilterLine());
			filter = FilterFactory.createDefaultFilter();
		}
		try {
			order = OrderFactory.createOrder(section.getOrder());
		} catch (OrderException e) {
			System.err.println(TYPE1_ERROR + section.getOrderLine());
			order = OrderFactory.createDefaultOrder();
		}
		ArrayList<File> filesToOrder = filesThatPassed(filesInDir);
		order.getItemsSorted(filesToOrder);
		for (File file : filesToOrder) {
			System.out.println(file.getName());
		}
		
	}
	
	/* Take the files and check if they pass the filter or not, if they pass put them in
	 * a list, if not continue.
	 * @param files the files to check if pass
	 * @return filesThatPassed files that passed the filter 
	 */
	private static ArrayList<File> filesThatPassed(ArrayList<File> files) {
		ArrayList<File> filesThatPassed = new ArrayList<File>();
		for (File currFile : files) {
			if (filter.isFilePassFilter(currFile)) {
				filesThatPassed.add(currFile);
			}
		}
		return filesThatPassed;
	}
	
	/**
	 * the main method that runs the program.
	 * 
	 * @param args the directory of the file and the name of the file in a form of a path
	 */
	public static void main(String[] args) {
		try {
			if (args.length != MAX_ARGS) {
				throw new FileScriptErrorException();
			}
			File sourceDir = new File(args[DIRECTORY]);
			File commandfile = new File(args[FILE]);		
			fileManager(sourceDir, commandfile);
		} catch (IOException | FileScriptErrorException e) {
			System.err.println(TYPE2_ERROR);
		}
	}
}
