package onlineTest;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeMap;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String name;
	private Database database;
	TreeMap<Integer, TreeMap<Integer, Object>> answer;

	public Student(String name, Database database) {
		this.name = name;
		this.database = database;
		this.answer = new TreeMap<Integer, TreeMap<Integer, Object>>();

	}

	public TreeMap<Integer, Object> specificanswer(int ExamId) {
		return answer.get(ExamId);
	}

	public int examcount() {
		int k = 0;
		Set<Integer> s = database.exams.keySet();
		for (int i : s) {
			k++;
		}
		return k;

	}

	public double getCourseNumericGrade(String studentName) {
		double score = 0.0;
		int count = 0;
		Student student = database.students.get(studentName);
		Set<Integer> s = database.exams.keySet();
		for (int i : s) {
			score += (double) database.getExamScore(studentName, i) / (double) database.getAllScore(i);
		}
		return (double) score * 100.00 / (double) examcount();
	}

	public String getCourseLetterGrade(String studentName) {
		double score = getCourseNumericGrade(studentName);
		for (int i = 0; i < database.cutoffs.length; i++) {
			if (score >= database.cutoffs[i]) {
				return database.LetterGrades[i];
			}
		}
		return database.LetterGrades[database.LetterGrades.length - 1];
	}
}
