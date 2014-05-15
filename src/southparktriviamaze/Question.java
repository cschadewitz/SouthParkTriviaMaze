package southparktriviamaze;

import java.util.List;

public interface Question {
	public String getQuestionText();
	public List<String> getChoices();
	public boolean checkAnswer(String choice);
}
