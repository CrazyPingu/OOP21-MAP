package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class PauseAction implements ActionListener{
    PageController controller;
    
    public PauseAction(PageController controller) {
        this.controller = controller;
    }
    
    
public void actionPerformed(ActionEvent e) {
    controller.showPauseMenu();
}

}
