import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;

/** AudioPlayer : permet de lancer du son.
 * @author Bébépilé
 * @version 1.0
 * @package default_package
*/
public class AudioPlayer {

private Player player; 

private String audioFile;

public AudioPlayer(String audioFile) {
	this.audioFile = audioFile;
}

public void start() throws Exception {
	player = Manager.createPlayer(new MediaLocator(audioFile));
	player.addControllerListener(new ControllerListener() {
		public void controllerUpdate(ControllerEvent controllerEvent) {	
			if(controllerEvent instanceof RealizeCompleteEvent) {
				player.start();
			}
			else if (controllerEvent instanceof EndOfMediaEvent) {	
				System.out.println("end of playing : " + audioFile);
			}
		}
	});

	player.realize();
}
public void stop() {
	if(player != null) {
		player.stop();
	}
}
}