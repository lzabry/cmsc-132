package sysImplementation;

import java.util.TreeMap;

public class LinkedList<T extends Comparable<T>> {

	private class Node {
		private T data;
		private Node next;

		private Node(T data) {
			this.data = data;
			next = null;
		}
	}

	private Node head;

	public LinkedList() {
		head = null;
	}

	public LinkedList<T> add(T data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;

		return this;
	}

	public String toString() {
		String result = "\" ";
		Node curr = head;

		while (curr != null) {
			result += curr.data + " ";

			curr = curr.next;
		}

		return result + "\"";
	}

	// -----DO NOT MODIFY CODE ABOVE THIS LINE---//

	// You can decide what code goes in compress, but it
	// must not do any recursive work and no looping allowed.
	// At some point compress should make a call to compressAux

	public TreeMap<T, Integer> compress() {
		return compressAux(head, new TreeMap<T, Integer>());

	}

	// can have ONE private method called compressAux
	// You can decide the type of the return value,
	// and the types of the parameter(s) but no more than 2 parameters maximum
	// must be recursive without any looping construct: no while, do while, for,or
	// enhanced for loop


		
	
	private TreeMap<T, Integer> compressAux(Node headAux,TreeMap<T, Integer>map){
		  int val=1;
		  if (headAux != null) {
		   if(!map.containsKey(headAux.data)) {
		    
		    if(headAux.data==headAux.next.data) { 
		     headAux.next=headAux.next.next;
		     val++;
		    }
		    map.put(headAux.data, val);
		    
		    compressAux(headAux.next,map);
		   }else {
		    val=map.get(headAux.data).intValue()+1;
		    if(headAux.data==headAux.next.data) { 
		     headAux.next=headAux.next.next;
		     val++;
		    }
		    map.replace(headAux.data, val);
		    compressAux(headAux.next,map);
		   }
		  }
		  return map;
		 }

	// -----------------------------------------------------------------------------------//

	// You can decide what code goes in mapList, but it
	// must not do any recursive work and no looping allowed.
	// At some point mapList should make a call to mapListAux

	public LinkedList<T> mapList(TreeMap<T, Integer> map) {
		return mapListAux(map, new LinkedList<T>());

	}

	// can have ONE private method called mapListAux
	// You can decide the type of the return value,
	// and the types of the parameter(s) but no more than 2 parameters maximum
	// must be recursive without any looping construct: no while, do while, for,or
	// enhanced for loop

	private LinkedList<T> mapListAux(TreeMap<T, Integer> map, LinkedList<T> list) {

		if (map.isEmpty()) {
			return list;
		} else {
			T key = map.firstKey();
			int value = map.get(key);
			if (value <= 0) {
				map.remove(key);
				mapListAux(map, list);
			} else {
				int count = map.get(map.firstKey()) - 1;

				map.put(key, count);

				mapListAux(map, list);
				list.add(key);
			}
			return list;
		}

	}

}
