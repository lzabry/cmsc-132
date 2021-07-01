package withAbstractClass;

public abstract class Shape {
	private String color;

	public Shape(String color) { // OK to have constructor as a constructor
		this.color = color;	     // initializes color part
	}
	
	public String getColor() {
		return color;
	}
	
	public abstract void drawMe();
}