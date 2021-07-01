package model;

public class TagElement implements Element {

	private String tagName;
	private boolean endTag;
	private Element content;
	private String attributes;
	private static boolean enablestatus = false;
	private int id;
	private static int counter = 1;

	public TagElement(String tagName, boolean endTag, Element content, String attributes) {
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.attributes = attributes;
		this.id = counter;
		TagElement.counter++;
	}

	public static void enableId(boolean choice) {
		enablestatus = choice;
	}

	public String genHTML(int indentation) {
		String s = "";
		for (int i = 0; i < indentation; i++) {
			s = s + " ";
		}
		s = s + this.getStartTag();
		if (this.content != null) {
			s = s + this.content.genHTML(0);
		}
		s = s + this.getEndTag();
		return s;

	}

	public String getEndTag() {
		if (endTag) {
			return "</" + tagName + ">";
		} else {
			return "";
		}
	}

	public int getId() {
		return this.id;
	}

	public String getStartTag() {
		String s = "";
		s = "<" + this.tagName;
		if (enablestatus) {
			s = s + " " + "id=\"" + this.getStringId() + "\"";
		}
		if (attributes != null) {
			s = s + " " + attributes;
		}
		s = s + ">";
		return s;

	}

	public String getStringId() {
		return tagName + String.valueOf(this.id);
	}

	public static void resetIds() {
		counter = 1;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

}
