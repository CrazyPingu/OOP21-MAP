package view.pause.action;

import view.frame.BasicFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ResumeAction implements ActionListener {
    
    BasicFrame frame;
    
    public ResumeAction(BasicFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        frame.showInFrame("Game");

    }

}
