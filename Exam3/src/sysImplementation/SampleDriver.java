package sysImplementation;

import java.util.Map.Entry;
import java.util.TreeMap;

public class SampleDriver {

	public static void main(String[] args) {

		

		String answer = "";

		answer += "===================myHashTable Output=======================\n";

		myHashTable h = new myHashTable(5);
		h.insert("CMSC132");
		h.insert("CMSC216");
		answer+=h.showMeTable()+"\n";
		answer+=h.loadFactor()+"\n";
		answer+=h.insert("CMSC131")+"\n";
		answer+=h.insert("CMSC131")+"\n";
		answer+=h.search("CMSC250")+"\n";
		h.insert("CMSC250");
		answer+=h.search("CMSC351")+"\n";
		h.insert("CMSC351");
		answer+=h.getSize()+"\n";
		answer+=h.showMeTable()+"\n";
		answer+=h.search("cmsc132")+"\n";
		answer+=h.search("CMSC132")+"\n";
		answer+=h.remove("CMSC132")+"\n";
		answer+=h.getCapacity()+"\n";
		answer+=h.getSize()+"\n";
		answer+=h.showMeTable()+"\n";
		answer+=h.remove("CMSC132")+"\n";
		answer+=h.search("CMSC131")+"\n";
		answer+=h.insert("java")+"\n";
		answer+=h.showMeTable()+"\n";
		answer+=h.insert("umd")+"\n";
		answer+=h.remove("CMSC131")+"\n";

		
		answer += "===================compress Output=======================\n";
		LinkedList <Integer>l = new LinkedList<Integer>();
		l.add(5).add(5).add(7).add(5).add(3).add(5).add(3).add(3).add(4).add(4);
		TreeMap<Integer, Integer> m = l.compress();
		for (Entry<Integer, Integer> entry : m.entrySet()) {
			answer += "[" + entry.getKey()  + ", " + entry.getValue() + "]\n"; 
		}
		answer +=l.toString()+"\n";
		
		answer += "===================mapList Output=======================\n";
		m.put(6, -2);
		answer +=l.mapList(m).toString();
		
		
		
		
		System.out.println(answer);
	}

	
}

