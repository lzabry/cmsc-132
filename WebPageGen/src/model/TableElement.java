package model;

public class TableElement extends TagElement {
	private int rows;
	private int cols;
	private Element[][] units;

	public TableElement(int rows, int cols, String attributes) {
		super("table", true, null, attributes);
		this.rows = rows;
		this.cols = cols;
		this.units = new Element[rows][cols];
	}

	public void addItem(int rowIndex, int colIndex, Element item) {
		this.units[rowIndex][colIndex] = item;
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
		for (int i = 0; i < rows; i++) {
			s = s + space + "   <tr>";
			for (int j = 0; j < cols; j++) {
				if (units[i][j] != null) {
					s = s + "<td>" + units[i][j].genHTML(0) + "</td>";
				} else {
					s = s + "<td></td>";
				}
			}
			s = s + "</tr>" + "\n";
		}
		s = s + space + super.getEndTag();
		return s;
	}

	public double getTableUtilization() {
		double c = 0;
		double total = rows * cols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (units[i][j] != null) {
					c++;
				}
			}
		}
		return (c / total) * 100.00;
	}

}
