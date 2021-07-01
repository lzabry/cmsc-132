package onlineTest;

import java.io.Serializable;

public class Question<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int questionNumber;
	protected String text;
	protected double points;
	protected T answer;

	public Question(int questionNumber, String text, double points, T answer) {
		this.questionNumber = questionNumber;
		this.text = text;
		this.points = points;
		this.answer = answer;
	}

	public String getKey1() {
		String a = "";
		a += "Question Text: ";
		a += this.text;
		a += "\n";
		a += "Points: ";
		a += this.points;
		a += "\n";
		a += "Correct Answer: ";
		return a;
	}

	public String getKey() {
		return "";
	}

	public double gradequestion(Object studentanswer) {
		return 0.0;
	}

}
