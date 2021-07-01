package sorts;

import java.util.Arrays;

public class SortingAlgorithms {
	private Integer[] array;
	private Integer[] original;
	
	public SortingAlgorithms(Integer[] array) {
		this.array = array;
		original = Arrays.copyOf(array, array.length);
	}
	
	public void resetArray() {
		array = Arrays.copyOf(original, original.length);
	}
	
	public Integer[] getArray() {
		return array;
	}
	
	private void swap(int from, int to) {
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}
	
	public void BubbleSort() {
		for(int i = array.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(array[j] > array[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}
	
	public void BubbleSortRec() {
		BubbleHelper1(array.length - 1);
	}
	
	private void BubbleHelper1(int i) {
		BubbleHelper2(0, i);
		i--;
		if(i > 0) {
			BubbleHelper1(i);
		}
	}
	
	private void BubbleHelper2(int j, int i) {
		if(array[j] > array[j + 1]) {
			swap(j, j + 1);
		}
		j++;
		if(j < i) {
			BubbleHelper2(j, i);
		}
	}


	//	for(int i = declaration; condition; increment) {
	//		statements;
	//	}

	//	myForLoop() {
	//		
	//		if(condition) {
	//			myForLoopHelper(declaration);
	//		}
	//	}

	//	myForLoopHelper(int i) {
	//		statements;
	//		increment; 				//modifies i, most likely
	//		if(condition) {
	//			myForLoopHelper(i);
	//		}
	//	}

	//	while(condition) {
	//		stmt;
	//	}

	//	myWhileLoop() {
	//		if(conditon) {
	//			stmt;
	//			myWhileLoop();
	//		}
	//	}
	
	
	public void SelectionSort() {
		for(int i = 0; i < array.length; i++) {
			int min = i;
			for(int j = i; j < array.length; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			
			swap(min, i);
		}
	}
	
	public void InsertionSort() {
		for(int i = 0; i < array.length; i++) {
			int temp = array[i], j;
			
			for(j = i - 1; j >= 0 && array[j] > temp; j--) {
				array[j + 1] = array[j];
			}
			
			array[j + 1] = temp;
		}
	}
	
	public void TreeSort() {
		Tree tree = null;
		for(int i = 0; i < array.length; i++) {
			if(tree == null) {
				tree = new Tree(array[i]);
			} else {
				tree.add(array[i]);
			}
		}
		
		array = tree.inOrderTraversal();
	}
	
	public void HeapSort() {
		MinHeap heap = new MinHeap(array.length);
		
		for(int i = 0; i < array.length; i++) {
			heap.add(array[i]);
		}
		
		for(int i = 0; i < array.length; i++) {
			array[i] = heap.poll();
		}
	}
	
	private class Tree {
		private int data, size;
		private Tree left, right;
		
		private Tree(int data) {
			this.data = data;
			size = 1;
		}
		
		private void add(int data) {
			if(data < this.data) {
				if(left == null) {
					left = new Tree(data);
				} else {
					left.add(data);
				}
			} else {
				if(right == null) {
					right = new Tree(data);
				} else {
					right.add(data);
				}
			}
			size++;
		}
		
		private Integer[] inOrderTraversal() {
			Integer[] arr = new Integer[size];
			inOrderTraversal(arr, 0);
			return arr;
		}
		
		private int inOrderTraversal(Integer[] arr, int idx) {
			if(left != null) {
				idx = left.inOrderTraversal(arr, idx);
			}
			arr[idx++] = data;
			
			if(right != null) {
				idx = right.inOrderTraversal(arr, idx);
			}
			return idx;
		}
	}
	
	private class MinHeap {
		private Integer[] arr;
		private int last;
		
		private MinHeap(int size) {
			arr = new Integer[size];
			last = 0;
		}
		
		private void swap(int val1, int val2) {
			int temp = arr[val1];
			arr[val1] = arr[val2];
			arr[val2] = temp;
		}
		
		private void add(int data) {
			int idx = last;
			
			arr[idx] = data;
			last++;
			
			int parent = (idx - 1) / 2;

			while(arr[parent] > arr[idx]) {
				swap(idx, parent);
				idx = parent;
				parent = (idx - 1) / 2;
			}
		}
		
		private int poll() {
			int ret = arr[0];
			
			arr[0] = arr[last - 1];
			arr[--last] = null;

			int idx = 0, left = 2 * idx + 1, right = 2 * idx + 2;
			
			
			while(left < last) {
				if(right == last) {
					// If right doesn't exist, only check left
					if(arr[left] < arr[idx]) {
						swap(left, idx);
					}
					break;
				} else if(arr[left] < arr[idx]) {
					if(arr[left] > arr[right]) {
						swap(right, idx);
						idx = right;
					} else {
						swap(left, idx);
						idx = left;
					}
				} else if(arr[right] < arr[idx]) {
					swap(right, idx);
					idx = right;
				} else {
					break;
				}
				left = 2 * idx + 1;
				right = 2 * idx + 2;
			}
			
			return ret;
		}
	}
}
