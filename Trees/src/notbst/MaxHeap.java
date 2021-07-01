package notbst;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {
	ArrayList<E> array;
	
	public MaxHeap() {
		array = new ArrayList<>();
	}
	
	public boolean add(E data) {
		if(data == null) {
			throw new NullPointerException();
		}
		array.add(data);
		int idx = array.size() - 1, parent = (idx - 1) / 2;

		// While parent is greater than new value, swap them.
		// Why no base case (no parents)?
		while(array.get(parent).compareTo(array.get(idx)) < 0) {
			swap(idx, parent);
			idx = parent;
			parent = (idx - 1) / 2;
		}
		
		return true;
	}
	
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
		
		// While idx has a left child 
		while(left < array.size()) {
			// If idx does NOT have a right child
			if(right == array.size()) {
				// If right doesn't exist, only check left
				if(array.get(left).compareTo(array.get(idx)) > 0) {
					swap(left, idx);
				}
				break;
			// Else if the left child is larger than the idx
			} else if(array.get(left).compareTo(array.get(idx)) > 0) {
			// Find the larger child and swap with it
				if(array.get(left).compareTo(array.get(right)) < 0) {
					swap(right, idx);
					idx = right;
				} else {
					swap(left, idx);
					idx = left;
				}
			// Else if the right child is larger than the idx
			} else if(array.get(right).compareTo(array.get(idx)) > 0) {
				swap(right, idx);
				idx = right;
			// Else, children are smaller than idx, so MaxHeap success!
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
}
