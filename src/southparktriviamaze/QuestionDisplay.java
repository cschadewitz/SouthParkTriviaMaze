package southparktriviamaze;

public class QuestionDisplay implements DisplayQuestion{
	

	public boolean askQuestion()
	{
//		QuestionFactory questionFactory =new RandomQuestionFactory();
//		Question question = questionFactory.getQuestion();
//		String[] answers = new String[4];
//		question.questions.toString(answers);
//		String answer = doQuestion(question.question, answers[0], answers[1], answers[2], answers[3]);
//		return question.isCorrect(answer);		
		
		//String answer = doQuestion("WHAT IS UP BUD?", null, null, null, null);
		String answer = doQuestion("WHAT is your name?", "TRUE", "FALSE", "BO", "BOB");
		//String answer =  doQuestion("am i flying now, how about now", "T", "F", null, null);
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
	
	
	private String doQuestion(String ques, String ans1, String ans2, String ans3, String ans4)
	{
	String question = ques;
	String answer = null;
	String answer1 = ans1;
	String answer2 = ans2;
	String answer3 = ans3;
	String answer4 = ans4;

	if(answer1 == null)
	{
		try {
			QuestionDisplayShort frame = new QuestionDisplayShort(question);
			frame.setVisible(true);
			
			answer = QuestionDisplayShort.getans();
			QuestionDisplayShort.ansReset();
			frame.setVisible(false);
			frame.removeAll();
			return answer;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	else if(answer3 == null)
	{
		try {
			QuestionDisplayTF frame = new QuestionDisplayTF(question);
			frame.setVisible(true);
			answer = QuestionDisplayTF.getAns();
			QuestionDisplayTF.ansReset();
			
			frame.setVisible(false);
			frame.removeAll();
			return answer;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	else
	{
		try {
			QuestionDisplayMult frame = new QuestionDisplayMult(question, answer1, answer2, answer3, answer4);
			frame.setVisible(true);
			answer = QuestionDisplayMult.getans();
			QuestionDisplayMult.ansReset();
			frame.setVisible(false);
			frame.removeAll();
			return answer;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return answer;
	}
}
