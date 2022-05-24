package view.main_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class NewGameAction implements ActionListener {

	private final PageController pageController; 
	
	public NewGameAction(final PageController pageController) {
		this.pageController = pageController; 
	}
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		this.pageController.startGame();
		
	}

}
