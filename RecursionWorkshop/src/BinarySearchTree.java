public class BinarySearchTree {
	
	private class Node {
		private Integer data;
		private Node left, right;

		public Node(Integer data) {
			this.data = data;
		}
	}
	
	private Node root;
	
	public BinarySearchTree () {
		root = null;
	}
	
	public boolean add(Integer data) {
		if (root == null) {
			root = new Node(data);
			return true;
		} else {
			return addAux(data, root);
		}
	}
	
	private boolean addAux(Integer data, Node rootAux) {
		int comparison = data.compareTo(rootAux.data);

		if (comparison == 0) {
			rootAux.data = data;
			return false;
		} else if (comparison < 0) {
			if (rootAux.left == null) {
				rootAux.left = new Node(data);
				return true;
			} else {
				return addAux(data, rootAux.left);
			}
		} else {
			if (rootAux.right == null) {
				rootAux.right = new Node(data);
				return true;
			} else {
				return addAux(data, rootAux.right);
			}
		}
	}
	
	@Override
	public String toString() {
	    return toString(new StringBuilder(), this.root).toString();
	}
	private StringBuilder toString(StringBuilder string, Node node) {
	    string.append('{');
	    if (node != null) {
	        string.append(node.data);
	        toString(string.append(", "), node.left);
	        toString(string.append(", "), node.right);
	    }
	    return string.append('}');
	}
	
	/* DO NOT MODIFY ANYTHING ABOVE THIS LINE */
	
	/* Question 1: Find the minimum depth of a binary tree using recursion and
	 * 			   only one parameter. The minimum depth is the number of nodes
	 * 			   along the shortest path from the root node down to the nearest 
	 * 			   leaf node. You may have one helper method in which you can 
	 * 			   decide the return type. */
	public int minDepth () {
		return minDepthAux(this.root);
	}
	
	private int minDepthAux (Node curr) {
        if(curr == null) {
        	return 0;
        }
        int leftSubtree = minDepthAux(curr.left) + 1;
        int rightSubtree = minDepthAux(curr.right) + 1;
        //There is nothing on the left
        if (leftSubtree == 1) {
        	return rightSubtree;
        }
        //There is nothing on the right
        else if (rightSubtree == 1) {
        	return leftSubtree;
        }
        //If both exist just take min
        return Math.min(leftSubtree, rightSubtree);
	}
	
	/* Question 2: Given two binary trees imagine that when you put one of them
	 *             to cover the other, some nodes of the two trees are 
	 *             overlapped while the others are not. You need to merge them 
	 *             into a new binary tree. The merge rule is that if two nodes 
	 *             overlap, then sum node values up as the new value of the merged 
	 *             node. Otherwise, the NOT null node will be used as the node of 
	 *             the new tree. Create this new binary tree using recursion and 
	 *             only 2 parameters. You may have one helper method in which you can 
	 * 			   decide the return type. (Hint: in place) */
	
	//Will no longer be a binary search tree
	public static void mergeTrees(BinarySearchTree t1, BinarySearchTree t2) {
        mergeTreesAux(t1.root, t2.root);
    }
    
    private static Node mergeTreesAux(Node n1, Node n2) {
    	//if there is no overlap (t1)
        if (n1 == null) {
            return n2;
        }
        //if there is no overlap (t2)
        if (n2 == null) {
            return n1;
        }
        //when overlap add together
        n1.data += n2.data;
        n1.left = mergeTreesAux(n1.left, n2.left);
        n1.right = mergeTreesAux(n1.right, n2.right);
        return n1;
    }

}
