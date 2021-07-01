package withAbstractClass;

public class Circle extends Shape {
	private int radius;
	
	public Circle(String color, int radius) {
		super(color);
		this.radius = radius;
	}
	
	public void drawMe() {
		System.out.println("Drawing Circle with radius " + radius);
	}
}
