package animalExample;

public class Driver {
	public static void feedAnimal(Animal animal) {
		System.out.println("**** Feeding Animal ****");
		System.out.println("Animal's age: " + animal.getAge());
		animal.feed("hamburger");
		animal.feed("pizza");
		animal.feed("ice-cream");
	}

	public static void main(String[] args) {
		int age = 3;
		Dog lassie = new Dog("Lassie", age);

		lassie.feed("taco");
		lassie.bark();
		lassie.bark();

		if (lassie instanceof Animal) {
			System.out.println("Dog is an animal");
		}

		Animal animal = lassie;
		animal.feed("burrito");
		System.out.println("Man Best friend: " + animal.manBestFriend());

		// animal.bark() //possible??

		Piranha piranha = new Piranha(5);
		piranha.feed("cookies");
		animal = piranha;
		// ((Dog)animal).bark(); //possible???

		lassie.grow();
		piranha.grow();
		feedAnimal(lassie);
		feedAnimal(piranha);
	}
}
