package com.mycompany.a3;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound implements Runnable{

private Media m;
	
	public BGSound(String fileName){
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
			
			m = MediaManager.createMedia(is, "audio/wav", this);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//pause the sound
	public void pause(){
		m.pause();
		}

	//play the sound
	public void play(boolean b){
		if (!b) 
			m.play();
		}
	
	//run the sound
	public void run(){
		m.setTime(0);
		m.play();
	}
}