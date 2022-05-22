package view.main_menu;

import java.awt.*;
import javax.swing.*;

import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import view.MenuButton;
import view.pause.action.QuitAction;


public class MainMenu extends JPanel {
	
    private static final long serialVersionUID = 8006565750742104587L;

	private final int BUTTON_WIDTH = 200;
	private final int BUTTON_HEIGHT = 70;
	
	/**
	 * 
	 * @param frame : the frame passed in input, change the screen using buttons
	 */
	public MainMenu(PageController controller) {

		JLabel mainMenuLabel = labeltext("Main Menu");
		MenuButton newGame = new MenuButton("New Game", 40);
		MenuButton quit = new MenuButton("Quit", 40);

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

    /**
     * 
     * @param name : the string that label will show
     * @return the label with string passed
     */
    private JLabel labeltext(String name) {
        JLabel pause = new JLabel(name, SwingConstants.CENTER);
        pause.setForeground(Color.white);
        pause.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(500), Constant.verticalAspectRatio(100)));
        pause.setFont(Constant.genericFont("Arial", Font.PLAIN, Constant.horizontalAspectRatio(80)));
        return pause;
    }

}

