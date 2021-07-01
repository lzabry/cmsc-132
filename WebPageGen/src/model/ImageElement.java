package model;

public class ImageElement extends TagElement {
	private String imageURL;

	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
		super("img", false, null, attributes);
		this.imageURL = imageURL;
		attributes = Utilities.addAttributes(attributes, "src=\"" + imageURL + "\"");
		attributes = Utilities.addAttributes(attributes, "width=\"" + String.valueOf(width) + "\"");
		attributes = Utilities.addAttributes(attributes, "height=\"" + Integer.toString(height) + "\"");
		attributes = Utilities.addAttributes(attributes, "alt=\"" + alt + "\"");
		super.setAttributes(attributes);
	}

	public String getImageURL() {
		return imageURL;
	}
}
