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
	
	
	//Can only be used in the IntList class, so it is a nested class, using static to define
	private static class Node{
		private int value;
		/**
		 * @peerObject
		 */
		//also a representationObject of whatever object the personal representation object are???
		//peer object of the current node
		//Node next is the peerObject of a node
		//All of the node objects are representationObjects of the IntList
		private Node next;
		
		
		private static boolean hasLength(Node node, int length) {
			return length == 0? node == null : length > 0 && node != null && hasLength(node.next, length - 1);
			
//			if(length == 0)
//				return node == null;
//			else
//				return length > 0 && node != null && hasLength(node.next, length - 1);
			
//			condition ? true value : false value
		} 
		
	}
	
	/**
	 * @invar | Node.hasLength(head, length)
	 * 
	 * @representationObject
	 */
	private int length;
	
	/**
	 * @representationObject
	 */
	private Node head;
	
	
	/**
	 * Returns an array containing the elements of this object
	 * 
	 * @creates | result
	 */
	//Using the create demands the class to create a new array object every time we called getElements()
	public int[] getElements() {
		int[] result = new int[length];
		Node node = head;
		int i = 0;
		while (node != null) {
			result[i++] = node.value;
			node = node.next;
		}
		return result;
}
	
	private static Node createNodes(int[] elements, int index) {
		if(index == elements.length)
			return null;
		else {
			Node head = new Node();
			head.value = elements[index];
			head.next = createNodes(elements, index + 1);
			return head;
		}
	}

	/**
	 * Initializes this object so that it represents of int values contained in the given array.
	 * @pre | elements != null
	 * 
	 * @post| Arrays.equals(getElements(), elements)
	 */

	public IntList(int[] elements){ 
		this.head = createNodes(elements, 0);
		this.length = elements.length;
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
