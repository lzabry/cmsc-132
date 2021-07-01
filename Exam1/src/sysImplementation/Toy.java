package sysImplementation;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Toy implements Comparable<Toy> {

	private String productCode;
	private double price;
	private static int countOver10 = 0;

	public Toy(String productCode, double price) {
		if (productCode == null) {
			throw new InvalidDataException("Bad data in the constructor");
		}
		if (!Character.isLetter(productCode.charAt(0))) {
			throw new InvalidDataException("Bad data in the constructor");
		}
		for (int i = 0; i < productCode.length(); i++) {
			if ((!Character.isLetter(productCode.charAt(i))) && (!Character.isDigit(productCode.charAt(i)))) {
				throw new InvalidDataException("Bad data in the constructor");
			}
			if (productCode.charAt(i) == '0') {
				throw new InvalidDataException("Bad data in the constructor");
			}
		}
		if (price <= 0) {
			throw new InvalidDataException("Bad data in the constructor");
		}
		this.productCode = productCode.toLowerCase();
		this.price = price;
		if (price > 10) {
			countOver10++;
		}

	}

	public double validPrice(double price) throws InvalidPriceException {
		if (price <= 0) {
			throw new InvalidPriceException("Invalid Price");
		} else {
			return price;
		}

	}

	public void setPrice(double price) {
		try {
			double originalprice;
			double setprice;
			setprice = validPrice(price);
			originalprice = this.price;
			if (originalprice <= 10) {
				if (setprice > 10) {
					countOver10++;
				}
			}
			if (originalprice > 10) {
				if (setprice <= 10) {
					countOver10--;
				}
			}
			this.price = setprice;
		} catch (InvalidPriceException e) {
			this.price = 10;
		}

	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	@Override
	public String toString() {
		return "Product Code: " + productCode + ", Price: " + price;
	}

	public int compareTo(Toy toy) {
		return (this.productCode.compareTo(toy.productCode));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (!(obj instanceof Toy)) {
			return false;
		} else {
			return this.compareTo((Toy) obj) == 0;
		}
	}

	public static int getCountOver10() {
		return countOver10;
	}

	public String getProductCode() {
		return this.productCode;
	}

	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	public static void resetGetCountOver10() {
		countOver10 = 0;
	}

	public static String[] getCodes(ArrayList<Toy> t, double min, double max) {
		if (min <= 0 || max <= 0 || min > max) {
			return null;
		} else {
			int count = 0;
			for (Toy a : t) {
				if (a.price >= min && a.price <= max) {
					count += 1;
				}
			}
			String[] k = new String[count];
			int i = 0;
			for (Toy a : t) {
				if (a.price >= min && a.price <= max) {
					k[i] = a.productCode;
					i++;
				}
			}
			return k;
		}

	}

}
