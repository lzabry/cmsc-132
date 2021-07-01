package sysImplementation;

import java.util.Arrays;

public class myHashTable {

	private String[] hashtable;
	private int size;
	private int capacity;

	public myHashTable(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("capacity cannot be negative");
		} else {
			this.size = 0;
			this.hashtable = new String[capacity];
			this.capacity = capacity;
		}

	}

	public int getSize() {
		return this.size;
	}

	public int getCapacity() {
		return this.capacity;

	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	public String showMeTable() {
		return Arrays.toString(hashtable);
	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	int hashBucket(String x) {
		int h = x.hashCode();
		h += ~(h << 9);
		h ^= (h >>> 14);
		h += (h << 4);
		h ^= (h >>> 10);
		return Math.abs(h % capacity);
	}

	public String search(String s) {
		String[] array = new String[2];
		array[0] = "0";
		array[1] = s;
		int result = this.loop(array);
		if(this.hashtable[result]!=null&&this.hashtable[result].equals(s)) {
			return s + " at index: " + result;
		}
		else {
			return "NotFound";
		}
	}

	public boolean insert(String s) {
		String[] array = new String[2];
		array[0] = "1";
		array[1] = s;
		int result = this.loop(array);
		if(this.hashtable[result] == null|| this.hashtable[result].equals("Removed")) {
			this.hashtable[result] = s;
			size++;
			return true;
		}
		else {
			return false;
		}
	}

	public boolean remove(String s) {
		String[] array = new String[2];
		array[0] = "0";
		array[1] = s;
		int result = this.loop(array);
		if(this.hashtable[result]!=null&&this.hashtable[result].equals(s)) {
			this.hashtable[result] = "Removed";
			size--;
			return true;
		}
		else {
			return false;
		}
	}

	public double loadFactor() {
		return (double) size / (double) capacity;

	}

	// You are allowed 1 private non-recursive helper method with any type of return
	// value and ONE parameter
	// You can have only ONE looping construct (i.e. while, do while, for, for each)
	// in the ENTIRE class
    
private int loop(String[] array) {
		String s = array[1];
		int trigger = Integer.parseInt(array[0]);
		int index = this.hashBucket(s);
		int i = index+1;
		if(index > this.capacity) {
			index -= this.capacity;
		}
		if(i>=this.capacity) {
			i -= this.capacity;
		}
		if(trigger == 0) {
			if(this.hashtable[index]==null || this.hashtable[index].equals(s)) {
				return index;
			}
			while(this.hashtable[i] != null &&!this.hashtable[i].equals(s) && i != index) {
				i++;
				if(i>=this.capacity) {
					i -= this.capacity;
				}
			}
			return i;
		}
		else {
			if(this.hashtable[index]==null || this.hashtable[index].equals(s)||this.hashtable[index].equals("Removed")) {
				return index;
			}
			while(this.hashtable[i] != null &&!this.hashtable[i].equals(s) && i != index&&!this.hashtable[i].equals("Removed")) {
				i++;
				if(i>=this.capacity) {
					i -= this.capacity;
				}
			}
			return i;
		}
		
		
	}


	

}
