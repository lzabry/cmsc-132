package sysImplementation;

public class CMSC132Sorter {

	public static void CMSC132Sort(Word[] a, int length) {
		if (length > a.length) {
			return;
		}
		int outer, inner;
		for (outer = length - 1; outer > 0; outer--) {
			for (inner = 0; inner < outer; inner++) {
				if (a[inner] instanceof CSWord && a[inner + 1] instanceof CSWord
						&& a[inner].compareTo(a[inner + 1]) > 0) {
					Word temp = a[inner];
					a[inner] = a[inner + 1];
					a[inner + 1] = temp;
				} else if (a[inner + 1] instanceof CSWord && !(a[inner] instanceof CSWord)) {
					Word temp = a[inner];
					a[inner] = a[inner + 1];
					a[inner + 1] = temp;
				}
			}
		}
	}
}
