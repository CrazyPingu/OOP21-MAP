package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class MainMenuAction implements ActionListener {

    private final PageController controller;

    /**
     * 
     * {@inheritDoc}
     */
    public MainMenuAction(final PageController controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(final ActionEvent e) {
        controller.showMainMenu();
    }
}
