package pseudocode;

import java.util.Arrays;

public class SortingAlgorithms {
	private int[] array;
	private int[] original;
	
	public SortingAlgorithms(int[] array) {
		this.array = array;
		original = Arrays.copyOf(array, array.length);
	}
	
	public void resetArray() {
		array = Arrays.copyOf(original, original.length);
	}
	
	public void BubbleSort() {
		// For each index in array
			// For each idx < index in array
				// If array[idx] < array[idx + 1]
					// Swap (idx, idx + 1)
	}
	
	public void SelectionSort() {
		// For each index in array
			// Find min from index to array length
			// Swap (min, index)
	}
	
	public void InsertionSort() {
		// For each index in array
			// For each idx less than index AND array[idx] > array[index]
				// Move array[idx] up
			// Place a[i] at last spot where array[idx] <= array[index]
	}
	
	public void TreeSort() {
		// For each index in array
			// Add array to Binary Search Tree
		// Perform in-order traversal on tree
	}
	
	public void HeapSort() {
		// For each index in array
			// Add array to MinHeap
		// Poll from Heap in order
	}
}
