package sysImplementation;

import java.util.ArrayList;
import java.util.Arrays;

public class SampleDriver2 {

	public static void main(String[] args) {

		String answer = "";

		answer += "===================MapOfCodes Output=======================\n";

		String[] data = { "ba", "fg", "cv", "fg", "mo", "sw", "do", "so", "mo", "be", "he", "fg", "se", "rt", "pk",
				"et" };

		MapOfCodes.makeMap(data);

		answer += MapOfCodes.getValue("fg") + "\n";
		answer += MapOfCodes.getValue("do") + "\n";
		answer += MapOfCodes.getValue("rb") + "\n";

		MapOfCodes.put("fg");
		MapOfCodes.put("do");
		MapOfCodes.put("rb");

		answer += MapOfCodes.getValue("fg") + "\n";
		answer += MapOfCodes.getValue("do") + "\n";
		answer += MapOfCodes.getValue("rb") + "\n";

		MapOfCodes.resetCount("fg");
		answer += MapOfCodes.getValue("fg") + "\n";

		answer += MapOfCodes.sort(true) + "\n";
		answer += MapOfCodes.sort(false) + "\n";

		answer += "===================BST Output=======================\n";

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		tree.add(75);
		tree.add(50);
		tree.add(20);
		tree.add(25);
		tree.add(55);
		tree.add(90);
		tree.add(92);

		int[] countArray = new int[3]; // first element for leaves, second for 1 child, third for 2 children
		ArrayList<Integer> list = tree.treeProcessor(countArray);
		answer += Arrays.toString(countArray) + "\n";
		answer += list + "\n";

		answer += tree.removeSubTree(50) + "\n";
		answer += tree + "\n"; // what is left in the tree after remove

		System.out.println(answer);

	}

}
