import java.io.File;

import lejos.hardware.Sound;

public class RobotProg {

	public static void main(String[] args) {
		File aSound = new File("ASound.wav");
		File bSound = new File("BSound.wav");
		File cSound = new File("CSound.wav");
		Sound.playSample(aSound);
	}

}
