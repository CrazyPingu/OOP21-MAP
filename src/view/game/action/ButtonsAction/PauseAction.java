package view.game.action.ButtonsAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;
import view.frame.BasicFrame;

public class PauseAction implements ActionListener{
    
public void actionPerformed(ActionEvent e) {
    PageController.showPauseMenu();
}

}
