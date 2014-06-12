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
	
	public static Scene createScene(MediaPair fx)
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

	private static File getFile(MediaPair fx) 
	{
		switch(fx.character)
		{
			case Narrator: return getVideo(fx.media);
				
			case Others: return getOtherSound();
				
			default: return getSound(fx.media);
		}
	}

	private static File getSound(MediaType media) {
		File sound;
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
		return sound;
	}

	private static File getVideo(MediaType media) {
		// TODO Auto-generated method stub
		return null;
	}

	private static File getOtherSound() {
		// TODO Auto-generated method stub
		return null;
	}
	private static String[] successSounds =
	{
		"Resources/GeneralSuccess.mp3",
		"Resources/GeneralSuccess2.mp3",
		"Resources/ButtersSuccess2.mp3",
		"Resources/ButtersSuccess.mp3",
		"Resources/CartmanSuccess.mp3",
		"Resources/BRAINKEEPSJACKINGOFFcm.mp3"
		
	};
	private static String[] failureSounds =
		{
			"Resources/GeneralFail.mp3",
			"Resources/KyleFail.mp3",
			"Resources/KyleFail2.mp3",
			"Resources/CartmanFailure.mp3",
			"Resources/ButtersFailure.mp3",
			"Resources/ButtersFailure2.mp3",
			"Resources/StanFails.mp3",
			"Resources/FailSOB.mp3",
		};
}
