package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import tree.PolymorphicBST;
import tree.PlaceKeysValuesInArrayLists;

public class StudentTests extends TestCase {

	@Test
	public void testget() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		assertEquals("Five", ptree.get(5));
	}

	@Test
	public void testput() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists();
		ptree.inorderTraversal(task);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]", task.getKeys().toString());
		PlaceKeysValuesInArrayLists<Integer, String> task2 = new PlaceKeysValuesInArrayLists();
		ptree.rightRootLeftTraversal(task2);
		System.out.print(task2.getKeys().toString());
		assertEquals("[8, 7, 6, 5, 4, 3, 2, 1]", task2.getKeys().toString());
	}

	@Test
	public void testsize() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");

		assertEquals(8, ptree.size());
	}

	@Test
	public void testremove() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		ptree.remove(5);
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists();
		ptree.inorderTraversal(task);
		assertEquals("[1, 2, 3, 4, 6, 7, 8]", task.getKeys().toString());
		PlaceKeysValuesInArrayLists<Integer, String> task2 = new PlaceKeysValuesInArrayLists();
		ptree.rightRootLeftTraversal(task2);
		System.out.print(task2.getKeys().toString());
		assertEquals("[8, 7, 6, 4, 3, 2, 1]", task2.getKeys().toString());
	}

	@Test
	public void testkeyset() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]", ptree.keySet().toString());
	}

	@Test
	public void testmin() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		assertSame(1, ptree.getMin());
	}

	@Test
	public void testmax() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		assertSame(8, ptree.getMax());
	}

	@Test
	public void testsubmap() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		PolymorphicBST<Integer, String> ptree2 = new PolymorphicBST<Integer, String>();
		ptree2 = ptree.subMap(3, 6);
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists();
		ptree2.inorderTraversal(task);
		assertEquals("[3, 4, 5, 6]", task.getKeys().toString());
		assertEquals("[Three, Four, Five, Six]", task.getValues().toString());
	}

	@Test
	public void testclear() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		ptree.clear();
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists();
		ptree.inorderTraversal(task);
		assertEquals("[]", task.getKeys().toString());

	}

	@Test
	public void testheight() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		assertSame(6, ptree.height());

	}

	@Test
	public void testinorderTraversal() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		PolymorphicBST<Integer, String> ptree2 = new PolymorphicBST<Integer, String>();
		ptree2 = ptree.subMap(3, 6);
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists();
		ptree2.inorderTraversal(task);
		assertEquals("[3, 4, 5, 6]", task.getKeys().toString());
		assertEquals("[Three, Four, Five, Six]", task.getValues().toString());

	}

	@Test
	public void testrightRootLeftTraversall() {
		PolymorphicBST<Integer, String> ptree = new PolymorphicBST<Integer, String>();
		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(4, "Four");
		ptree.put(6, "Six");
		ptree.put(7, "Seven");
		ptree.put(8, "Eight");
		ptree.put(5, "Five");
		ptree.remove(5);
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists();
		ptree.inorderTraversal(task);
		assertEquals("[1, 2, 3, 4, 6, 7, 8]", task.getKeys().toString());
		PlaceKeysValuesInArrayLists<Integer, String> task2 = new PlaceKeysValuesInArrayLists();
		ptree.rightRootLeftTraversal(task2);
		assertEquals("[8, 7, 6, 4, 3, 2, 1]", task2.getKeys().toString());

	}

}