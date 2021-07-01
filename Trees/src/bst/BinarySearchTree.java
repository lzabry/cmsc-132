package bst;

public class BinarySearchTree {
	private int data;
	private BinarySearchTree left, right;
	
	public BinarySearchTree(int data) {
		this.data = data;
	}
	
	public void put(int data) {
		if(this.data > data) {
			if(left == null) {
				left = new BinarySearchTree(data);
			} else {
				left.put(data);
			}
		} else {
			if(right == null) {
				right = new BinarySearchTree(data);
			} else {
				right.put(data);
			}
		}
	}
	
	public int get() {
		return data;
	}
	
	public int getMax() {
		if(right == null) {
			return data;
		}
		return right.getMax();
	}
	
	public int getMin() {
		if(left == null) {
			return data;
		}
		return left.getMin();
	}
	
	public BinarySearchTree subMap(int lower, int upper) {
		if(data > upper) {
			if(left == null) {
				return null;
			}
			return left.subMap(lower, upper);
		}
		if(data < lower) {
			if(right == null) {
				return null;
			}
			return right.subMap(lower,  upper);
		}
		BinarySearchTree subTree = new BinarySearchTree(data);
		if(left != null) {
			subTree.left = left.subMap(lower, upper);
		}
		if(right != null) {
			subTree.right = right.subMap(lower, upper);
		}
		return subTree;
	}
	
	public int height() {
		if(left != null) {
			if(right != null && right.height() > left.height()) {
				return 1 + right.height();
			}
			return 1 + left.height();
		}
		if(right != null) {
			return 1 + right.height();
		}
		return 1;
	}
	
	// Due to the nature of "size 0 tree is null", in order to properly remove
	// we must do "tree = tree.remove(data);".
	
	public BinarySearchTree remove(int data) {
		if(data > this.data) {
			if(right != null) {
				right = right.remove(data);
			}
		} else if (data < this.data) {
			if(left != null) {
				left = left.remove(data);
			}
		} else {
			if(left == null) {
				if(right == null) {
					return null;
				}
				return right;
			}
			if(right == null) {
				return left;
			}
			this.data = left.getMax();
			left = left.remove(this.data);
		}
		return this;
	}
	
	public int size() {
		int size = 1;
		if(left != null) {
			size += left.size();
		}
		if(right != null) {
			size += right.size();
		}
		return size;
	}
	
	@Override
	public String toString() {
		String ans = "";
		if(left != null) {
			ans += left.toString() + " ";
		}
		ans += data;
		if(right != null) {
			ans += " " + right.toString();
		}
		return ans;
	}
}
