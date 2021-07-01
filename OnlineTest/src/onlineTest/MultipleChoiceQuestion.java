package onlineTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MultipleChoiceQuestion extends Question implements Serializable {
	private static final long serialVersionUID = 1L;

	public MultipleChoiceQuestion(int questionNumber, String text, double points, String[] answer) {
		super(questionNumber, text, points, answer);
	}

	@Override
	public String getKey() {
		String[] s = (String[]) answer;
		String a = super.getKey1();
		a += "[";
		for (int i = 0; i < s.length - 1; i++) {
			a += s[i] + ",";
		}
		a += s[s.length - 1];
		a += "]";
		return a;
	}

	@Override
	public double gradequestion(Object studentanswer) {
		String[] studentAnswer = (String[]) studentanswer;
		String[] correctAnswer = (String[]) this.answer;
		if (Arrays.equals(studentAnswer, correctAnswer)) {
			return this.points;
		} else {
			return 0.0;
		}
	}
}
