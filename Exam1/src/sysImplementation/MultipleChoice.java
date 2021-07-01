package sysImplementation;

public class MultipleChoice {
	/* 
	 * To answer a question, remove the "throw" statement and add a return 
	 * statement with the letter representing your answer. For example, to 
	 * answer the first question below, remove "throw ..." and add return 
	 * 'b'; Every question only has one answer.
	 */
	
	
	public static char question1() {
		/* 
		   This course is:
		   
		   a. cmsc131
		   b. cmsc132
		   c. cmsc216
		   d. None of the above.
		
		 
		*/
		return 'b';
		
	}
	
	
	public static char question2() {
		/*
		  Assume a and b are instances of the class C with Object as the parent class. The class C
		  does not override any methods it inherits from Object. Also, assume that b was constructed 
		  using the copy constructor of the class C with a as the argument.  What would 
		  System.out.println(a.equals(b) ==  b.equals(a)); display.
		  
		  a. Some hexadecimal number because there is no valid toString
		  b. true
		  c. false
		  d. Can not answer the question without seeing the code for the copy constructor of C

		*/
		
		return 'b';
	}
	
	public static char question3() {
		
		/*
		  Which statement is FALSE?
		  
		  a. A list would be an example of an ADT and an ArrayList would be an implementation of a list
		  b. An interface defines a IS-A relationship
		  c. Every interface has a default constructor
		  d. There is no keyword for package protection

		*/
		
		return 'c';
	}
	
	public static char question4() {
		
		/*
		  Which statement is TRUE?
		  
		  a. You can not use an enhanced for loop with an array 
		  b. A class can not directly access (using dot notation) a private member of its parent class
		  c. A class can only override the toString() method if the parent is Object
		  d. All of the 8 primitives have a wrapper class except boolean

		*/
		
		return 'b';
	}
	
	
	public static char question5() {
		
		/*
		  
		  Assume you have designed a class called CMSC132 with Object as the parent class.
		  CMSC132 has only one constructor that takes in an int.  Why will the following line not 
		  compile:  CMSC132 c = new CMSC132 ();
		  
		  a. Because a class can not have numbers in its name 
		  b. Constructing a CMSC132 object without passing in an int is no longer valid
		  c. You have to override the toString and equals method to get the line to compile
		  d. Because when the Object constructor is invoked from the CMSC132 constructor an int is needed.

		*/

		return 'b';
	}
	
	public static char question6() {
		/*
		  
		  Assume the following statements:
		  
		  1.  You can design an abstract class without any of the methods being abstract
		  2.  A class can not inherit from an abstract class
		  3.  Any class that inherits from the class Exception will be a checked exception
		  4.  Both throw and throws are Java keywords
		  
		  a. There are an equal number of true and false statements
		  b. There are more false statements than true
		  c. There are more true statements than false
		  d. All of them are false

		*/

		return 'c';
	}
	
	
	
	
}
