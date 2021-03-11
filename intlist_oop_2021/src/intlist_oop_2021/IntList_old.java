package intlist_oop_2021;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of int values.
 * 
 * @invar | getElements() != null
 * 
 * @immutable
 */
public class IntList_old {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	//Any object used by a class to help represent the abstract state of an instance of that class is called the representationObject
	private int[] elements;

	/**
	 * Returns an array containing the elements of this object.
	 * 
	 * @creates | result
	 */
	public int[] getElements() { return elements.clone(); }
	
	/**
	 * Initializes this object so that it represents the sequence of int values contained in the given array.
	 * 
	 * @pre | elements != null
	 * 
	 * @post | Arrays.equals(getElements(), elements)
	 */
	//Allow the class to create a new array object whenever the getElements() is called. Cannot write getElements()==elements
	//We want to compare the contents of the array--> use the helper method from the java library
	public IntList_old(int[] elements) {
		this.elements = elements.clone();
	}

}
