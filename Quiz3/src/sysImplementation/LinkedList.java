package sysImplementation;

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

	// You can decide what code goes in replaceLess, but
	// must not do any recursive work and no looping allowed.
	// At some point replaceLess should make a call to replaceLessAux

	public void replaceLess(T value) {
		if (head == null) {
			return;
		} else {
			replaceLessAux2(this.head, head.data, value);
		}
	}

	// can have ONE private method called replaceLessAux
	// You can decide the type of the return value,
	// and the types of the parameter(s) but no more than 3 parameters maximum
	// must be recursive without any looping construct: no while, do while, for,or
	// enhanced for loop
	// only method it can call is itself and .compareTo of type T

	private T replaceLessAux(Node curr, T value, T largest) {
		if (value == null) {
			if (curr.data.compareTo(largest) > 0) {
				largest = curr.data;
			}
			if (curr.next != null) {
				return replaceLessAux(curr.next, null, largest);
			}
		} else {
			if (largest == null) {
				largest = head.data;
				largest = replaceLessAux(curr, null, largest);
			}
			if (curr.data.compareTo(value) < 0) {
				curr.data = largest;
			}
			if (curr.next != null) {
				replaceLessAux(curr.next, value, largest);
			}
		}
		return largest;
	}

	private T replaceLessAux2(Node curr, T maximum, T value) {
		if (curr == null) {
			return maximum;
		}
		maximum = (curr.data.compareTo(maximum) > 0 ? curr.data : maximum);
		T toreplace=replaceLessAux2(curr.next, maximum,value);
		if (curr.data.compareTo(value)<0) {
			curr.data=toreplace;
		}
		return toreplace;

	}
}
