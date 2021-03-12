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
public class IntList {
	
	/**
	 * @invar | elements != null
	 * @representationObject
	 */
	private int[] elements;
	
	public int[] getElements() {
		return elements.clone();
}
	

	/**
	 * Initializes this object so that it represents of int values contained in the given array.
	 * @pre | elements != null
	 * 
	 * @post| Arrays.equals(getElements(), elements)
	 */

	public IntList(int[] elements){ 
		this.elements = elements.clone();
	}
	
	/**
	 * Inserts the given value at the given index in this object's sequence of values.
	 * 
	 * @mutates | this
	 * mutates clause specify which objects are mutated by this method. This method only has access to one client object--namely the IntList object itself
	 * 
	 * @pre  | 0 <= index && index <= getElements().length
	 * 
	 * @post  | getElements().length == old(getElements()).length + 1
	 * @post  | IntStream.range(0, index).allMatch(i -> getElements()[i] == old(getElements())[i])
	 * 
	 * if write it into old(getElements()[i] is wrong --> because it is interpreted the state before the method is executed. The iteration of i is done after the execution
	 * 
	 *     IntStream.range(a, b).allMatch(i -> P(i))
	 *     for all i.  a <= i < b ==> P(i)     (a inclusive, b exclusive)
	 *     
	 * @post  | getElements()[index] == value
	 * @post  | IntStream.range(index, old(getElements()).length).allMatch( i -> getElements()[i+1] == old(getElements())[i])
	 * The elements that are behind the index shift one position behind to make place for the new element
	 */
	public void insertElement(int index, int value) {
		int[] newElements = new int[elements.length + 1];
		System.arraycopy(elements, 0, newElements, 0, index);
		//copy the elements from the old array, index 0, newElements, index 0, how many - index)
		newElements[index] = value;
		System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
		
		//install this new array into our new representationObject
		elements = newElements;
	}
	
	/**
	 * Sets the element at the given index to the given value
	 * 
	 * @mutates  | this
	 * 
	 * @pre  | 0 <= index && index < getElements().length
	 * 
	 * @post | getElements().length == old(getElements()).length
	 * @post | IntStream.range(0, getElements().length).allMatch(i -> getElements()[i] == (i == index ? value : old(getElements())[i]))
	 * what happens to all the elements
	 * 
	 * 		condition ? true-value : false-value 
	 */
	//int can never be null, so do not need to write the precondition that index/value != null
	public void setElement(int index, int value) {
		elements[index] = value;
	}
	
	
	/**
	 * Removes the element at the given index from this object's sequence of values
	 * 
	 * @mutates | this
	 * 
	 * @pre | 0 <= index && index< getElements().length
	 * 
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | IntStream.range(0, getElements().length).allMatch( i -> getElements()[i] == old(getElements())[i < index ? i : i + 1])
	 * @param index
	 */
	
	public void removeElement (int index) {
		int[] newElements = new int[elements.length - 1];
		System.arraycopy(elements, 0, newElements, 0, index);
		System.arraycopy(elements, index + 1, newElements, index, newElements.length - index);		
		elements = newElements;
	}	
}
