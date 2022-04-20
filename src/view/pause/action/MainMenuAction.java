package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.frame.BasicFrame;

public class MainMenuAction implements ActionListener {

    private BasicFrame frame;
    /**
     * 
     * {@inheritDoc}
     */
    public MainMenuAction(BasicFrame frame){
        this.frame = frame;
    }
    
    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent e) {
        frame.showInFrame("MainMenu");    
    }
}
