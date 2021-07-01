package animalExample;

public class Dog implements Animal {
	private String name;
	private int age;

	public Dog(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public void feed(String food) {
		System.out.println("Feeding " + name + " with " + food);
	}

	public int getAge() {
		return age;
	}

	public boolean manBestFriend() {
		return true;
	}

	public void bark() {
		System.out.println(name + " is barking");
	}
}