package view.mainMenu;

import java.awt.*;
import javax.swing.*;

import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import view.MenuButton;
import view.pause.action.QuitAction;


public class MainMenu extends JPanel {

    private static final long serialVersionUID = 8006565750742104587L;

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
        
        this.setBackground(Color.black);
        this.setLayout(new GridBagLayout());
        this.add(mainMenuLabel, new GbcDimension(0, GbcDimension.createInsets(70, 0, 30, 0)));
        this.add(newGame, new GbcDimension(1, GbcDimension.createInsets(30, 0, 30, 0)));
        this.add(quit, new GbcDimension(2, GbcDimension.createInsets(30, 0, 30, 0)));
        
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

