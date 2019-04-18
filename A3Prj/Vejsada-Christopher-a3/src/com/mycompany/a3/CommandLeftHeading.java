package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandLeftHeading extends Command {

    private GameWorld gw;
    /**
     * Constructor for left
     * @param gw
     */
    public CommandLeftHeading(GameWorld gw){
        super("Left");
        this.gw = gw;
    }
    /**
     * Override for action
     */
    @Override
    public void actionPerformed(ActionEvent ev){
        gw.changeHeading('l');
    }
}
