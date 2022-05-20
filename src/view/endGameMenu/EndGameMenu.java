package view.endGameMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JPanel;

import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import utilities.ImageMethod;
import utilities.ImageModifier;
import view.MenuButton;
import view.pause.action.*;

public abstract class EndGameMenu extends JPanel {

    private static final long serialVersionUID = 6789169156087285519L;
    Image image;
    private final int BUTTON_WIDTH =300;
    private final int BUTTON_HEIGHT = 100;

    public EndGameMenu(String imageName, PageController controller) {

        MenuButton mainMenu = new MenuButton("Main Menu", 60);
        MenuButton quit = new MenuButton("Quit", 60);

        this.image = ImageMethod.getImage("endGame/" + imageName + ".png");
        quit.addActionListener(new QuitAction(controller));
        mainMenu.addActionListener(new MainMenuAction(controller));
        this.setLayout(new BorderLayout());

        quit.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        mainMenu.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        JPanel bottom = new JPanel(new GridBagLayout());
        bottom.add(mainMenu,
                new GbcDimension(0, 0, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(0, 0, 0, 100)));
        bottom.add(quit, new GbcDimension(1, 0, BUTTON_WIDTH, BUTTON_HEIGHT, GbcDimension.createInsets(0, 100, 0, 0)));
        this.add(bottom, BorderLayout.SOUTH);
        bottom.setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageModifier.scaleFullScreen(this.image), 0, 0, null);
    }

}
