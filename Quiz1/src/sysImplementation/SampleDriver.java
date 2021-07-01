package sysImplementation;

import java.util.ArrayList;
import java.util.Collections;

public class SampleDriver {

	public static void main(String[] args) {
		String answer = "";

		Book b1 = new Book("Java Is Fun", false, 275);
		Book b2 = new Book("The Grapes Of Wrath", true, 455);
		Book b3 = new Book("Java Is Fun", false, 100);

		ArrayList<Book> bookList = new ArrayList<>();

		bookList.add(b1);
		bookList.add(b2);
		bookList.add(new Book("Lord Of The Flies", true, 285));
		bookList.add(new Book("The Great Gatsby", true, 180));
		bookList.add(new Book("The Picture Of Dorian Gray", true, 254));

		answer += Book.getFictionCount() + "\n";
		answer += b1 + "\n";
		answer += b1.equals(b2) + "\n";
		answer += b1.equals(b3) + "\n";

		answer += Book.makeList(bookList, true, 300);

		answer += Book.lazyReader(bookList, 276) + "\n";

		Collections.sort(bookList);

		answer += bookList + "\n";

		System.out.println(answer);

	}

}
