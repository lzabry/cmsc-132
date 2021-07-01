package sysImplementation;

public class MapOfCodes {

	static private int[] map;

	public static void makeMap(String[] data) {
		map = new int[122123];
		for (int i = 0; i < 122122; i++) {
			map[i] = 0;
		}
		for (int i = 0; i < data.length; i++) {
			map[data[i].charAt(0) * 1000 + data[i].charAt(1)]++;
		}

	}

	public static int getValue(String key) {
		return map[key.charAt(0) * 1000 + key.charAt(1)];
	}

	public static void resetCount(String key) {
		map[key.charAt(0) * 1000 + key.charAt(1)] = 0;
	}

	public static void put(String key) {
		map[key.charAt(0) * 1000 + key.charAt(1)]++;
	}

	public static String sort(boolean forward) {
		String answer = "";
		for (int i = 97097; i <= 122122; i++) {
			if (map[i] != 0) {
				String current;
				int first;
				int second;
				char a;
				char b;
				second = i % 1000;
				first = (i - second) / 1000;
				a = (char) ('a' + first - 97);
				b = (char) ('a' + second - 97);
				current = "" + a + b;
				if (forward == true) {
					answer += current;
					answer += " ";
				} else {
					answer = current + " " + answer;
				}

			}

		}
		return answer;
	}

	// can have ONE private method - name it whatever you want
	// You can decide the type of the return value,
	// and the types of the parameter(s) but no more than 1 parameters maximum
	// helper method can be called from any and all of the functions above

}
