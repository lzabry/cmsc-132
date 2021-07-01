package sysImplementation;

import java.util.ArrayList;

public class Utilities {
	public static <T extends Comparable<T>> ArrayList<T> getSubList(ArrayList<T> data, T target, int code) {
		ArrayList<T> newlist = new ArrayList<T>();
		if (code == 1) {
			for (T t : data) {
				if (t.compareTo(target) < 0) {
					newlist.add(t);
				}
			}
		} else if (code == 2) {
			for (T t : data) {
				if (t.compareTo(target) > 0) {
					newlist.add(t);
				}
			}
		} else if (code == 3) {
			for (T t : data) {
				if (t.compareTo(target) == 0) {
					newlist.add(t);
				}
			}

		} else {
			return null;
		}
		return newlist;
	}
}
