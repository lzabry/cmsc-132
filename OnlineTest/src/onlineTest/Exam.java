package onlineTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;
	int examId;
	String title;
	TreeMap<Integer, Question> QuestionMap;

	public Exam(int examId, String title) {
		this.examId = examId;
		this.title = title;
		QuestionMap = new TreeMap<Integer, Question>();
	}

	public void addTrueFalseQuestion(int questionNumber, String text, double points, boolean answers) {
		this.QuestionMap.put(questionNumber, new TrueFalseQuestion(questionNumber, text, points, answers));
	}

	public void addMultipleChoiceQuestion(int questionNumber, String text, double points, String[] answers) {
		this.QuestionMap.put(questionNumber, new MultipleChoiceQuestion(questionNumber, text, points, answers));
	}

	public void addFillInTheBlanksQuestion(int questionNumber, String text, double points, String[] answers) {
		this.QuestionMap.put(questionNumber, new FillInTheBlanksQuestion(questionNumber, text, points, answers));
	}

	public String getKey() {
		TreeSet<Integer> a = new TreeSet<Integer>(QuestionMap.keySet());
		String s = "";
		for (int i : a) {
			s += QuestionMap.get(i).getKey();
			s += "\n";
		}
		return s;

	}

}
