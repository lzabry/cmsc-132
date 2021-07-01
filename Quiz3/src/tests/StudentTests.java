package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.sun.source.tree.AssertTree;

import sysImplementation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class StudentTests {
	
	@Test
	public void test1() {
		sysImplementation.LinkedList<Integer> test = new sysImplementation.LinkedList<Integer>();
		test.add(6);
		test.add(1);
		test.add(4);
		test.add(5);
		test.add(1);
		test.add(4);
		test.replaceLess(2);
		System.out.print("fuck you");
	}
}