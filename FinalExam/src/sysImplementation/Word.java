package sysImplementation;

/*
 * Do not modify this class, otherwise you will not pass release/secret tests
 */

public class Word implements Comparable<Word> {
	String word;

	public Word(String w) {
		word = w;
	}

	@Override
	public int compareTo(Word o) {
		return word.compareTo(o.word);

	}

	@Override
	public String toString() {
		return word + " ";
	}

}