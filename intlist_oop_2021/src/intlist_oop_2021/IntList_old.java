package intlist_oop_2021;

import java.util.Arrays;
import java.util.stream.IntStream;

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
	
	/**
	 * Inserts the given value at the given index in this object's sequence of values.
	 * 
	 * @mutates | this
	 * @pre  | 0 <= index && index <= getElements().length
	 * 
	 * @post  | getElements().length == old(getElements()).length + 1
	 * @post  | IntStream.range(0, index).allMatch(i -> getElements()[i] == old(getElements())[i])
	 * 
	 * if write it into old(getElements()[i] is wrong --> because it is interpreted the state before the method is executed. The iteration of i is done after the execution
	 * 
	 *     IntStream.range(a, b).allMatch(i -> P(i))
	 *     for all i.  a <= i < b ==> P(i) 
	 *     a inclusive, b exclusive
	 *     
	 * @post  | getElements()[index] == value
	 * @post  | IntStream.range(index, old(getElements()).length).allMatch( i -> getElements()[i+1] == old(getElements())[i])
	 *     
	 */
	public void insertElement(int index, int value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public void setElement(int index, int value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public void removeElement (int index) {
		throw new RuntimeException("Not yet implemented");
	}	

}
