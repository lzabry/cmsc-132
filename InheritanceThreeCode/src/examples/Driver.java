package examples;

public class Driver {
	public static void main(String[] args) {
		TerpIceCream terpIceCream = new TerpIceCream();

		System.out.println("Price: " + terpIceCream.getIceCreamPrice());
		System.out.println("Calories: " + IceCreamStore.CHOCOLATE_CALORIES);
	}
}
