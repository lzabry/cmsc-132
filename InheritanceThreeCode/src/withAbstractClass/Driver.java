package withAbstractClass;

import withAbstractClass.Shape;

public class Driver {
	public static void main(String[] args) {
		int numberOfShapes = 2;
		Shape[] allShapes = new Shape[numberOfShapes];
		
		allShapes[0] = new Circle("Red", 10);
		allShapes[1] = new Rectangle("Blue", 15, 20);
		
		for (int i = 0; i < allShapes.length; i++) {
			allShapes[i].drawMe();
		}
		
		/* No longer possible
		Shape s = new Shape("Green"); 
		s.drawMe();
		*/
	}
}