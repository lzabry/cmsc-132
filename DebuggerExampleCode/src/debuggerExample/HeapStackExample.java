package debuggerExample;

public class HeapStackExample {
	public static void task(StringBuffer dessert, int calories) {
		dessert.append("cherry");
		calories += 100;
		System.out.println("Dessert: " + dessert + ", Calories: " + calories);
	}
	
	public static void main(String[] args) {
		StringBuffer cheesecake = new StringBuffer("Cheesecake");
		int cal = 800;
		
		task(cheesecake, cal);
	}
}
