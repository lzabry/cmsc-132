package sysImplementation;

public class SampleDriver1 {

	public static void main(String[] args) {

		String answer = "";

		answer += "===================MyLinkedList Output=======================\n";

		MyLinkedList<Word> WordList1 = new MyLinkedList<Word>();

		WordList1.add(new Word("pen")).add(new Word("pen")).add(new Word("lunch")).add(new Word("book"))
				.add(new Word("table"));
		WordList1.add(new Word("tea")).add(new Word("tv")).add(new Word("tv")).add(new Word("cactus"))
				.add(new Word("tv"));
		WordList1.add(new Word("bye")).add(new Word("hi"));

		answer += WordList1.getSize() + "\n";
		answer += WordList1 + "\n";
		answer += WordList1.toStringReverse() + "\n";

		WordList1.deleteAfter(new Word("tv"));
		answer += WordList1 + "\n";

		WordList1.deleteAfter(new Word("tv"));
		answer += WordList1 + "\n";

		WordList1.deleteAfter(new Word("pen"));
		answer += WordList1 + "\n";

		WordList1.deleteAfter(new Word("pencil"));
		answer += WordList1 + "\n";

		WordList1.deleteAfter(new Word("hi"));
		answer += WordList1 + "\n";

		/*
		 * answer += WordList1.newHead(new Word("book")) +"\n"; answer +=
		 * WordList1+"\n"; answer += WordList1.toStringReverse()+"\n";
		 * 
		 * answer += WordList1.newHead(new Word("book")) +"\n"; answer +=
		 * WordList1+"\n";
		 * 
		 * answer += WordList1.newHead(new Word("computer")) +"\n"; answer +=
		 * WordList1+"\n";
		 * 
		 * answer += WordList1.newHead(new Word("table")) +"\n"; answer +=
		 * WordList1+"\n"; answer += WordList1.toStringReverse()+"\n";
		 * 
		 * 
		 * 
		 * answer += "===================CS132Sorter Output=======================\n";
		 * 
		 * 
		 * Word data [] = {new Word("hi"), new Word("bye"), new CSWord("java"), new
		 * CSWord("assert"), new Word("tv"), new CSWord("debug"), new Word ("table"),
		 * new Word ("book"), new CSWord("if"), new CSWord("array")};
		 * 
		 * 
		 * 
		 * CMSC132Sorter.CMSC132Sort(data, 7); //just first 7 for (Word w: data)
		 * answer+= w; answer += "\n";
		 * 
		 * Word data1 [] = {new Word("hi"), new Word("bye"), new CSWord("java"), new
		 * CSWord("assert"), new Word("tv"), new CSWord("debug"), new Word ("table"),
		 * new Word ("book"), new CSWord("if"), new CSWord("array")};
		 * 
		 * CMSC132Sorter.CMSC132Sort(data1, data1.length); //CMSC132 sort the whole
		 * thing for (Word w: data1) answer+= w; answer += "\n";
		 */

		System.out.println(answer);

	}

}
