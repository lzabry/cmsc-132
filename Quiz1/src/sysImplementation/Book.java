package sysImplementation;

import java.util.ArrayList;

public class Book implements Comparable<Book> {

	private String title;
	private boolean fiction;
	private int pages;
	private static int fictionCount = 0;

	public Book(String title, boolean fiction, int pages) {
		this.title = title;
		this.fiction = fiction;
		this.pages = pages;
		if (fiction == true) {
			fictionCount++;
		}

	}

	public static int getFictionCount() {
		return fictionCount;

	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	public static void resetfictionCount() {
		fictionCount = 0;
	}

	/*
	 * Do not modify this class, otherwise you will not pass release/secret tests
	 */

	@Override
	public String toString() {
		return "Book [title=" + title + ", fiction=" + fiction + ", pages=" + pages + "]";
	}

	public int compareTo(Book book) {
		return -1 * this.title.compareTo(book.title);

	}

	@Override
	public boolean equals(Object obj) {
		Book a = (Book) obj;
		if (this.title == a.title) {
			return true;
		} else {
			return false;
		}
	}

	public static String lazyReader(ArrayList<Book> book, int lowerBound) {
		if (book == null || book.size() == 0) {
			return "";
		} else {
			ArrayList<Book> book2 = new ArrayList<Book>();
			for (int i = 0; i < book.size(); i++) {
				if (book.get(i).pages >= lowerBound) {
					book2.add(book.get(i));
				}
			}
			if (book2.size() == 0 || book2 == null) {
				return "";
			} else {
				Book lowest = book2.get(0);
				for (int i = 1; i < book2.size(); i++) {
					if (book2.get(i).pages < lowest.pages) {
						lowest = book2.get(i);
					}
				}
				return lowest.title;
			}
		}

	}

	public static String makeList(ArrayList<Book> book, boolean fiction, int pageMax) {
		int count = 0;
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < book.size(); i++) {
			if (book.get(i).fiction == fiction && book.get(i).pages <= pageMax) {
				s.append(book.get(i).toString());
				s.append("\n");
				count++;
			}
		}
		if (count == 0) {
			return "";
		} else {
			return s.toString();
		}
	}

}
