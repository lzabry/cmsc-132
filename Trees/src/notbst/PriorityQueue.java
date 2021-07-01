package notbst;

import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> {
	ArrayList<E> array;
	
	// PARENT OF idx = (idx - 1) / 2
	// LEFT CHILD OF idx = 2 * idx + 1
	// RIGHT CHILD OF idx = 2 * idx + 2
	
	
	public PriorityQueue() {
		array = new ArrayList<>();
	}
	
	/* 
	 * Enqueues the data into the priority queue, if not null.
	 */
	public boolean add(E data) {
		if(data == null) {
			throw new NullPointerException();
		}
		array.add(data);
		int idx = array.size() - 1;

		// While parent is greater than new value, swap them.
		// Why no base case (no parents)?
	
//		int parent = (idx - 1) / 2;
//		while(array.get(parent).compareTo(array.get(idx)) > 0) {
//			swap(idx, parent);
//			idx = parent;
//			parent = (idx - 1) / 2;
//		}
		
		swapIfLargerParent(idx);
		
		return true;
	}
	
	private void swapIfLargerParent(int idx) {
		int parent = (idx - 1) / 2;
		if(array.get(parent).compareTo(array.get(idx)) > 0) {
			swap(idx, parent);
			swapIfLargerParent(parent);
		}
	}
	
	// while(stmt1) {
	//	stmts;
	//}
	
	// foo() {
	//	if(stmt1) {
	//	stmt2;
	//	foo();
	//	}
	
	
	private void swap(int val1, int val2) {
		E temp = array.get(val1);
		array.set(val1, array.get(val2));
		array.set(val2, temp);
	}
	
	/*
	 * Polls the next value out of the priority queue, or null if no element exists.
	 */
	public E poll() {
		if(array.size() == 0) {
			return null;
		}
		
		E ret = array.get(0);
		array.set(0, array.get(array.size() - 1));
		array.remove(array.size() - 1);
		
		int idx = 0, left = 2 * idx + 1, right = 2 * idx + 2;
		
		// While idx has left child
		while(left < array.size()) {
			// If idx doesn't have a right child
			if(right == array.size()) {
				// If right doesn't exist, only check left
				if(array.get(left).compareTo(array.get(idx)) < 0) {
					swap(left, idx);
				}
				break;
			// Else if left child is smaller than idx
			} else if(array.get(left).compareTo(array.get(idx)) < 0) {
			// Find smaller child and swap it with idx
			// Does not matter which if children are equal
				if(array.get(left).compareTo(array.get(right)) > 0) {
					swap(right, idx);
					idx = right;
				} else {
					swap(left, idx);
					idx = left;
				}
			// Else if right child is smaller than idx
			// No need to check left, condition above tells us it's
			// larger than idx, and thus also larger than right
			} else if(array.get(right).compareTo(array.get(idx)) < 0) {
				swap(right, idx);
				idx = right;
			// Else, 
			} else {
				break;
			}
			left = 2 * idx + 1;
			right = 2 * idx + 2;
		}
		
		return ret;
	}
	
	public E peek() {
		return array.isEmpty() ? null : array.get(0);
	}
	
	public void clear() {
		array.clear();
	}
	
	public boolean contains(Object o) {
		return array.contains(o);
	}
	
	public boolean offer(E e) {
		return add(e);
	}
	
	public boolean remove(Object o) {
		int idx = array.indexOf(o);
		if(idx == -1) {
			return false;
		}
		
		array.set(idx, array.get(array.size() - 1));
		array.remove(array.get(array.size() - 1));
		
		// Same algorithm for poll, but not necessarily starting at 0.
		int left = 2 * idx + 1, right = 2 * idx + 2;
		
		while(left < array.size()) {
			if(right == array.size()) {
				if(array.get(left).compareTo(array.get(idx)) < 0) {
					swap(left, idx);
				}
				break;
			} else if(array.get(left).compareTo(array.get(idx)) < 0) {
				if(array.get(left).compareTo(array.get(right)) > 0) {
					swap(right, idx);
					idx = right;
				} else {
					swap(left, idx);
					idx = left;
				}
			} else if(array.get(right).compareTo(array.get(idx)) < 0) {
				swap(right, idx);
				idx = right;
			} else {
				break;
			}
			left = 2 * idx + 1;
			right = 2 * idx + 2;
		}
		
		return true;
	}
	
	public int size() {
		return array.size();
	}
	
	public Iterator<E> iterator() {
		return array.iterator();
	}
	
	public Object[] toArray() {
		return array.toArray();
	}
	
	public <T> T[] toArray(T[] arr) {
		return array.toArray(arr);
	}
}
