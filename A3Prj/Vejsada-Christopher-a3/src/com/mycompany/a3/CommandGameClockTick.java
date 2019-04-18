package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandGameClockTick extends Command {
    private GameWorld gw;

    /**
     * Constuctor for clock
     * @param gw
     */
    public CommandGameClockTick(GameWorld gw){
        super("Tick");
        this.gw = gw;
    }

    /**
     * Override for action
     */
    @Override
    public void actionPerformed(ActionEvent ev){
       // gw.tick();
    }
}
