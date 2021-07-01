package model;

public class TextElement implements Element {

	private String text;

	public TextElement(String text) {
		this.text = text;
	}

	public String genHTML(int indentation) {
		String s = "";
		for (int i = 0; i < indentation; i++) {
			s = s + " ";
		}
		s = s + text;
		return s;
	}

}
