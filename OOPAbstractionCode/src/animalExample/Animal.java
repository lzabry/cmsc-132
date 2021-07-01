package animalExample;

public interface Animal {

	public void feed(String food);

	public int getAge();

	public boolean manBestFriend();

	default void grow() {
		System.out.println("I grow");
	}
}
