package processor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class OrdersProcessor {

	private static TreeMap<String, Double> shop;

	public static TreeMap<Integer, String> output;

	public static TreeMap<Integer, TreeMap<String, Integer>> summing;

	public static void main(String[] args) throws IOException, InterruptedException {
		summing = new TreeMap<Integer, TreeMap<String, Integer>>();
		output = new TreeMap<Integer, String>();
		String data;
		shop = new TreeMap<String, Double>();
		Scanner scanner = new Scanner(System.in);
		String itemfile;
		boolean multi;
		String base;
		int ordernumber;
		String result;

		/*
		 * Let user type base name and file Number
		 * 
		 * For each File name + number(1-file number), create a thread to read or: just
		 * for each.
		 * 
		 * In a thread, count the order and record it in something.
		 * 
		 * After all threads finished, ask the user to give a result name.
		 * 
		 * Then, look back to that "something", take all data out and generate a file as
		 * in the instruction.
		 * 
		 * done
		 */

		System.out.println("Enter item's data file name:");
		itemfile = scanner.nextLine();
		try {
			data = Files.readString(Paths.get(itemfile));
			String[] items = data.split("\n");
			for (String item : items) {
				String[] line = item.split(" ");
				shop.put(line[0], Double.parseDouble(line[1]));
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}

		System.out.println("Enter 'y' for multiple threads, any other character otherwise: ");
		if (scanner.nextLine().equals("y")) {
			multi = true;
		} else {
			multi = false;
		}
		System.out.println("Enter number of orders to process: ");
		ordernumber = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter order's base filename: ");
		base = scanner.nextLine();
		System.out.println("Enter result's filename: ");
		result = scanner.nextLine();
		scanner.close();

		// all the information is collected, next we run thread
		long startTime = System.currentTimeMillis();

		if (multi) {
			ArrayList<OrderThread> thread = new ArrayList<OrderThread>();
			for (int i = 1; i <= ordernumber; i++) {
				thread.add(new OrderThread(i, new TreeMap<String, Integer>(), base, shop));

			}
			for (OrderThread o : thread) {
				o.start();
			}
			for (OrderThread o : thread) {
				o.join();
			}

		} else {
			ArrayList<OrderThread> thread = new ArrayList<OrderThread>();
			for (int i = 1; i <= ordernumber; i++) {
				thread.add(new OrderThread(i, new TreeMap<String, Integer>(), base, shop));

			}
			for (OrderThread o : thread) {
				o.start();
				o.join();
			}
		}
		// add each order
		BufferedWriter writer = new BufferedWriter(new FileWriter(result));
		for (Integer i : output.keySet()) {
			writer.append(output.get(i));
		}

		// add summary
		TreeMap<String, Integer> sumtable = new TreeMap<String, Integer>();
		String summary = "***** Summary of all orders *****" + "\n";
		double sumtotal = 0.0;
		for (int i : summing.keySet()) {
			for (String s : summing.get(i).keySet()) {
				sumtable.put(s, 0);
			}
		}
		for (int i : summing.keySet()) {
			for (String s : summing.get(i).keySet()) {
				sumtable.put(s, sumtable.get(s) + summing.get(i).get(s));
			}
		}

		for (String s : sumtable.keySet()) {
			summary += "Summary - Item's name: " + s + ", Cost per item: "
					+ NumberFormat.getCurrencyInstance().format(shop.get(s)) + ", Number sold: " + sumtable.get(s)
					+ ", Item's Total: "
					+ NumberFormat.getCurrencyInstance().format((double) (shop.get(s) * sumtable.get(s)));
			sumtotal += (double) (shop.get(s) * sumtable.get(s));
			summary += "\n";

		}

		summary += "Summary Grand Total: " + NumberFormat.getCurrencyInstance().format(sumtotal);
		summary += "\n";

		writer.append(summary);
		writer.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Processing time (msec): " + (endTime - startTime));
		System.out.println("Results can be found in the file: " + result);

	}

}
