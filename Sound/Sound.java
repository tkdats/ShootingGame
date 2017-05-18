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
		  // Windows�ł������Ƃ��̏���
		} else if(osname.indexOf("Linux")>=0){
			filename="./"+filename;
		  // Linux�ł������Ƃ��̏���
		} else if(osname.indexOf("Mac")>=0){
		  // MacOS�ł������Ƃ��̏���
		} else {
		  // ���̑��̊��������Ƃ��̏���
		}
		String path = new File(".").getAbsoluteFile().getParent();
		Clip sc;
		if (!map.containsKey(filename)) {
			map.put(filename, getClip(filename));
		}
		sc = map.get(filename);

		sc.setFramePosition(0); // �����߂�
		sc.start(); // �Đ�
	}
}
