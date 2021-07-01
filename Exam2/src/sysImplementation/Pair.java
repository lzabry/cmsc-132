package sysImplementation;

public class Pair<T, U> {

	private T first;
	private U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	@SuppressWarnings("unlikely-arg-type")
	public String getString(char separator) {
		if (first.getClass() == second.getClass()) {
			if (first.equals(second)) {
				return "same class and equal";
			} else {
				return "same class and not equal";
			}
		} else {
			if (first instanceof String) {
				return first.toString() + separator + second.toString() + separator + "str1";
			} else if (second instanceof String) {
				return first.toString() + separator + second.toString() + separator + "str2";
			} else {
				return first.toString() + separator + second.toString();
			}
		}
	}

}
