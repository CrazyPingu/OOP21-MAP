package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class PauseAction implements ActionListener {
    PageController controller;

    /**
     * 
     * @param controller : the PageController
     */
    public PauseAction(PageController controller) {
        this.controller = controller;
    }

    /**
     * Call showPauseMenu method in PageController
     */
    public void actionPerformed(ActionEvent e) {
        controller.showPauseMenu();
    }

}
