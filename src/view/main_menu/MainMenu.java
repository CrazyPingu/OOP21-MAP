package view.main_menu;

import java.awt.*;
import javax.swing.*;

import controller.PageController;
import utilities.GbcDimension;
import view.MenuButton;
import view.MenuLabel;
import view.pause.action.QuitAction;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 8006565750742104587L;

	private static final int BUTTON_WIDTH = 200;
	private static final int BUTTON_HEIGHT = 70;

	/**
	 * 
	 * @param frame : the frame passed in input, change the screen using buttons
	 */
	public MainMenu(final PageController controller) {

		final JLabel mainMenuLabel = new MenuLabel("Main Menu");
		final MenuButton newGame = new MenuButton("New Game", 40);
		final MenuButton quit = new MenuButton("Quit", 40);

		newGame.addActionListener(new NewGameAction(controller));
		quit.addActionListener(new QuitAction(controller));

		newGame.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		quit.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

		this.setBackground(Color.black);
		this.setLayout(new GridBagLayout());
		this.add(mainMenuLabel, new GbcDimension(0, 0, 400, 100));
		this.add(newGame, new GbcDimension(0, 1, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));
		this.add(quit, new GbcDimension(0, 2, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));

	}

}
