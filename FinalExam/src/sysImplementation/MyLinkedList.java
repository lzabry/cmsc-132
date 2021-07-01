package sysImplementation;

public class MyLinkedList<T extends Comparable<T>> {

	private class Node {
		private T data;
		private Node prev;
		private Node next;

		private Node(T data) {
			this.data = data;
			prev = next = null;
		}
	}

	private Node head; // points to first node
	private Node tail; // points to last node
	private int size; // number of elements in the list

	public MyLinkedList() {
		head = tail = null;
		size = 0;
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

	public String toStringReverse() {
		String result = "\" ";
		Node curr = tail;

		while (curr != null) {
			result += curr.data + " ";

			curr = curr.prev;
		}

		return result + "\"";
	}

	public int getSize() {
		return size;
	}

	public void deleteAfter(T data) {
		deleteAfterAux(data, head); // you need to code deleteAfterAux
	}

	public boolean newHead(T data) {
		return newHeadAux(data, head); // you need to code newHeadAux
	}

	// -----DO NOT MODIFY CODE ABOVE THIS LINE---//

	public MyLinkedList<T> add(T data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			tail = newnode;
		} else {
			newnode.prev = null;
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
		size++;
		return this;
	}

	private void deleteAfterAux(T data, Node headAux) {
		if (headAux == tail) {
			return;
		} else {
			if (headAux.data.compareTo(data) == 0 && headAux.next == tail) {
				tail = headAux;
				headAux.next = null;
				size--;
				return;
			} else {
				if (headAux.data.compareTo(data) == 0) {
					headAux.next = headAux.next.next;
					headAux.next.prev = headAux;
					size--;
				}
			}
			deleteAfterAux(data, headAux.next);
		}

	}

	private boolean newHeadAux(T data, Node headAux) {
		if (headAux == null) {
			return false;
		}
		if (headAux.data.compareTo(data) == 0 && headAux == head) {
			return false;
		}
		if (headAux.data.compareTo(data) == 0) {
			tail.next = head;
			head.prev = tail;
			tail = headAux.prev;
			tail.next = null;
			head = headAux;
			headAux.prev = null;
			return true;
		}
		return newHeadAux(data, headAux.next);

	}

}
