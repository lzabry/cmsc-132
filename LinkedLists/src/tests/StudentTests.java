package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

public class StudentTests {

	// test1: getTest method
	@Test
	public void test1() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		int answer1 = basicList.getSize();
		String answer = Integer.toString(answer1);

		assertTrue(TestsSupport.isCorrect("test1.txt", answer));
	}

	// test2: iterator method
	@Test
	public void test2() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToEnd("2").addToEnd("3");
		Iterator<String> it = basicList.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}

		assertTrue(TestsSupport.isCorrect("test2.txt", answer));

	}

	// test3: addToend method
	@Test
	public void test3() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToEnd("2").addToEnd("3");
		Iterator<String> it = basicList.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}

		assertTrue(TestsSupport.isCorrect("test3.txt", answer));

	}

	// test4: addTofront method
	@Test
	public void test4() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToFront("2").addToEnd("3");
		Iterator<String> it = basicList.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}
		assertTrue(TestsSupport.isCorrect("test4.txt", answer));

	}

	// test5: getFirst method
	@Test
	public void test5() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToFront("2").addToEnd("3");
		answer = basicList.getFirst();
		assertTrue(TestsSupport.isCorrect("test5.txt", answer));

	}

	// test51: getFirst method test null case
	@Test
	public void test51() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		answer = basicList.getFirst();
		assertEquals(null, answer);

	}

	// test6: getLast method
	@Test
	public void test6() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToFront("2").addToEnd("3");
		answer = basicList.getLast();
		assertTrue(TestsSupport.isCorrect("test6.txt", answer));

	}

	// test62: getLast method test null
	@Test
	public void test61() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		answer = basicList.getLast();
		assertEquals(null, answer);

	}

	// test7: retrieveFirst method
	@Test
	public void test7() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToEnd("4");
		answer = basicList.retrieveFirstElement();
		assertTrue(TestsSupport.isCorrect("test7.txt", answer));

	}

	// test71: retrieveFirst method
	@Test
	public void test71() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1");
		answer = basicList.retrieveFirstElement();
		assertTrue(TestsSupport.isCorrect("test7.txt", answer));

	}

	// test72: retrieveFirst method
	@Test
	public void test72() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		answer = basicList.retrieveFirstElement();
		assertEquals(answer, null);

	}

	// test8: retrieveLastElement method
	@Test
	public void test8() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1");
		answer = basicList.retrieveLastElement();
		assertTrue(TestsSupport.isCorrect("test8.txt", answer));

	}

	// test81: retrieveLastElement method
	@Test
	public void test81() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToEnd("2").addToEnd("1");
		answer = basicList.retrieveLastElement();
		System.out.print(answer);
		assertTrue(TestsSupport.isCorrect("test8.txt", answer));

	}

	// test82: retrieveLastElement method
	@Test
	public void test82() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		answer = basicList.retrieveLastElement();
		assertEquals(answer, null);

	}

	// Test9: remove method
	@Test
	public void test9() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToEnd("2").addToEnd("3").addToEnd("2");
		basicList.remove("2", String.CASE_INSENSITIVE_ORDER);
		Iterator<String> it = basicList.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}
		assertTrue(TestsSupport.isCorrect("test9.txt", answer));

	}

	// Test9: remove method
	@Test
	public void test91() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("2").addToEnd("2");
		basicList.remove("2", String.CASE_INSENSITIVE_ORDER);
		Iterator<String> it = basicList.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}
		assertEquals(answer, "");

	}

	// Test10: getReverseArrayList method
	@Test
	public void test10() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToEnd("2").addToEnd("3").addToEnd("2");
		ArrayList<String> list1 = basicList.getReverseArrayList();
		for (String a : list1) {
			answer += a;
		}
		assertTrue(TestsSupport.isCorrect("test10.txt", answer));

	}

	// Test11: getReverseList method
	@Test
	public void test11() {
		String answer = "";
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("1").addToEnd("2").addToEnd("3").addToEnd("2");
		BasicLinkedList<String> basicList2 = basicList.getReverseList();
		Iterator<String> it = basicList2.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}
		assertTrue(TestsSupport.isCorrect("test11.txt", answer));

	}

	// Test12: add method
	@Test
	public void test12() {
		String answer = "";
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		sortedList.add("Yellow").add("Green").add("Zion").add("Vr").add("qq");
		Iterator<String> it = sortedList.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}

		assertTrue(TestsSupport.isCorrect("test12.txt", answer));

	}

	// Test13: remove method
	@Test
	public void test13() {
		String answer = "";
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);

		sortedList.add("Yellow").add("Red").add("Green").add("Black").add("Zebra");
		sortedList.remove("Green", String.CASE_INSENSITIVE_ORDER).remove("Black", String.CASE_INSENSITIVE_ORDER);

		Iterator<String> it = sortedList.iterator();
		while (it.hasNext()) {
			answer += it.next();
		}
		assertTrue(TestsSupport.isCorrect("test13.txt", answer));

	}

	// Test14: addToEnd
	@Test
	public void test14() {
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);

		sortedList.add("Yellow").add("Red").add("Green").add("Black").add("Zebra");

		try {
			sortedList.addToFront("1");
			System.out.print("Wrong");
		} catch (UnsupportedOperationException e) {
			assertEquals("Invalid operation for sorted list.", e.getMessage());
		}

	}

	// Test15: addToEnd
	@Test
	public void test15() {
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);

		sortedList.add("Yellow").add("Red").add("Green").add("Black").add("Zebra");
		try {
			sortedList.addToEnd("1");
			System.out.print("Something is Wrong");
		} catch (UnsupportedOperationException e) {
			assertEquals("Invalid operation for sorted list.", e.getMessage());
		}

	}

}
