package view.main_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.PageController;

public class NewGameAction implements ActionListener {

	private PageController pageController; 
	
	public NewGameAction(PageController pageController) {
		this.pageController = pageController; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.pageController.startGame();
		
	}

}
