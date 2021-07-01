package model;

import java.util.ArrayList;

public class WebPage extends java.lang.Object implements java.lang.Comparable<WebPage> {

	private String title;
	private ArrayList<Element> Items = new ArrayList<Element>();;
	private int list;
	private int paragraph;
	private int table;
	private double utilization = 0.0;

	public WebPage(String title) {
		this.title = title;
		ArrayList<Element> Items = new ArrayList<Element>();
	}

	public int addElement(Element element) {
		Items.add(element);
		if (element instanceof ListElement) {
			list++;
			return ((ListElement) element).getId();
		} else if (element instanceof ParagraphElement) {
			paragraph++;
			return ((ParagraphElement) element).getId();
		} else if (element instanceof TableElement) {
			table++;
			utilization = utilization + ((TableElement) element).getTableUtilization();
			return ((TableElement) element).getId();
		} else if (element instanceof TagElement) {
			return ((TagElement) element).getId();
		} else {
			return -1;
		}

	}

	@Override
	public int compareTo(WebPage webpage) {
		return this.title.compareTo(webpage.title);
	}

	public static void enableId(boolean choice) {
		TagElement.enableId(choice);

	}

	public Element findElem(int id) {
		for (Element e : Items) {
			if (e instanceof TagElement && ((TagElement) e).getId() == id) {
				return e;
			}
		}
		return null;

	}

	public String getWebPageHTML(int indentation) {
		String space = "";
		String s = "<!doctype html>" + "\n";
		s = s + "<html>" + "\n";
		for (int i = 0; i < indentation; i++) {
			space = space + " ";
		}
		s = s + space;
		s = s + "<head>";
		s = s + "\n";
		s = s + space + "   <meta charset=\"utf-8\"/>";
		s = s + "\n";
		s = s + space + "   <title>" + title + "</title>";
		s = s + "\n";
		s = s + space + "</head>";
		s = s + "\n";
		s = s + space + "<body>";
		s = s + "\n";
		if (Items != null && Items.size() != 0) {
			for (Element e : Items) {
				s = s + e.genHTML(indentation);
				s = s + "\n";
			}
		}
		// for (Element e:Items) {
		// s=s+space+e.genHTML(0);
		// }
		s = s + space + "</body>";
		s = s + "\n";
		s = s + "</html>";
		return s;

	}

	public String stats() {
		String s = "";
		s = "List Count: " + String.valueOf(list);
		s = s + "\n";
		s = s + "Paragraph Count: " + String.valueOf(paragraph);
		s = s + "\n";
		s = s + "Table Count: " + String.valueOf(table);
		s = s + "\n";
		s = s + "TableElement Utilization: " + String.valueOf(utilization / ((double) table));
		return s;
	}

	public void writeToFile(String filename, int indentation) {
		Utilities.writeToFile(filename, getWebPageHTML(indentation));
	}

}
