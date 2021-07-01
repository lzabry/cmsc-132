package onlineTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Database implements Serializable {
	private static final long serialVersionUID = 1L;

	TreeMap<Integer, Exam> exams;
	TreeMap<String, Student> students;
	String[] LetterGrades;
	double[] cutoffs;

	public Database() {
		exams = new TreeMap<Integer, Exam>();
		students = new TreeMap<String, Student>();
	}

	public TreeMap getExams() {
		return exams;
	}

	public void answerQuestion(String studentname, int examId, int questionnumber, Object answer) {
		TreeMap<Integer, Object> c = new TreeMap<Integer, Object>();
		c.put(questionnumber, answer);

		if (!students.get(studentname).answer.containsKey(examId)) {
			students.get(studentname).answer.put(examId, c);
		} else {
			students.get(studentname).answer.get(examId).put(questionnumber, answer);
		}

	}

	public double getExamScore(String studentName, int examId) {
		Student student2 = students.get(studentName);
		Exam exam = exams.get(examId);
		double score = 0.0;
		TreeMap<Integer, Object> a = (TreeMap<Integer, Object>) student2.answer.get(examId);
		Set<Integer> k = a.keySet();
		for (int i : k) {
			score += exam.QuestionMap.get(i).gradequestion(a.get(i));
		}
		return score;
	}

	public String getGradingReport(String studentName, int examId) {
		double sc = 0.0;
		double e = 0.0;
		String s = "";
		Student student1 = students.get(studentName);
		Exam exam1 = exams.get(examId);
		TreeMap<Integer, Object> examanswer = student1.answer.get(examId);
		TreeSet<Integer> t = new TreeSet<Integer>(examanswer.keySet());
		for (int i : t) {
			s += "Question #";
			s += i;
			s += " ";
			s += exam1.QuestionMap.get(i).gradequestion(examanswer.get(i));
			sc += exam1.QuestionMap.get(i).gradequestion(examanswer.get(i));
			s += " points out of ";
			s += exam1.QuestionMap.get(i).points;
			e += exam1.QuestionMap.get(i).points;
			s += "\n";
		}
		s += "Final Score: " + sc + " out of " + e;
		return s;
	}

	public void setLetterGradesCutoffs(String[] letterGrades, double[] cutoffs) {
		this.LetterGrades = letterGrades;
		this.cutoffs = cutoffs;
	}

	public double getAllScore(int ExamId) {
		double total = 0.0;
		Exam exam = exams.get(ExamId);
		Set<Integer> s = exam.QuestionMap.keySet();
		for (int i : s) {
			total += exam.QuestionMap.get(i).points;
		}
		return total;

	}

	public int examcount() {
		int k = 0;
		Set<Integer> s = exams.keySet();
		for (int i : s) {
			k++;
		}
		return k;

	}

	public double getCourseNumericGrade(String studentName) {
		double score = 0.0;
		int count = 0;
		Student student = students.get(studentName);
		Set<Integer> s = exams.keySet();
		for (int i : s) {
			score += (double) getExamScore(studentName, i) / (double) getAllScore(i);
		}
		return (double) score * 100.00 / (double) examcount();
	}

	public String getCourseLetterGrade(String studentName) {
		double score = getCourseNumericGrade(studentName);
		for (int i = 0; i < cutoffs.length; i++) {
			if (score >= cutoffs[i]) {
				return LetterGrades[i];
			}
		}
		return LetterGrades[LetterGrades.length - 1];
	}

	public String getCourseGrades() {
		String s = "";
		for (Student student : students.values()) {
			s += student.name + " " + student.getCourseNumericGrade(student.name) + " "
					+ student.getCourseLetterGrade(student.name) + "\n";
		}
		return s;
	}

	public double getMaxScore(int examId) {
		double score = 0.0;
		for (Student student : students.values()) {
			if (getExamScore(student.name, examId) > score) {
				score = getExamScore(student.name, examId);
			}
		}
		return score;
	}

	public double getMinScore(int examId) {
		double score = 300.0;
		for (Student student : students.values()) {
			if (getExamScore(student.name, examId) < score) {
				score = getExamScore(student.name, examId);
			}
		}
		return score;
	}

	public double getAverageScore(int examId) {
		double score = 0.0;
		double count = 0.0;
		for (Student student : students.values()) {
			score += getExamScore(student.name, examId);
			count++;
		}
		return (double) score / (double) count;
	}

}
