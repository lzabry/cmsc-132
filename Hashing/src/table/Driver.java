package table;

public class Driver {
	public static void main(String[] args) {
		System.out.println("Separate Chaining:");
		
		SeparateChaining<String> table = new SeparateChaining<>(5);
		
		table.insert("CMSC131");
		table.insert("CMSC132");
		table.insert("CMSC216");
		table.insert("CMSC330");
		table.insert("CMSC351");
		
		// Notice CMSC132 and CMSC131 are in the same index
		System.out.println("Table: " + table.showMeTable());
		
		System.out.println("Where is CMSC132? " + table.search("CMSC132"));
		
		System.out.println("Where is CMSC320? " + table.search("CMSC320"));
		
		table.remove("CMSC132");
		table.remove("CMSC330");
		table.remove("CMSC320");
		
		System.out.println("New Table: " + table.showMeTable());
		
		System.out.println("\nQuadratic Probing:");
		
		QuadraticProbing table2 = new QuadraticProbing(5);
		
		table2.insert("CMSC131");
		table2.insert("CMSC132");
		table2.insert("CMSC216");
		table2.insert("CMSC330");
		table2.insert("CMSC351");
		
		System.out.println("Table: " + table2.showMeTable());
		
		System.out.println("Where is CMSC132? " + table2.search("CMSC132"));
		
		System.out.println("Where is CMSC320? " + table2.search("CMSC320"));
		
		table2.remove("CMSC132");
		table2.remove("CMSC330");
		table2.remove("CMSC320");
		
		System.out.println("New Table: " + table2.showMeTable());
	}
}
