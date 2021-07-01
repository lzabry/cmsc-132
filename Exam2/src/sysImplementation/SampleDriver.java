package sysImplementation;

import java.util.ArrayList;
import java.util.Arrays;


public class SampleDriver {

	public static void main(String[] args) {

		

		String answer = "";

		answer += "===================Pair Output=======================\n";

		Pair<StringBuffer, String> pair1 = new Pair<StringBuffer, String>(new StringBuffer("Tree"), "Birds");
		answer += pair1.getString('*') + "\n";

		Pair<Integer, Double> pair2 = new Pair<Integer, Double>(2, 3.14);
		answer += pair2.getString('$') + "\n";

		answer += "====================Utilities Output=========================\n";

		ArrayList<Integer> i = new ArrayList<Integer>(Arrays.asList(6, 8, 7, 4, 5, -5, 2, 19));

		ArrayList<Integer> ans = Utilities.getSubList(i, 7, 4); // 4 is not valid code value

		answer += ans + "\n";

		ans = Utilities.getSubList(i, 7, 1); // elements less than 7

		answer += ans + "\n";

		ans = Utilities.getSubList(i, 7, 2); // elements greater than 7

		answer += ans + "\n";

		answer += "====================SoftwareCompany Output=============================\n";

		SoftwareCompany sc1 = loadSoftwareCompany1();
		SoftwareCompany sc2 = loadSoftwareCompany2();

		answer += sc1 + "\n";

		answer += sc1.numberOfProgrammers() + "\n";

		sc1.addProgrammer("acb", 500);

		sc1.newProject("acb", 802).newProject("bac", 360); // 360 not added since was already assigned to "bac"
															

		answer += sc1 + "\n";

		for (String s : sc1) {
			answer += s;
		}

		sc1 = sc2.clone();

		sc2.addProgrammer("acb", 500);

		answer += sc1 + "\n";
		answer += sc2 + "\n";

		answer += "sc1 < sc2: " + (sc1.compareTo(sc2) < 0 ? true : false) + "\n";

		sc1.newProject("xyz", 801);

		answer += "sc1 == sc2: " + (sc1.compareTo(sc2) == 0 ? true : false) + "\n";

		answer += "sc1 > sc2: " + (sc1.compareTo(sc2) > 0 ? true : false) + "\n";

		answer += "====================SCComparator Output=============================\n";

		answer += "sc1 > sc2: " + (new SCComparator().compare(sc1, sc2) > 0 ? true : false) + "\n";

		answer += "sc1 < sc2: " + (new SCComparator().compare(sc1, sc2) < 0 ? true : false) + "\n";

		System.out.println(answer);
	}

	private static SoftwareCompany loadSoftwareCompany1() {

		SoftwareCompany sc = new SoftwareCompany();

		sc.addProgrammer("abc", 220);
		sc.newProject("abc", 800);

		sc.addProgrammer("cba", 800);
		sc.newProject("cba", 801);

		sc.addProgrammer("bac", 825);
		sc.newProject("bac", 360);
		sc.newProject("bac", 370);

		return sc;
	}

	private static SoftwareCompany loadSoftwareCompany2() {

		SoftwareCompany sc = new SoftwareCompany();

		sc.addProgrammer("xyz", 220);
		sc.newProject("xyz", 800);

		return sc;
	}
}