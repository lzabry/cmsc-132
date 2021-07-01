package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement {
	private ArrayList<Element> units = new ArrayList<Element>();

	public ParagraphElement(String attributes) {
		super("p", true, null, attributes);
	}

	public void addItem(Element item) {
		units.add(item);
	}

	public String genHTML(int indentation) {
		String s = "";
		String space = "";
		for (int i = 0; i < indentation; i++) {
			space = space + " ";
		}
		s = s + space;
		s = s + super.getStartTag();
		s = s + "\n";
		for (Element e : this.units) {
			s = s + e.genHTML(indentation + 3);
			s = s + "\n";
		}
		s = s + space;
		s = s + super.getEndTag();
		return s;
	}

}
