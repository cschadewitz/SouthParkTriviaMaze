////*
 ///* QuestionDisplay
 ///* Author: Olin L. Anderson
 ///* Revision:2
 ///* Rev. Author: Casey Schadewitz
 ///* Description:
 ///* selects the appropriate Question display class to display the question to the user
 ///* 
 ///*/
package southparktriviamaze;

import java.awt.Dialog;
import javax.swing.JDialog;


public class QuestionDisplay
{	
	
/*
 ///* call the correct class to display the question
 ///* Parameters:
 ///* Question q the question and answer to be displayed
 ///* returns:
 ///* boolean
 ///* throws:
 ///* none
 ///*/
	public boolean doQuestion(Question q)
	{
		String answer = null;
		if(q.getQuestionType() == 2)
		{
			try 
			{
				QuestionDispShort dialog = new QuestionDispShort(q.getQuestionText());
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
		else if(q.getQuestionType() == 1)
		{
			try {
				QuestionDispTF dialog = new QuestionDispTF(q.getQuestionText());
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
		else if(q.getQuestionType() == 0)
		{
			try {
				QuestionDispMult dialog = new QuestionDispMult(q.getQuestionText(), q.getChoices().get(0), q.getChoices().get(1), q.getChoices().get(2), q.getChoices().get(3));
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
		return q.checkAnswer(answer);
	}
	/*
///	 * call the correct class to display the question
///	 * Parameters:
///	 * String ques the question
///	 * String ans1 the first answer
///	 * String ans2 the second answer
///	 * String ans3 the third answer
///	 * String ans4 the fourth answer
///	 * returns:
///	 * String the answer
///	 * throws:
///	 * none
////	 * (non-Javadoc)
///	 * @see southparktriviamaze.DisplayQuestion#doQuestion(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	/// */
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
