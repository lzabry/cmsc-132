package sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		// Just to test if they work...
		Random random = new Random();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < 20; i++) {
			arr.add(random.nextInt(100));
		}
		
		
		SortingAlgorithms sort = new SortingAlgorithms((Integer[]) 
				arr.toArray(new Integer[arr.size()]));
		
		System.out.println("Original: " + Arrays.toString(sort.getArray()));
		
		sort.BubbleSort();
		
		System.out.println("BubbleSort: " + Arrays.toString(sort.getArray()));
		
		sort.resetArray();
		
		sort.BubbleSortRec();
		
		System.out.println("BubbleSort (recursive): " + Arrays.toString(sort.getArray()));
		
		sort.resetArray();
		
		sort.SelectionSort();
		
		System.out.println("SelectionSort: " + Arrays.toString(sort.getArray()));
		
		sort.resetArray();
		
		sort.InsertionSort();
		
		System.out.println("InsertionSort: " + Arrays.toString(sort.getArray()));
		
		sort.resetArray();
		
		sort.TreeSort();
		
		System.out.println("TreeSort: " + Arrays.toString(sort.getArray()));
		
		sort.resetArray();
		
		sort.HeapSort();
		
		System.out.println("HeapSort: " + Arrays.toString(sort.getArray()));
		
		sort.resetArray();
		
		System.out.println("Original: " + Arrays.toString(sort.getArray()));
	}
}
