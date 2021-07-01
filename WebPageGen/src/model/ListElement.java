package model;

import java.util.ArrayList;

public class ListElement extends TagElement {
	private boolean ordered;
	private ArrayList<Element> units = new ArrayList<Element>();

	public ListElement(boolean ordered, String attributes) {
		super(ordered ? "ol" : "ul", true, null, attributes);
		this.ordered = ordered;
	}

	public void addItem(Element item) {
		units.add(item);
	}

	public String genHTML(int indentation) {
		String space = "";
		String s = "";
		for (int i = 0; i < indentation; i++) {
			space = space + " ";
		}
		s = s + space;
		s = s + super.getStartTag();
		s = s + "\n";
		for (Element e : this.units) {
			s = s + space + "   <li>";
			s = s + "\n";
			s = s + space + "      " + e.genHTML(0) + "\n";
			s = s + space + "   </li>";
			s = s + "\n";
		}
		s = s + space + super.getEndTag();
		return s;
	}
}
