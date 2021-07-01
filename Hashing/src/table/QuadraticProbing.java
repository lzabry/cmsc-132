package table;

import java.util.Arrays;

public class QuadraticProbing {
	
	private String[] hashtable;
	private int size;
	private int capacity;
	
	public QuadraticProbing(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive");
		}
		this.capacity = capacity;
		hashtable = new String[capacity];
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public String showMeTable() {
		return Arrays.toString(hashtable);
	}

	int hashBucket(String x) {
		int h = x.hashCode();
		h += ~(h << 9);
		h ^= (h >>> 14);
		h += (h << 4);
		h ^= (h >>> 10);
		return Math.abs(h % capacity);
	}

	
	//returns the string and index if in the hashtable
	//returns NotFound if not in there
	public String search (String s) {
		
		int index = searchIndex (s)[0];  //index if found or -1 if not
	
			if(index !=-1){
				s +=" at index: "+index;
				return s;
			}
			else 
				return "NotFound";
			
	}
	
	//let students write this , not required.  Allow 1 helper method
	private int[] searchIndex (String s)
	{
		int [] returnVal = {-1,-1};   //first element is index, second is index of first null or Removed
		boolean firstRemove =true;
		
		int index = hashBucket(s);
		int start = index;
		
					   // What is this condition?
		for (int i = 1; i == 1 || index != start;  i = (int) Math.pow(Math.sqrt(i) + 1, 2)) {
			if (hashtable[index]==null){
				if (firstRemove) {
					returnVal[1] = index;
				}
		    	return returnVal;
			} else if (hashtable[index].equals("Removed") && firstRemove) {
		    	returnVal[1] = index;  //index of first available removed ---don't return s might still be in table
		    	firstRemove = false; 
		    } else if(hashtable[index].equals(s)){
		    	returnVal[0] = index;
		    	return returnVal; 
			}
			
			index = (index + i) % capacity;
		}
		return returnVal; 
	}
		
	
	
	public boolean insert (String s) {
		if (size == capacity)  // no more room
			return false;
		
		
		int []index = searchIndex (s);  //gets index or -1
		
		if (index[0] !=-1)
			return false; // Already in there
	
		hashtable[index[1]] = s; //put s at first null or removed
		size++;
		return true;

	}

	public boolean remove (String s) {
		int index = searchIndex (s)[0];  //index if found or -1 if not
		
		if(index !=-1) {
			hashtable[index] = "Removed";
			size--;
			return true;
		}
		else 
			return false;
		
		
	}
	
	public double loadFactor() {
		return (double) size/capacity;
		
	}	
}



