package sysImplementation;

public class calculator {

	public static void main(String[] args) {
		double x=1;
		
		for (int i=1; i<= 999 ; i++) {
			x = x/2 + 1/Math.pow(x,3);
		}
		
		System.out.print(x);

	}

}
