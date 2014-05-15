package southparktriviamaze;

import java.sql.ResultSet;


public interface SQLProxy {

	public ResultSet getRandomQuestion();
	public ResultSet getRandomQuestion(String category);
	
}

