package bst;

import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		Random random = new Random();
		
		BinarySearchTree tree = new BinarySearchTree(random.nextInt(100));
		
		for(int i = 0; i < 19; i++) {
			tree.put(random.nextInt(100));
		}
		
		System.out.println("Initial tree: " + tree.toString());
		
		
		// Random try to delete some values - are we lucky enough to hit
		// the same number in both put and remove?
		for(int i = 0; i < 20; i++) {
			tree = tree.remove(random.nextInt(100));
		}
		
		System.out.println("Removed tree: " + tree.toString());
		
		System.out.println("Hit " + (20 - tree.size()) + " value"
				+ (tree.size() == 19 ? "" : "s") + "!");
		
		// Values of the previous tree in the middle 51.
		System.out.println("Middle removed tree: " + tree.subMap(25, 75).toString());
		
		
	}
}
