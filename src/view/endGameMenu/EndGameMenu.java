package view.endGameMenu;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import utilities.ImageMethod;
import utilities.ImageModifier;
import view.MenuButton;
import view.pause.action.*;

public class EndGameMenu extends JPanel {

    private static final long serialVersionUID = 6789169156087285519L;
    PageController controller;
    MenuButton mainMenu = new MenuButton("Main Menu", 40);
    MenuButton quit = new MenuButton("Quit", 40);
    QuitAction quitAction = new QuitAction(controller);
    MainMenuAction mainMenuAction = new MainMenuAction(controller);
    Image image;

    public EndGameMenu(String imageName) {

        this.image = ImageMethod.getImage("endGame/" + imageName + ".png");
        quit.addActionListener(quitAction);
        mainMenu.addActionListener(mainMenuAction);
        this.setLayout(new BorderLayout());

        this.add(mainMenu, new GbcDimension(0, 0, Constant.horizontalAspectRatio(300),
                Constant.verticalAspectRatio(150), GbcDimension.createInsets(0, 0, 0, 100)));
        this.add(quit, new GbcDimension(1, 0, Constant.horizontalAspectRatio(300), Constant.verticalAspectRatio(150),
                GbcDimension.createInsets(0, 100, 0, 0)));
        this.add(this, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageModifier.scaleFullScreen(this.image), 0, 0, null);
    }

}
