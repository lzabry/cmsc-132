package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 * 
 */
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	private K key;
	private V value;
	private Tree<K, V> left;
	private Tree<K, V> right;

	/**
	 * Only constructor we need.
	 * 
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */
	public NonEmptyTree(K key, V value, Tree<K, V> left, Tree<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;

	}

	public V search(K key) {
		int result = key.compareTo(this.key);

		if (result == 0) {
			return this.value;
		} else if (result > 0) {
			return this.right.search(key);
		} else {
			return this.left.search(key);
		}
	}

	public NonEmptyTree<K, V> insert(K key, V value) {
		int result = key.compareTo(this.key);

		if (result == 0) {
			this.value = value;
			return this;
		} else if (result > 0) {
			this.right = this.right.insert(key, value);
			return this;
		} else {
			this.left = this.left.insert(key, value);
			return this;
		}

	}

	public Tree<K, V> delete(K key) {
		int result = key.compareTo(this.key);
		if (result > 0) {
			this.right = this.right.delete(key);
			return this;
		} else if (result < 0) {
			this.left = this.left.delete(key);
			return this;
		} else {
			try {
				this.key = right.min();
				this.value = this.right.search(this.key);
				this.right = this.right.delete(this.key);
				return this;
			} catch (TreeIsEmptyException e) {
				try {
					this.key = left.max();
					this.value = this.left.search(this.key);
					this.left = this.left.delete(this.key);
					return this;
				} catch (TreeIsEmptyException e2) {
					return EmptyTree.getInstance();
				}
			}
		}

	}

	public K max() {
		try {
			return this.right.max();
		} catch (TreeIsEmptyException e) {
			return key;
		}
	}

	public K min() {
		try {
			return this.left.min();
		} catch (TreeIsEmptyException e) {
			return key;
		}
	}

	public int size() {
		return 1 + left.size() + right.size();
	}

	public void addKeysToCollection(Collection<K> c) {
		c.add(key);
		this.left.addKeysToCollection(c);
		this.right.addKeysToCollection(c);

	}

	public Tree<K, V> subTree(K fromKey, K toKey) {
		int result1 = fromKey.compareTo(this.key);
		int result2 = toKey.compareTo(this.key);
		if (result1 > 0) {
			return this.right.subTree(fromKey, toKey);
		} else if (result2 < 0) {
			return this.left.subTree(fromKey, toKey);
		} else {
			return new NonEmptyTree<K, V>(this.key, this.value, this.left.subTree(fromKey, toKey),
					this.right.subTree(fromKey, toKey));
		}

	}

	public int height() {
		if (this.left.height() < this.right.height()) {
			return 1 + this.right.height();
		} else {
			return 1 + this.left.height();
		}
	}

	public void inorderTraversal(TraversalTask<K, V> p) {
		this.left.inorderTraversal(p);
		p.performTask(key, value);
		this.right.inorderTraversal(p);
	}

	public void rightRootLeftTraversal(TraversalTask<K, V> p) {
		this.right.rightRootLeftTraversal(p);
		p.performTask(key, value);
		this.left.rightRootLeftTraversal(p);
	}
}