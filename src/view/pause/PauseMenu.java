package view.pause;

import java.awt.*;
import javax.swing.*;

import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import utilities.ImageMethod;
import utilities.ImageModifier;
import view.MenuButton;
import view.pause.action.MainMenuAction;
import view.pause.action.QuitAction;
import view.pause.action.ResumeAction;

/**
 * 
 * PauseMenu is a class that is used to implement the pause menu himself. Here
 * we can find four buttons: Resume, New Game, Main Menu and Quit.
 *
 */

public class PauseMenu extends JPanel {

    private static final long serialVersionUID = 8006565750742104587L;
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 70;
    Image image;

    /**
     * 
     * @param frame : the frame passed in input, change the screen using buttons
     */
    public PauseMenu(final PageController controller) {
    
        image = ImageMethod.getImage("pause/Background.jpg");
        final MenuButton resume = new MenuButton("Resume", 40);
        final MenuButton mainmenu = new MenuButton("Main Menu", 40);
        final MenuButton quit = new MenuButton("Quit", 40);
        final JLabel pausetext = labeltext("Pause Menu");

        this.setLayout(new GridBagLayout());
        
                resume.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
                mainmenu.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
                quit.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
                
        this.add(pausetext, new GbcDimension(0, 1, BUTTON_WIDTH, BUTTON_HEIGHT));
        this.add(resume, new GbcDimension(0, 2, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));
        this.add(mainmenu, new GbcDimension(0, 3, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));
        this.add(quit, new GbcDimension(0, 4, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(40, 0, 0, 0)));
        
        resume.addActionListener(new ResumeAction(controller));
        mainmenu.addActionListener(new MainMenuAction(controller));
        quit.addActionListener(new QuitAction(controller));
        
    }

    /**
     * 
     * @param name : the string that label will show
     * @return the label with string passed
     */
    private JLabel labeltext(final String name) {
        final JLabel pause = new JLabel(name, SwingConstants.CENTER);
        pause.setForeground(Color.white);
        pause.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(500), Constant.verticalAspectRatio(100)));
        pause.setFont(Constant.genericFont("Arial", Font.PLAIN, Constant.horizontalAspectRatio(80)));
        return pause;
    }

    /**
     * {@inheritDoc}
     */
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageModifier.scaleFullScreen(image), 0, 0, null);
    }

}
