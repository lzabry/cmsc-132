package model;

public class AnchorElement extends TagElement {

	private String url;
	private String linkText;

	public AnchorElement(String url, String linkText, String attributes) {
		super("a", true, new TextElement(linkText), attributes);
		if (attributes == null) {
			attributes = "href=\"" + url + "\"";
		} else {
			attributes = "href=\"" + url + "\"" + " " + attributes;
		}
		this.setAttributes(attributes);
		this.url = url;
		this.linkText = linkText;
	}

	public String getLinkText() {
		return linkText;
	}

	public String getUrlText() {
		return url;
	}

}
