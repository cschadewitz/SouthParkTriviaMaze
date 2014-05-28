//Olin L. Anderson
package southparktriviamaze;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.util.concurrent.CountDownLatch;

import javax.swing.JDialog;


public class QuestionDisplay implements DisplayQuestion{

	int questionNumber = 0;
	String ans=null;
	public boolean askQuestion()
	{
		
//		QuestionFactory questionFactory =new RandomQuestionFactory();
//		Question question = questionFactory.getQuestion();
//		String[] answers = new String[4];
//		question.questions.toString(answers);
//		String answer = doQuestion(question.question, answers[0], answers[1], answers[2], answers[3]);
//		return question.isCorrect(answer);	
		
		//=============================================================================
		//DUMMY QUESTIONS
		//Question question = new Question();
		
		//String answer = doQuestion("WHAT IS UP BUD?", null, null, null, null);
		//String answer = doQuestion("WHAT is your name?", "true", "false", "BO", "BOB");
		String answer = "";
		switch(questionNumber)
		{
			case 0: answer =  doQuestion("Am I flying now, how about now?", "T", "F", null, null);
							  ans = "True";
				break;
			case 1: answer =  doQuestion("What is my name?", "Kenny", "Stan", "Kyle", "Cartman");
							  ans = "Kenny";
				break;
			case 2: answer =  doQuestion("I have a super power?", "T", "F", null, null);
							  ans = "True";
				break;
			case 3: answer =  doQuestion("What is Cartman's alter-ego?", null, null, null, null);
							  ans = "The Coon";
				break;
			case 4: answer =  doQuestion("What is my alter-ego", null, null, null, null);
							  ans = "Mysterion";
				break;
		}
		
		questionNumber = (questionNumber % 5) + 1;
		//System.out.println(answer);
		
		///////////////////============================================================

		System.out.println(answer);
		
		//return(question.isCorrect(answer));
		
		if(answer.toLowerCase().compareTo(ans.toLowerCase()) == 0 || answer.compareTo("AlphaOmega") == 0)
		{
			return true;
		}
		return false;
	}
	

	
	public String doQuestion(String ques, String ans1, String ans2, String ans3, String ans4)
	{
	String answer = null;

	if(ans1 == null)
	{
			try 
			{
				QuestionDispShort dialog = new QuestionDispShort(ques);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
				dialog.setModal(true);
				dialog.setVisible(true);
				answer = dialog.getAns();
				dialog.dispose();
			} 
			catch (Exception e)	
			{
				e.printStackTrace();
			}

	}
	
	else if(ans3 == null)
	{
		
		try {
			QuestionDispTF dialog = new QuestionDispTF(ques);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
			dialog.setModal(true);
			dialog.setVisible(true);
			answer = dialog.getAns();
			dialog.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	else
	{
		try {
			QuestionDispMult dialog = new QuestionDispMult(ques, ans1, ans2, ans3, ans4);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
			dialog.setModal(true);
			dialog.setVisible(true);
			answer = dialog.getAns();
			dialog.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	return answer;
	}
}
