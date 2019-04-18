package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandRightHeading extends Command {

    private GameWorld gw;
    /**
     * Constructor for Right
     * @param gw
     */
    public CommandRightHeading(GameWorld gw){
        super("Right");
        this.gw = gw;
    }
    /**
     * Override for action
     */
    @Override
    public void actionPerformed(ActionEvent ev){
        gw.changeHeading('r');
    }
}