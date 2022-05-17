package view.pause.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class MainMenuAction implements ActionListener {

    private PageController controller;

    /**
     * 
     * {@inheritDoc}
     */
    public MainMenuAction(PageController controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent e) {
        controller.showMainMenu();
    }
}
