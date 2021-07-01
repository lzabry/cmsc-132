package cmdLineInterpreter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import onlineTest.SystemManager;

/**
 * 
 * By running the main method of this class we will be able to execute commands
 * associated with the SystemManager. This command interpreter is text based.
 *
 */
public class Interpreter {

	public static void main(String[] args) throws Exception {
		int i = 0;
		int j = 0;
		String k = "";
		SystemManager manager = new SystemManager();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Weclome to the system");

		do {
			System.out.println("Here is the Menu:");
			System.out.println("enter 1 to Add a student");
			System.out.println("enter 2 to Add an exam");
			System.out.println("enter 3 to Add a true and false question");
			System.out.println("enter 4 to answer a true and false question");
			System.out.println("enter 5 to get the exam score for a student");
			System.out.println("enter 6 to quit");
			k = scanner.next();
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
			j = Integer.parseInt(k);

			if (j == 1) {
				System.out.println("enter student's name here: ");
				String s = scanner.nextLine();
				manager.addStudent(s);
			} else if (j == 2) {
				System.out.println("enter exam's id here: ");
				int s = Integer.parseInt(scanner.nextLine());
				System.out.println("enter exam's title here: ");
				String s2 = scanner.nextLine();
				manager.addExam(s, s2);

			} else if (j == 3) {
				System.out.println("enter exam's id here: ");
				int examId = Integer.parseInt(scanner.nextLine());
				System.out.println("enter question number here: ");
				int questionnumber = Integer.parseInt(scanner.nextLine());
				System.out.println("enter question text here: ");
				String text = scanner.nextLine();
				System.out.println("enter question points here: ");
				double points = Double.parseDouble(scanner.nextLine());
				System.out.println("enter question answer here: ");
				boolean answer = Boolean.parseBoolean(scanner.nextLine());
				manager.addTrueFalseQuestion(examId, questionnumber, text, points, answer);

			} else if (j == 4) {
				System.out.println("enter student's name here: ");
				String studentName = scanner.nextLine();
				System.out.println("enter exam id here: ");
				int examId = Integer.parseInt(scanner.nextLine());
				System.out.println("enter question number here: ");
				int questionNumber = Integer.parseInt(scanner.nextLine());
				System.out.println("enter answer here: ");
				boolean answer = Boolean.parseBoolean(scanner.nextLine());
				manager.answerTrueFalseQuestion(studentName, examId, questionNumber, answer);

			} else if (j == 5) {
				System.out.println("enter student's name here: ");
				String studentName = scanner.nextLine();
				System.out.println("enter exam id here: ");
				int examId =Integer.parseInt(scanner.nextLine());
				System.out.println("Score is: ");
				System.out.println(manager.getExamScore(studentName, examId));

			} else if (j == 6) {
				System.out.print("You have exited the system");
				scanner.close();
				break;
			}
		} while (j != 6);
         saveManager(manager);
	}
	
	
	private static void saveManager(SystemManager systemmanager) throws Exception {
		File file=new File("manager.info");
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(systemmanager);
		oos.close();
		
		
		
		
	}
	
	
	
}
