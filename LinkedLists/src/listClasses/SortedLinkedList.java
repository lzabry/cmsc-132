package listClasses;

import java.util.Comparator;

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;

	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	public SortedLinkedList<T> add(T element) {
		Node newnode = new Node(element);
		size++;
		if (head == null) {
			head = newnode;
			tail = newnode;
			return this;
		} else {
			Node curr = head;
			while (curr != null) {
				if (comparator.compare(element, curr.data) > 0) {
					curr = curr.next;
					continue;
				} else {
					this.insertElementBefore(curr.data, element);
					if (curr == head) {
						head = newnode;
					}
					return this;
				}
			}
			tail.next = newnode;
			tail = newnode;
			return this;
		}

	}

	// this is from the class code
	private void insertElementBefore(T targetElement, T toInsert) {
		Node prev = null, curr = head;

		while (curr != null) {
			if (comparator.compare(curr.data, targetElement) == 0) {
				Node newNode = new Node(toInsert);
				if (curr == head) {
					newNode.next = head;
					head = newNode;
				} else {
					prev.next = newNode;
					newNode.next = curr;
				}
				return;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public SortedLinkedList<T> remove(T targetData) {
		return (SortedLinkedList<T>) super.remove(targetData, comparator);
	}

	public BasicLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

	public BasicLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}

}