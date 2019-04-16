package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.*;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;
import com.mycompany.a3.GameWorld;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;


public class CommandPlayPause extends Command{

	private GameWorld gw;
	
	public CommandPlayPause(Gameworld gw)
	{
		super("Pause");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		gw.pausePlay();
	}
}


