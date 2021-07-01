package processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.TreeMap;

public class OrderThread extends Thread {
	private int number;
	private TreeMap<String, Integer> order;
	private String base;
	private TreeMap<String, Double> items;


	public OrderThread(int number, TreeMap<String, Integer> order, String base, TreeMap<String, Double> items) {
		this.number = number;
		this.order = order;
		this.base = base;
		this.items = items;


	}

	private TreeMap<String, Integer> readfromfile() throws IOException {
		this.order = new TreeMap<String, Integer>();
		FileReader f = new FileReader(base + number + ".txt");
		BufferedReader br = new BufferedReader(f);
		String contentLine = br.readLine();
		int client = Integer.parseInt(contentLine.split(":")[1].trim());
		System.out.println("Reading order for client with id: " + client);
		contentLine = br.readLine();
		while (contentLine != null) {
			String key = contentLine.split(" ")[0];
			if (order.containsKey(key)) {
				order.put(key, order.get(key) + 1);
			} else {
				order.put(key, 1);
			}
			contentLine = br.readLine();
		}
		br.close();
		return order;
	}

	private String createString() {
		String ans = "";
		ans += "----- Order details for client with Id: " + (1000 + number) + " -----";
		ans += "\n";
		double cost = 0.0;
		for (String s : order.keySet()) {
			ans += "Item's name: " + s + ", Cost per item: " + NumberFormat.getCurrencyInstance().format(items.get(s))
					+ ", Quantity: " + order.get(s) + ", Cost: "
					+ NumberFormat.getCurrencyInstance().format((double)(items.get(s) * order.get(s)));
			cost += (double)(items.get(s) * order.get(s));
			ans += "\n";
			
		}
		ans += "Order Total: " + NumberFormat.getCurrencyInstance().format(cost);
		ans += "\n";

		return ans;

	}

	public void run() {
		        
			try {
				this.order=this.readfromfile();
				synchronized(OrdersProcessor.output) {
				OrdersProcessor.summing.put(this.number,order);
				OrdersProcessor.output.put(this.number, this.createString());
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		

	

}
}
