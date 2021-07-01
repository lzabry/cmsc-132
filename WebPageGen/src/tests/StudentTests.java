package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AnchorElement;
import model.TableElement;
import model.TagElement;
import model.TextElement;

public class StudentTests {

	@Test
	public void test1() {
		int indentation = 3;
		String answer = "", attributes = "I hate this project";
		
		TagElement.resetIds();
		TagElement.enableId(true);
		AnchorElement element = new AnchorElement("http://www.cs.umd.edu", "UMD", attributes);
		answer += element.genHTML(indentation);
		answer += "\nSecondElement\n";
		
		element = new AnchorElement("http://www.cs.umd.edu", "UMD", attributes);
		answer += element.genHTML(indentation);
		
		answer += "\nThirdElement\n";
		indentation = 6;
		element = new AnchorElement("http://www.cs.umd.edu", "UMD", attributes);;
		answer += element.genHTML(indentation);
		
		System.out.print(answer);
		//assertTrue(TestsSupport.isCorrect("pubAnchorElementTest1.txt", answer));;
	}
	
	@Test
	public void test2() {
		String attributes = "border=\"1\"", answer = "";
		
		TagElement.resetIds();
		TagElement.enableId(true);
		TableElement tableElement = new TableElement(2, 2, attributes);
		tableElement.addItem(0, 0, new TextElement("John"));
		tableElement.addItem(0, 1, new TextElement("Laura"));
		tableElement.addItem(1, 0, new TextElement("Rose"));
		
		answer += tableElement.getTableUtilization();
		System.out.print(answer);
		//assertTrue(TestsSupport.isCorrect("pubAnchorElementTest1.txt", answer));;
	}

}
