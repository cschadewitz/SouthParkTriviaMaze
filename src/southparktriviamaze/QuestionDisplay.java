package southparktriviamaze;

public class QuestionDisplay /*implements DisplayQuestion*/{
	

	public static Boolean askQuestion()
	{
//		QuestionFactory questionFactory =new RandomQuestionFactory();
//		Question question = questionFactory.getQuestion();
		
		
		String answer =  doQuestion("am i flying now, how about now", "T", "F", null, null);
		//System.out.println(answer);
		if(answer.compareTo("TRUE") == 0)
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
	
	
	private static String doQuestion(String ques, String ans1, String ans2, String ans3, String ans4)
	{
	String question = ques;
	String answer = null;
	String answer1 = ans1;
	String answer2 = ans2;
	String answer3 = ans3;
	String answer4 = ans4;
	String finalAnswer = "";
	boolean answerCorectness = false;
	
	if(answer1 == null)
	{
	//	QuestionDisplayShort shortAnswer =new QuestionDisplayShort(question);
	}
	else if(answer3 == null)
	{
		try {
			QuestionDisplayTF frame = new QuestionDisplayTF(question);
			
			frame.setVisible(true);
			
			answer = frame.getAns();
			//System.out.println("Got the answer " + answer);
			frame.setVisible(false);
			return answer;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	else
	{
	//	QuestionDisplayMult multChoice =new QuestionDisplayMult(question, answer1, answer2, answer3, answer4);
	}
	return answer;
//	return answerCorectness;
	}

}

