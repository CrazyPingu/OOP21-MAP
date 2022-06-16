package view.game.action.action_button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;
/*
 * The action that skip the turn
 */
public class SkipAction implements ActionListener {
    ActionMenuController menucontroller;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     */
    public SkipAction(final ActionMenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        menucontroller.skip();
    }

}
