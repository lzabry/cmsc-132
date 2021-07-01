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

	@Override
	public String toString() {
		String result = "\" ";
		Node curr = head;

		while (curr != null) {
			result += curr.data + " ";

			curr = curr.next;
		}

		return result + "\"";
	}

	/* DO NOT MODIFY ANYTHING ABOVE THIS LINE */

	/*
	 * Question 1: Inserting an item into a sorted LinkedList using recursion and
	 * only two parameter. You may have one helper method in which you can decide
	 * the return type.
	 */

	public void insertion(LinkedList<T> sortedList, Node insertThis) {
		if (sortedList != null) {
			
			insertHelper(sortedList.head, insertThis);
		} else {
			this.head = insertThis;
		}

	}

	public Node insertHelper(Node curr, Node insertThis) {
		if ((curr == null) || curr.data.compareTo(insertThis.data) > 0) {
			insertThis.next = curr;
			return insertThis;
		} else {
			curr.next = insertHelper(curr.next, insertThis);
			return curr;
		}
	}

	/*
	 * Question 2: Find and remove the largest element in an unsorted LinkedList
	 * using recursion and only one parameter. You may have one helper method in
	 * which you can decide the return type.
	 */

	public void removeLargest(LinkedList<T> unsortedList) {
		if (unsortedList.head != null) {
			if (unsortedList.head.next == null) {
				
				unsortedList.head = null; // For a list of size 1, remove the only element.
			} else {
				T largest = unsortedList.removeAux(unsortedList.head);
				// Must check if head is largest, if remove ALL largest elements
				if (unsortedList.head.data.equals(largest)) {
					unsortedList.head = unsortedList.head.next;
				}
			}
		}
	}


	public T removeAux(Node curr) {
		boolean swap;
		T currData = curr.data;
		T nextData = curr.next.data;

		if (curr.data.compareTo(curr.next.data) > 0) {
			swap = true;
			T temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
		} else {
			swap = false;
		}
		
		if (curr.next.next == null) {
			T largest = curr.next.data;
			curr.next = null; 
			return largest;
		}

		T largest = removeAux(curr.next);

		if (curr.next.data.equals(largest)) {
			curr.next = curr.next.next;
		}				

		if (currData.compareTo(largest) == 0) {
			return largest;
		} else if (swap) {
			System.out.println("swapping");
			curr.data = currData;
			curr.next.data = nextData;
		}

		return largest;
	}

	/*
	 * Question 3: Merge two sorted LinkedLists into a larger sorted LinkedList
	 * using recursion and only 2 parameters. You may have one helper method in
	 * which you can decide the return type.
	 */

	public LinkedList<T> mergeLists(LinkedList<T> sortedListA, LinkedList<T> sortedListB) {
		LinkedList<T> merged = new LinkedList<T>();
		merged.head = mergeAux(sortedListA.head, sortedListB.head);
		return merged;
	}

	public Node mergeAux(Node A, Node B) {
		if (A == null)
			return B;
		if (B == null)
			return A;

		if (A.data.compareTo(B.data) < 0) {
			A.next = mergeAux(A.next, B);
			return A;
		} else {
			B.next = mergeAux(A, B.next);
			return B;
		}
	}
}
