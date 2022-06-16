package view.game.action.action_button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ActionMenuController;
/*
 * The attack that make the player move in the game
 */
public class MoveAction implements ActionListener {
    ActionMenuController menucontroller;

    /**
     * 
     * @param menucontroller : the ActionMenuController
     */
    public MoveAction(final ActionMenuController menucontroller) {
        this.menucontroller = menucontroller;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        this.menucontroller.setMove();
    }

}
