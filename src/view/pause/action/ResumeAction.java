package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class ResumeAction implements ActionListener {

    PageController controller;

    /**
     * 
     * {@inheritDoc}
     */
    public ResumeAction(final PageController controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(final ActionEvent e) {
        controller.showGame();

    }

}
