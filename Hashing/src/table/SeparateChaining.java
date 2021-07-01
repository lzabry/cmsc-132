package table;

import java.util.Arrays;

public class SeparateChaining<E> {
	private Node[] table;
	private int size;
	private int capacity;
	
	private class Node {
		private E data;
		private Node next;
		
		private Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		private Node(E data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data + (next == null ? "" : " " + next.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public SeparateChaining(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive");
		}
		// I got a nasty ClassCastException with the old approach, so here's this:
		table = Arrays.copyOf(new Object[capacity], capacity, Node[].class);
		this.capacity = capacity;
		size = 0;
	}
	
	private int hashBucket(E x) {
		int h = x.hashCode();
		h += ~(h << 9);
		h ^= (h >>> 14);
		h += (h << 4);
		h ^= (h >>> 10);
		return Math.abs(h % capacity);
	}
	
	public String showMeTable() {
		return Arrays.toString(table);
	}
	
	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public String search(E data) {
		// My way to do one loop - a little lame...
		if(remove(data)) {
			insert(data);
			return data + " found at index " + hashBucket(data);
		}
		return "NotFound";
	}
	
	public boolean insert(E data) {
		int index = hashBucket(data);
		
		Node temp = table[index];
		table[index] = new Node(data);
		table[index].next = temp;
		size++;
		return true;
	}
	
	public boolean remove(E data) {
		Node prev = null;
		Node curr = table[hashBucket(data)];
		
		while(curr != null) {
			if(curr.data.equals(data)) {
				if(prev == null) {
					table[hashBucket(data)] = table[hashBucket(data)].next;
				} else {
					prev.next = curr.next;
				}
				size--;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}
	
	public double loadFactor() {
		return (double) size / capacity;
	}
}
