package southparktriviamaze;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class SpecialEffects {

	public static int successCount = 0;
	public static int failureCount = 0;
	public static boolean censored;
	
	public SpecialEffects(String[] args)
	{
		if(args[0] != null && args[0].equals("censored"))
			censored = true;
		else 
			censored = false;
	}
	
	public Scene createScene(MediaPair fx)
	{
		final StackPane layout = new StackPane();
		final File file = getFile(fx);
		try {
			
			final URL url = file.toURI().toURL();
			final Media mediaByte = new Media(url.toString());
			final MediaPlayer player = new MediaPlayer(mediaByte);
			final MediaView view = new MediaView(player);
			player.play();
			layout.getChildren().add(view);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Scene(layout);
	}

	private File getFile(MediaPair fx) 
	{
		switch(fx.character)
		{
			case Narrator: return getSong(fx.media);
				
			case Others: return getOtherSound();
				
			default: return getSound(fx.media);
		}
	}

	private File getSound(MediaType media) {
		File sound;
		if(!censored)
		{
			switch(media)
			{
			case Success: sound = new File(successSounds[successCount]);
				successCount = (successCount + 1) % successSounds.length;
				break;
			case Failure: sound = new File(failureSounds[failureCount]);
				failureCount = (failureCount + 1) % failureSounds.length;
				break;
			default: sound = null;
			}
		}
		else
		{
			switch(media)
			{
			case Success: sound = new File(successSoundsCensored[successCount]);
				successCount = (successCount + 1) % successSoundsCensored.length;
				break;
			case Failure: sound = new File(failureSoundsCensored[failureCount]);
				failureCount = (failureCount + 1) % failureSoundsCensored.length;
				break;
			default: sound = null;
			}
		}
		return sound;
	}

	private  File getSong(MediaType media) {
		File sound;
		sound = new File("Alert.mp3");
		return sound;
	}

	private  File getOtherSound() {
		// TODO Auto-generated method stub
		return null;
	}
	private static String[] successSounds =
	{
		"GeneralSuccess.mp3",
		"GeneralSuccess2.mp3",
		"ButtersSuccess2.mp3",
		"ButtersSuccess.mp3",
		"CartmanSuccess.mp3",
		"BRAINKEEPSJACKINGOFFcm.mp3"
		
	};
	private static String[] successSoundsCensored =
	{
		"GeneralSuccess.mp3",
		//"GeneralSuccess2.mp3",
		"ButtersSuccess2.mp3",
		"ButtersSuccess.mp3",
		//"CartmanSuccess.mp3",
		//"BRAINKEEPSJACKINGOFFcm.mp3"
			
	};
	private static String[] failureSounds =
	{
		"GeneralFailure.mp3",
		"GeneralFail.mp3",
		"KyleFail.mp3",
		"KyleFail2.mp3",
		"CartmanFailure.mp3",
		"ButtersFailure.mp3",
		"ButtersFailure2.mp3",
		"StanFails.mp3",
		"FailSOB.mp3",
	};
	private static String[] failureSoundsCensored =
	{
		"GeneralFail.mp3",
		"KyleFail.mp3",
		//"KyleFail2.mp3",
		//"CartmanFailure.mp3",
		"ButtersFailure.mp3",
		"ButtersFailure2.mp3",
		"StanFails.mp3",
		//"FailSOB.mp3",
	};
}
