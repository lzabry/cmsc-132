package model;

public class HeadingElement extends TagElement {

	public HeadingElement(Element content, int level, String attributes) {
		super("h" + String.valueOf(level), true, content, attributes);
	}
}
