package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import sysImplementation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class StudentTests {
	
	@Test
	public void test1() {
		String answer;
		ArrayList<Book> book = null;
		//Book b1 = new Book("Java Is Fun", false, 90);
		//Book b2 = new Book("The Grapes Of Wrath", true, 280);
		//Book b3 = new Book("Java Is Fun", false, 276);
		//Book b4=  new Book("Lord Of The Flies", true, 276);
		//Book b5=new Book("The Great Gatsby", true, 90);
		//Book b6=new Book("The Picture Of Dorian Gray", true, 90);
		//book.add(b1);
		//book.add(b2);
		//book.add(b4);
		//book.add(b5);
		//book.add(b6);
		answer=Book.lazyReader(book, 276);
		System.out.print(answer);
		assertTrue(answer=="");
		}
}