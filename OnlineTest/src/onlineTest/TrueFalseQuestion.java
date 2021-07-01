package onlineTest;

import java.io.Serializable;


public class TrueFalseQuestion extends Question implements Serializable {
	private static final long serialVersionUID = 1L;

	public TrueFalseQuestion(int questionNumber, String text, double points, boolean answer) {
		super(questionNumber, text, points, answer);

	}

	@Override
	public String getKey() {
		String a = super.getKey1();
		a += answer.toString().substring(0, 1).toUpperCase() + answer.toString().substring(1);
		return a;
	}

	@Override
	public double gradequestion(Object studentanswer) {
		double score = 0.0;

		if ((boolean) studentanswer == (boolean) this.answer) {
			return this.points;
		} else {
			return 0.0;
		}
	}
}