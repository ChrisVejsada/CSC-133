package com.mycompany.a3;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound {
private Media m;
	
	public Sound(String fileName, String type){
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
			
			m = MediaManager.createMedia(is, type);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void pause(){m.pause();}
	public void play(){m.play();}
}