package sysImplementation;

public class MultipleChoice {
	/*
	 * To answer a question, remove the "throw" statement and add a return statement
	 * with the letter representing your answer. For example, return 'c'; if you
	 * think the answer is c.
	 */

	public static char question1() {

		/*
		 * Which statement is TRUE?
		 * 
		 * a. You don't need a deep copy for a class if the fields are only int and
		 * String b. Mark-and-Sweep is a search algorithm with worst-case time O(log n)
		 * c. You can initialize instance fields in a static initialization block d. var
		 * is not a keyword in Java
		 */

		return 'a';
	}

	public static char question2() {

		/*
		 * 
		 * Assume the following class inheritance hierarchy: Undergrad is a Student, and
		 * a Student is a Person. Which variable below can be assigned the reference of
		 * an ArrayList of Student?
		 * 
		 * a. ArrayList <? super Object> a; b. ArrayList <Undergrad> b; c. ArrayList <?
		 * extends Undergrad> c; d. ArrayList <? extends Student> d;
		 * 
		 */

		return 'd';
	}

	public static char question3() {

		/*
		 * 
		 * 2(n^3) + 8(n^2) + 25 is in
		 * 
		 * a. O(n^3) b. O(nlogn) c. O(1,000,000) d. none of the above
		 * 
		 */

		return 'a';
	}

	public static char question4() {

		/*
		 * 
		 * Assume the only thing you know about an algorithm is that it is in O(n^4) and
		 * you only consider algorithms in O(n^2) to be fast. What do you know for sure
		 * about this mystery algorithm.
		 * 
		 * a. It is slow b. It is fast c. It is not possible for it to be in O(nlogn) d.
		 * It will not exhibit exponential growth as the input size increases
		 * 
		 */

		return 'd';
	}

	public static char question5() {
		/*
		 * 
		 * If you want 5(n^2) + 4(n) + 20 to be in O(n), what value of M would work (see
		 * definition of Big-O for what M refers to)
		 * 
		 * a. 29 b. 100 c. Don't pick a constant, make M be n, so n * n can be n^2 d.
		 * None of the above would work
		 * 
		 */

		return 'd';
	}

	public static char question6() {
		/*
		 * 
		 * Which statement is TRUE?
		 * 
		 * a. The best-case scenario in doing a binary search on an array with 1000
		 * elements is when the target value is found in the first array element (with
		 * index 0) b. An algorithm can have best, worst, and average case all be in
		 * O(n^2) c. If an algorithm is in O(n^2), you may be able to show it is O(n^3)
		 * on a slower computer d. 5 (ln(n)) is not in O(log n)
		 * 
		 */

		return 'b';
	}

}
