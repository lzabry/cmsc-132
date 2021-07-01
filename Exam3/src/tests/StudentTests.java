package tests;

import static org.junit.Assert.*;

import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import sysImplementation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class StudentTests {
	
	@Test
	public void test1() {
		String answer="";
		LinkedList <Integer>l = new LinkedList<Integer>();
		l.add(3).add(1).add(1).add(1).add(1).add(1);
		TreeMap<Integer, Integer> m = l.compress();
		for (Entry<Integer, Integer> entry : m.entrySet()) {
			answer += "[" + entry.getKey()  + ", " + entry.getValue() + "]\n"; 
		}
		answer +=l.toString()+"\n";
		System.out.print(answer);
		
		
		
		
		
		
		
	}
}