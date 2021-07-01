package notbst;

import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		Random random = new Random();
		
		for(int i = 0; i < 20; i++) {
			// Add 20 random numbers from 0 to 100
			queue.add(random.nextInt(100));
		}
		System.out.print("MinHeap: ");
		
		while(queue.peek() != null) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println();
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		
		System.out.print("MaxHeap: ");
		
		for(int i = 0; i < 20; i++) {
			maxHeap.add(random.nextInt(100));
		}
		
		while(maxHeap.peek() != null) {
			System.out.print(maxHeap.poll() + " ");
		}
	}
}
