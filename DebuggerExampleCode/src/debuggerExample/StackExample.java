package debuggerExample;

public class StackExample {

	public static void processing(int a, int y) {
		int k;

		k = a + y;
		System.out.println(a + ", " + y + ", " + k);
	}

	public static void task(int x, int y) {
		int w = 10, m;

		m = w + x + y;
		processing(m, 200);
	}

	public static void main(String[] args) {
		int p = 10, r = 20;
		task(p, r);
	}
}
