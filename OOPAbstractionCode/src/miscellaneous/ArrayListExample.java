package miscellaneous;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>();

		/* List of names */
		nameList.add("Barbara");
		nameList.add("Anne");
		nameList.add("Kelly");

		System.out.println("*** After adding elements ***");
		for (int i = 0; i < nameList.size(); i++) {
			String name = nameList.get(i);
			if (name.equals("Kelly")) {
				name += " is my BFF";
			}
			System.out.println(name);
		}

		nameList.remove(1);
		System.out.println("*** After removal ***");
		System.out.println(nameList);

		/* No type specified (old approach; don't use) */
		ArrayList myList = new ArrayList();
		myList.add("Jose");
		String value = (String) myList.get(0);
		System.out.println("Value retrieved: " + value);
	}
}