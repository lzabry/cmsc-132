package sysImplementation;

import java.util.ArrayList;

public class JigsawPuzzle extends Toy {
	private int numberOfPieces;

	public JigsawPuzzle(String productCode, double price, int numberOfPieces) {
		super(productCode, price);
		if (numberOfPieces <= 0 || numberOfPieces % 10 != 0) {
			throw new InvalidDataException("Bad data in the constructor");
		} else {
			this.numberOfPieces = numberOfPieces;
		}
	}

	public int getNumberOfPieces() {
		return this.numberOfPieces;
	}

	public String difficultyLevel() {
		if (numberOfPieces <= 200) {
			return "easy";
		} else if (numberOfPieces <= 550 && numberOfPieces >= 201) {
			return "medium";
		} else {
			return "hard";
		}
	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	@Override
	public String toString() {
		return super.toString() + ", Number of Pieces: " + numberOfPieces;

	}

	public static String jigsawDetails(ArrayList<Toy> toys, boolean withdifficulty) {
		String s = "";
		if (withdifficulty) {
			for (Toy t : toys) {
				if (t instanceof JigsawPuzzle) {
					s = s + t.toString();
					s = s + ", Difficulty Level: " + ((JigsawPuzzle) t).difficultyLevel() + "\n";
				}
			}
			return s;
		} else {
			for (Toy t : toys) {
				if (t instanceof JigsawPuzzle) {
					s = s + t.toString() + "\n";
				}
			}
			return s;
		}
	}

}
