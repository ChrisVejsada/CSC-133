package com.mycompany.a3;

import java.io.IOException;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound implements Runnable
{
	
	
private Media media;

	public Sound (String fileName, String location) 
	{ 
		try 
		{
		InputStream iStream = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
		media = MediaManager.createMedia(iStream, location, this); 
		}
		
		catch (IOException e) 
		{
		   System.out.println("Cannot Play Sound");
		} 
	}
	
	public void pause()
	{
		media.pause();
	}
	
	public void play()
	{
		media.play();
	}
	
	public void run() 
	{
		media.setTime(0);
		media.play();
	}
}