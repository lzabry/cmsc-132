package sysImplementation;

public class JigsawPuzzle3D extends JigsawPuzzle{
	
	private int height;  

	public JigsawPuzzle3D(String productCode, double price, int numberOfPieces, int height) {
		super(productCode,price,numberOfPieces);
		if (height<=0) {
			throw new InvalidDataException("Bad data in the constructor");
		}else {
			this.height=height;
		}
	}
	
	@Override 
	public String difficultyLevel()
	{
		if (this.getNumberOfPieces()<=300) {
			return "easy";
		}else if (this.getNumberOfPieces()>300 && height<=5) {
			return "medium";
		}else {
			return "hard";
		}
		
	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	@Override
	public String toString() {
		return  super.toString() + ", Height: " + height;
	}
	

	
	  
}
