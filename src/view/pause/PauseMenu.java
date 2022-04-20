package view.pause;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import utilis.Constant;
import utilis.ImageMethod;
import utilis.ImageModifier;
import view.frame.BasicFrame;
import view.pause.action.MainMenuAction;
import view.pause.action.NewGameAction;
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
    Image image;

    /**
     * 
     * @param frame : the frame passed in input, change the screen using buttons
     */
    public PauseMenu(BasicFrame frame) {
    
        image = ImageMethod.getImage("pause/Background.jpg");
        JButton resume = createJB("Resume");
        JButton mainmenu = createJB("Main Menu");
        JButton quit = createJB("Quit");
        JLabel pausetext = labeltext("Pause Menu");

        this.setLayout(new GridBagLayout());
//        this.add(pausetext, setButtonPosition(0, Constant.horizontalAspectRatio(70), Constant.verticalAspectRatio(30)));
//        this.add(resume, setButtonPosition(1, Constant.horizontalAspectRatio(30), Constant.verticalAspectRatio(30)));
//        this.add(mainmenu, setButtonPosition(3, Constant.horizontalAspectRatio(30), Constant.verticalAspectRatio(30)));
//        this.add(quit, setButtonPosition(4, Constant.horizontalAspectRatio(30), Constant.verticalAspectRatio(30)));    
        resume.addActionListener(new ResumeAction(frame));
        mainmenu.addActionListener(new MainMenuAction(frame));
        quit.addActionListener(new QuitAction());
        
    }

    /**
     * 
     * @param name : the string that button will contain
     * @return the button created
     */
    private JButton createJB(String name) {
        JButton temp = new JButton(name);
        temp.setFont(Constant.genericFont("Tahoma", Font.PLAIN, Constant.horizontalAspectRatio(40)));
        temp.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150)));
        temp.setBackground(new Color(197, 199, 196));
        temp.setBorder(
                BorderFactory.createLineBorder(new Color(67, 59, 103), Constant.horizontalAspectRatio(10), false));
        return temp;
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
//        
//    private GridBagConstraints setButtonPosition(int gridy, int topPad, int botPad) {
//        GridBagConstraints a = new GridBagConstraints();
//        topPad = Constant.verticalAspectRatio(topPad);
//        botPad = Constant.verticalAspectRatio(botPad);
//        a.gridy = gridy;
//        a.insets = new Insets(topPad, 0, botPad, 0);
//        return a;
//    }

    /**
     * {@inheritDoc}
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageModifier.scaleFullScreen(image), 0, 0, null);
    }

}
