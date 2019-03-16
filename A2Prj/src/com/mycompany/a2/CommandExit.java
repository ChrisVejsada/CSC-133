package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class CommandExit extends Command {
    private GameWorld gw;

    /**
     * Constructor for exit
     * @param gw
     */
    public CommandExit(GameWorld gw){
        super("Exit");
        this.gw = gw;
    }
    @Override
    public void actionPerformed(ActionEvent ev){
        gw.exit();
        Command no = new Command("No");
        Command yes = new Command("Yes");

        Label label1 = new Label("");

        Command c = Dialog.show("Do you want to exit?", label1, yes,no);

        if(c == yes){
            gw.quitGame();
        }
        else if (c == no){
            gw.dontQuit();
        }
    }
}
