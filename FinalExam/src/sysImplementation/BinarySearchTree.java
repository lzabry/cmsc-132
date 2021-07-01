package sysImplementation;

import java.util.ArrayList;

public class BinarySearchTree<K extends Comparable<K>> {

	private class Node {
		private K key;
		private Node left, right;

		private Node(K key) {
			this.key = key;

		}
	}

	private Node root;

	public boolean add(K key) {
		if (root == null) {
			root = new Node(key);
			return true;
		} else {
			return addAux(key, root);
		}
	}

	private boolean addAux(K key, Node rootAux) {
		int comparison = key.compareTo(rootAux.key);

		if (comparison == 0) {
			return false;
		} else if (comparison < 0) {
			if (rootAux.left == null) {
				rootAux.left = new Node(key);
				return true;
			} else {
				return addAux(key, rootAux.left);
			}
		} else {
			if (rootAux.right == null) {
				rootAux.right = new Node(key);
				return true;
			} else {
				return addAux(key, rootAux.right);
			}
		}
	}

	public String toString() {
		return toStringAux(root);
	}

	private String toStringAux(Node rootAux) {
		return rootAux == null ? "" : toStringAux(rootAux.left) + "{" + rootAux.key + "}" + toStringAux(rootAux.right);
	}

	// -----DO NOT MODIFY CODE ABOVE THIS LINE---//

	// You can decide what code goes in treeProcessor, but it
	// must not do any recursive work and no looping allowed.
	// At some point, treeProcessor should make a call to treeProcessorsAux

	public ArrayList<K> treeProcessor(int[] countArray) {
		ArrayList<K> list = new ArrayList<K>();
		if (this.root == null) {
			return list;
		}
		treeProcessorAux(countArray, root, list);
		return list;

	}

	private ArrayList<K> treeProcessorAux(int[] countArray, Node current, ArrayList<K> list) {
		if (current.left != null && current.right != null) {
			countArray[2]++;
		} else if (current.left == null && current.right == null) {
			countArray[0]++;
		} else {
			countArray[1]++;
		}
		if (current.right != null) {
			treeProcessorAux(countArray, current.right, list);
			list.add(current.key);
			if (current.left != null) {
				treeProcessorAux(countArray, current.left, list);
			}
		} else if (current.left != null) {
			list.add(current.key);
			treeProcessorAux(countArray, current.left, list);
		} else {
			list.add(current.key);
		}
		return list;
	}

	// can have ONE private method called treeProcessorAux
	// You can decide the type of the return value,
	// and the types of the parameter(s) but no more than 3 parameters maximum
	// must be recursive without any looping construct: no while, do while, for,or
	// enhanced for loop

	// -----------------------------------------------------------------------------------//

	// You can decide what code goes in removeSubTree , but it
	// must not do any recursive work and no looping allowed.
	// removeSubTree can call TWO helper methods that do recursive work

	public ArrayList<K> removeSubTree(K key) {
		Node node;
		ArrayList<K> removed = new ArrayList<K>();
		if (this.root == null) {
			return removed;
		}
		Node nodeParent = this.get(key, root);
		if (nodeParent == null) {
			return removed;
		}
		if (nodeParent.left.key.compareTo(key) == 0) {
			node = nodeParent.left;
		} else {
			node = nodeParent.right;
		}
		this.removeAux(removed, node);
		if (nodeParent.left.key.compareTo(key) == 0) {
			nodeParent.left = null;
		} else {
			nodeParent.right = null;
		}
		return removed;

	}

	private ArrayList<K> removeAux(ArrayList<K> removed, Node node) {
		if (node.left != null) {
			removeAux(removed, node.left);
			removed.add(node.key);
			if (node.right != null) {
				removeAux(removed, node.right);
			}
		} else if (node.right != null) {
			removed.add(node.key);
			removeAux(removed, node.right);
		} else {
			removed.add(node.key);
		}
		return removed;
	}

	private Node get(K key, Node rootAux) {
		if (rootAux == null) {
			return null;
		} else {
			if (rootAux.left != null && rootAux.right != null) {
				int comparisonLeft = key.compareTo(rootAux.left.key);
				int comparisonRight = key.compareTo(rootAux.right.key);

				if (comparisonLeft == 0 || comparisonRight == 0) {
					return rootAux;
				} else if (comparisonLeft < 0) {
					return get(key, rootAux.left);
				} else {
					return get(key, rootAux.right);
				}
			} else if (rootAux.left == null && rootAux.right != null) {
				int comparisonRight = key.compareTo(rootAux.right.key);

				if (comparisonRight == 0) {
					return rootAux;
				} else {
					return get(key, rootAux.right);
				}
			} else if (rootAux.left != null && rootAux.right == null) {
				int comparisonLeft = key.compareTo(rootAux.left.key);

				if (comparisonLeft == 0) {
					return rootAux;
				} else {
					return get(key, rootAux.left);
				}
			} else {
				return null;
			}
		}
	}

	// can have TWO private methods to help you implement removeSubTree. Name them
	// whatever you want.
	// You can decide the type of the return value of each,
	// and the types of the parameter(s) but no more than 2 parameters maximum per
	// method
	// both must be recursive without any looping construct: no while, do while,
	// for,or enhanced for loop
	// The 2 private methods can not call each other, but both can be called as many
	// times needed from removeSubTree

}