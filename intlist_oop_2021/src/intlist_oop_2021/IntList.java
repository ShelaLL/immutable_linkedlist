package intlist_oop_2021;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of int values.
 * 
 * @invar | getElements() != null
 * 
 * @immutable
 */
public class IntList {
	
	/**
	 * Returns an array containing the elements of this object
	 * 
	 * @creates | result
	 */
	//Using the create demands the class to create a new array object every time we called getElements()
	public int[] getElements() { throw new RuntimeException("Not yet implemented");}

	/**
	 * Initializes this object so that it represents of int values contained in the given array.
	 * @pre | elements != null
	 * 
	 * @post| Arrays.equals(getElements(), elements)
	 */
	//Allow the class to create a new array object whenever the getElements() is called. Cannot write getElements()==elements
	//We want to compare the contents of the array--> use the helper method from the java library
	public IntList(int[] elements){ throw new RuntimeException("Not yet implemented");}
}
