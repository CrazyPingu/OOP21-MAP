package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.frame.BasicFrame;

public class MainMenuAction implements ActionListener {

    private BasicFrame frame;

    public MainMenuAction(BasicFrame frame){
        this.frame = frame;
    }
    
    public void actionPerformed(ActionEvent e) {
        frame.showInFrame("Main Menu");    
    }
}
