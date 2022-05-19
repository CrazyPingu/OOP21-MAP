package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;

public class SkipAction implements ActionListener {
    ActionMenuController menucontroller;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     */
    public SkipAction(ActionMenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    /**
     * Call skip method in ActionMenuController
     */
    public void actionPerformed(ActionEvent e) {
        menucontroller.skip();
    }

}
