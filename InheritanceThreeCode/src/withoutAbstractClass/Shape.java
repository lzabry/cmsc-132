package withoutAbstractClass;

public class Shape {
	private String color;

	public Shape(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void drawMe() {
		System.out.println("What should we do???");
	}
}