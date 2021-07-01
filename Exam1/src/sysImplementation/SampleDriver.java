package sysImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SampleDriver {

	public static void main(String[] args) {
		String answer = "";

		Toy t = new Toy("toy1", 8);
		answer += t + "\n";

		Doll d = new Doll("doll1", 8.75);
		d.setPrice(-5);

		answer += d + "\n";

		JigsawPuzzle jp = new JigsawPuzzle("jp5", 15, 210);
		answer += jp + "\n";

		Toy jp3d = new JigsawPuzzle3D("jp3d5", 20, 250, 8);
		answer += jp3d + "\n";

		ArrayList<Toy> toyList = new ArrayList<Toy>();
		toyList.add(t);
		toyList.add(d);
		toyList.add(jp);
		toyList.add(jp3d);

		answer += "==================================================\n";

		answer += Toy.getCountOver10() + "\n";
		;

		d.setPrice(11);

		answer += Toy.getCountOver10() + "\n";
		;

		answer += Arrays.toString(Toy.getCodes(toyList, 7, 12)) + "\n";

		answer += JigsawPuzzle.jigsawDetails(toyList, false) + "\n";

		Collections.sort(toyList);

		answer += JigsawPuzzle.jigsawDetails(toyList, true) + "\n";

		answer += toyList + "\n";

		System.out.println(answer);

	}

}
