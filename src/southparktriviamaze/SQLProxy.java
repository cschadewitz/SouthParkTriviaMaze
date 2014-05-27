package southparktriviamaze;


import southparktriviamaze.Question;


public interface SQLProxy {

	public Question getRandomQuestion();
	public Question getRandomQuestion(String category);
	
}

