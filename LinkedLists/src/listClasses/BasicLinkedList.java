package listClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T> {
	protected class Node {
		protected T data;
		protected Node next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	protected Node head;
	protected Node tail;
	protected int size;

	public BasicLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int getSize() {
		return this.size;
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node current = head;

			public boolean hasNext() {
				return current != null;
			}

			public T next() {
				T result = current.data;
				current = current.next;
				return result;
			}

			public void remove() {
				throw new UnsupportedOperationException("iterator remove not implemented");
			}

		};
	}

	public BasicLinkedList<T> addToEnd(T data) {
		Node newnode = new Node(data);
		if (tail == null) {
			head = newnode;
			tail = newnode;
		} else {
			tail.next = newnode;
			tail = newnode;
		}
		size++;
		return this;
	}

	public BasicLinkedList<T> addToFront(T data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			tail = newnode;
		} else {
			newnode.next = head;
			head = newnode;
		}
		size++;
		return this;

	}

	public T getFirst() {
		if (head == null) {
			return null;
		} else {
			return head.data;
		}
	}

	public T getLast() {
		if (tail == null) {
			return null;
		} else {
			return tail.data;
		}
	}

	public T retrieveFirstElement() {
		if (head == null) {
			return null;
		} else {
			T clone = head.data;
			head = head.next;
			size--;
			if (size == 0) {
				tail = null;
			}
			return clone;
		}
	}

	public T retrieveLastElement() {
		if (tail == null) {
			return null;
		} else if (size == 1) {
			size--;
			T clone1 = head.data;
			head = null;
			tail = null;
			return clone1;
		} else {
			T clone = tail.data;
			Node curr = head;
			while (curr.next != tail) {
				curr = curr.next;
			}
			tail = curr;
			tail.next = null;
			size--;
			return clone;
		}

	}

	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node prev = null, curr = head;
		while (curr != null) {
			if (comparator.compare(targetData, curr.data) == 0) {
				if (curr == head) {
					curr = curr.next;
					head = curr;
				} else {
					prev.next = curr.next;
					curr = curr.next;
				}
				size--;
			} else {
				prev = curr;
				curr = curr.next;

			}
		}
		if (size == 0) {
			head = null;
			tail = null;
		}
		return this;
	}

	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> list1 = new ArrayList<T>();
		return getReverseArrayListAuxiliary(list1, head);

	}

	private ArrayList<T> getReverseArrayListAuxiliary(ArrayList<T> list1, Node curr) {
		if (curr == null) {
			return list1;
		} else {
			list1.add(0, curr.data);
			return getReverseArrayListAuxiliary(list1, curr.next);
		}
	}

	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> list2 = new BasicLinkedList<T>();
		return getReverseListAuxiliary(list2, head);
	}

	private BasicLinkedList<T> getReverseListAuxiliary(BasicLinkedList<T> list2, Node curr) {
		if (curr == tail) {
			list2.addToFront(curr.data);
			return list2;
		} else {
			list2.addToFront(curr.data);
			return getReverseListAuxiliary(list2, curr.next);
		}

	}

}
