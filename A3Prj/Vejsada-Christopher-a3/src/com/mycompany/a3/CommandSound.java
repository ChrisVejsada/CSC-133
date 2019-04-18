package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.a3.GameWorld;

public class CommandSound extends Command {
	private GameWorld gw;
	/**
	 * constuctor for sound
	 * @param gw
	 */
	public CommandSound(GameWorld gw) {
		super("Sound");
		this.gw = gw;
		
	}
	/**
	 * override for sound
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		gw.toggleSound();
		
	}

}
