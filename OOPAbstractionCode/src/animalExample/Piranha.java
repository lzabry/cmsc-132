package animalExample;

public class Piranha implements Animal {
	private int age;

	public Piranha(int age) {
		this.age = age;
	}

	public void feed(String food) {
		System.out.println("Piranha is eating " + food);
	}

	public int getAge() {
		return age;
	}

	public boolean manBestFriend() {
		return false;
	}

	public void grow() {
		System.out.println("I grow like a fish");
	}
}