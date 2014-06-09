package southparktriviamaze;

import java.io.File;
import java.net.*;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Sounds extends Application {
	public static class MediaPair
	{
		public static Character character;
		public static MediaType media;
	}
	
	private static MediaPlayer player;
	private static Media mediaByte;
	
	
	public static void PreLaunch(Character character, MediaType media)
	{
		
		MediaPair.character = character;
		MediaPair.media = media;
		launch(new String[]{});
	}
	public void playMedia(Character character, MediaType media)
	{
		switch(character)
		{
		case Kenny: playKennySound(media);
			break;
		case Kyle: playKyleSound(media);
			break;
		case Stan: playStanSound(media);
			break;
		case Cartman: playCartmanSound(media);
			break;
		case Butters: playButtersSound(media);
			break;
		case Narrator: playVideo(media);
			break;
		case Others: playOtherSound();
		}
		
	}
	private void playOtherSound() {
		// TODO Auto-generated method stub
		
	}
	private void playVideo(MediaType media) {
		// TODO Auto-generated method stub
		
	}
	
	private void playButtersSound(MediaType media) {
		
	}
	private String[][] cartmanSoundPaths =
		{
			{"Resources/CartmanSuccess.mp3", "" },
			{"Resources/CartmanFailure.mp3", "" },
			{"Resources/CartmanNeedFood.mp3", "" }
		};
	private void playCartmanSound(MediaType media) 
	{
		File path;
		URL url;
		switch(media)
		{
			case Success: path = new File("Resources/CartmanSuccess.mp3");
				break;
			case Failure: path = new File("Resources/CartmanFailure.mp3");
				break;
			case Random: path = new File("Resources/CartmanNeedFood.mp3");
				break;
				default: return;
		}
		try {
			url = path.toURI().toURL();
			mediaByte = new Media(url.toString());
			player = new MediaPlayer(mediaByte);
			player.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void playStanSound(MediaType media) {
		File path;
		URL url;
		switch(media)
		{
			case Success: path = new File("Resources/CartmanSuccess.mp3");
				break;
			case Failure: path = new File("Resources/CartmanFailure.mp3");
				break;
			case Random: path = new File("Resources/CartmanNeedFood.mp3");
				break;
				default: return;
		}
		try {
			url = path.toURI().toURL();
			mediaByte = new Media(url.toString());
			player = new MediaPlayer(mediaByte);
			player.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void playKyleSound(MediaType media) {
		File path;
		URL url;
		switch(media)
		{
			case Success: path = new File("Resources/CartmanSuccess.mp3");
				break;
			case Failure: path = new File("Resources/CartmanFailure.mp3");
				break;
			case Random: path = new File("Resources/CartmanNeedFood.mp3");
				break;
				default: return;
		}
		try {
			url = path.toURI().toURL();
			mediaByte = new Media(url.toString());
			player = new MediaPlayer(mediaByte);
			player.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void playKennySound(MediaType media) {
		File path;
		URL url;
		switch(media)
		{
			case Success: path = new File("Resources/CartmanSuccess.mp3");
				break;
			case Failure: path = new File("Resources/CartmanFailure.mp3");
				break;
			case Random: path = new File("Resources/CartmanNeedFood.mp3");
				break;
				default: return;
		}
		try {
			url = path.toURI().toURL();
			mediaByte = new Media(url.toString());
			player = new MediaPlayer(mediaByte);
			player.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void start(Stage stage) throws Exception {
		playMedia(MediaPair.character, MediaPair.media);
		
	}
	
	

}
