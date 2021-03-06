import javax.sound.sampled.*;
import java.io.*;
import java.util.HashMap;

public class Sound {
	Sound(){

        
	}
	public static HashMap<String, Clip> map = new HashMap<String, Clip>();
	public static Clip getClip(String filename) {
		Clip clip = null;
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filename));
			clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(ais);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		return clip;
	}

	static void play(String filename) {
		String osname = System.getProperty("os.name");
		if(osname.indexOf("Windows")>=0){
		  // Windowsであったときの処理
		} else if(osname.indexOf("Linux")>=0){
			filename="./"+filename;
		  // Linuxであったときの処理
		} else if(osname.indexOf("Mac")>=0){
		  // MacOSであったときの処理
		} else {
		  // その他の環境だったときの処理
		}
		String path = new File(".").getAbsoluteFile().getParent();
		Clip sc;
		if (!map.containsKey(filename)) {
			map.put(filename, getClip(filename));
		}
		sc = map.get(filename);

		sc.setFramePosition(0); // 巻き戻し
		sc.start(); // 再生
	}
}
