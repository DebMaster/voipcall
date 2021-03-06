package call.debug;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import call.AbstractId;
import call.CallPlayer;
import call.ContactList;
import call.UnknownDefaultValueException;

public class TestFileLoad extends AbstractId {
	public static void main(String[] args) {
		new TestFileLoad();
	}

	public TestFileLoad() {
		try {
			InputStream is = new FileInputStream(new File("test.pcm"));
			new Thread(new CallPlayer(ContactList.me(), new BufferedInputStream(is), null, 8096)).start();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException | UnknownDefaultValueException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getId() {
		return "TestFileLoad";
	}
}
