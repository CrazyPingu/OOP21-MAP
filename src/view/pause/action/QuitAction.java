package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitAction implements ActionListener{
    
    
    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
