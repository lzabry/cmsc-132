package sortedList;
public class EmptyList<K extends Comparable<K>> implements List<K> {
	
	/**
	 * This static field references the one and only instance of this class.
	 * We won't declare generic types for this one, so the same singleton
	 * can be used for any kind of EmptyList.
	 */
	private static EmptyList SINGLETON = new EmptyList();
	
	public static EmptyList getInstance() { return SINGLETON; }
	
	/* private constructor to define the singleton */
	private EmptyList() {
		/* Nothing to do */
	}
	
	public boolean contains(K data) {
		return false;
	}

	public NonEmptyList<K> insert(K data) {
		return new NonEmptyList<K>(data, this);
	}

	public List<K> remove(K data) {
		return this;
	}

	public K max() throws ListIsEmptyException {
		throw new ListIsEmptyException();
	}
	
	public K min() throws ListIsEmptyException {
		throw new ListIsEmptyException();
	}
	
	public String toString() {
		return "";
	}
}