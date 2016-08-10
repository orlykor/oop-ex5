package oop.ex5.filters;

/**
 * The class creates the right instance considering the given order.
 * 
 * @author orlykor12
 *
 */
public class FilterFactory {
	
	/** the first argument in the list, the name of the filter **/
	private final static int FIRST_ARG = 0;
	
	/** the seconds argument in the list, the value **/
	private final static int SECOND_ARG = 1;
	
	/** the seconds argument in the list, another value for the between filter **/
	private final static int THIRD_ARG = 2;
	
	/**All the types of filters **/
	private final static String NOT = "NOT", GREATER_THAN = "greater_than", BETWEEN = "between",
			SMALLER_THAN = "smaller_than", FILE = "file", PREFIX = "prefix", SUFFIX = "suffix",
			WRITABLE = "writable", EXECUTABLE = "executable", HIDDEN = "hidden", ALL = "all";
	
	/**
	 * Creates the default filter, the Allfilter if no command was given
	 * 
	 * @return an instance of Allfilter filter.
	 */
	public static Filter createDefaultFilter() {
		return new AllFilter();
	}
	
	/**
	 * Checks what filter was given. if it has the string "NOT" in it, then
	 * delete that string, and call the method again in the decorator class.
	 * 
	 * @param filterString the name of the filter
	 * @return instance of a filter
	 */
	public static Filter createFilter(String filterString) throws FilterException {
		if (filterString.contains(NOT)) {
			String newName = filterString.replace("#"+NOT, "");
			return new FilterDecorator(createFilter(newName));
		}
		String[] filterName = filterString.split("#");
		switch (filterName[FIRST_ARG]) {
			case (GREATER_THAN):
				return new GreaterThanFilter(filterName[SECOND_ARG]);
			case (BETWEEN):
				return new BetweenFilter(filterName[SECOND_ARG], filterName[THIRD_ARG]);
			case (SMALLER_THAN):
				return new SmallerThanFilter(filterName[SECOND_ARG]);
			case (FILE):
				return new FileFilter(filterName[SECOND_ARG]);
			case (PREFIX):
				return new PrefixFilter(filterName[SECOND_ARG]);
			case (SUFFIX):
				return new SuffixFilter(filterName[SECOND_ARG]);
			case (WRITABLE):
				return new WritableFilter(filterName[SECOND_ARG]);
			case (EXECUTABLE):
				return new ExecutableFilter(filterName[SECOND_ARG]);
			case (HIDDEN):
				return new HiddenFilter(filterName[SECOND_ARG]);
			case (ALL):
				return new AllFilter();
			default:
				throw new FilterException();
		}
	}
	
}
