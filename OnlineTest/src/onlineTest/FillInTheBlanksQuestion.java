package onlineTest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class FillInTheBlanksQuestion extends Question implements Serializable {
	private static final long serialVersionUID = 1L;

	public FillInTheBlanksQuestion(int questionNumber, String text, double points, String[] answer) {
		super(questionNumber, text, points, answer);
		Arrays.sort(answer);
		this.answer = answer;
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
		int count = 0;
		String[] studentAnswer = (String[]) studentanswer;
		List<String> submitted = Arrays.asList(studentAnswer);
		String[] correctAnswer = (String[]) this.answer;
		List<String> trueanswer = Arrays.asList(correctAnswer);
		for (String s : trueanswer) {
			if (submitted.contains(s)) {
				count++;
			}
		}
		if (count > trueanswer.size()) {
			return this.points;
		} else {
			return this.points * count / trueanswer.size();
		}

	}
}
