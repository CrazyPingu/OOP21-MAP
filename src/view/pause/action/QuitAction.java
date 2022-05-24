package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class QuitAction implements ActionListener {

    PageController controller;

    public QuitAction(final PageController controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(final ActionEvent e) {
        controller.quitGame();
    }
}
