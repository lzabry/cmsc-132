
public class Driver {

	public static void main(String[] args) {		
		//Testing Min Depth
		BinarySearchTree tree = new BinarySearchTree();
		
		//Try with 20 commented out
		tree.add(40);
		tree.add(20);
		tree.add(60);
		tree.add(50);
		tree.add(70);

				
		System.out.println("Tree: " + tree);
		System.out.println("Tree Min Depth: " + tree.minDepth());
		
		
		//Will no longer be a binary search tree
		//Testing Merge Tree
		BinarySearchTree t1 = new BinarySearchTree();
		BinarySearchTree t2 = new BinarySearchTree();
		
		t1.add(5);
		t1.add(3);
		t1.add(6);
		t1.add(2);
		
		t2.add(3);
		t2.add(1);
		t2.add(2);
		t2.add(4);
		t2.add(6);
		
		BinarySearchTree.mergeTrees(t1, t2);
		System.out.println("Tree: " + t1);
	}

}
