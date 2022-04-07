package view.pause;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import utilis.Constant;
import utilis.ImageModifier;
import view.frame.BasicFrame;
import view.pause.action.MainMenuAction;
import view.pause.action.NewGameAction;
import view.pause.action.QuitAction;
import view.pause.action.ResumeAction;

public class PauseMenu extends JPanel{

    private static final long serialVersionUID = 8006565750742104587L;
    Image image;

    public PauseMenu(BasicFrame frame) {
        try {
            image = ImageIO.read(getClass().getResource("/resources/pause/Background.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        JButton resume = createJB("Resume");
        JButton newgame = createJB("New Game");
        JButton mainmenu = createJB("Main Menu");
        JButton quit = createJB("Quit");
        JLabel pausetext = labeltext("Pause Menu");

        this.setLayout(new GridBagLayout());
        this.add(pausetext, setButtonPosition(0, 70, 30));
        this.add(resume, setButtonPosition(1, 30, 30));
        this.add(newgame, setButtonPosition(2, 30, 30));
        this.add(mainmenu, setButtonPosition(3, 30, 30));
        this.add(quit, setButtonPosition(4, 30, 30));
        resume.addActionListener(new ResumeAction(frame));
        newgame.addActionListener(new NewGameAction(frame));
        mainmenu.addActionListener(new MainMenuAction(frame));
        quit.addActionListener(new QuitAction());
        

    }

    private JButton createJB(String name) {
        JButton temp = new JButton(name);
        temp.setFont(Constant.genericFont("Tahoma", Font.PLAIN, Constant.horizontalAspectRatio(40)));
        temp.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150)));
        temp.setBackground(new Color(197, 199, 196));
        temp.setBorder(
                BorderFactory.createLineBorder(new Color(67, 59, 103), Constant.horizontalAspectRatio(10), false));
        return temp;
    }

    private JLabel labeltext(String name) {
        JLabel pause = new JLabel(name, SwingConstants.CENTER);
        pause.setForeground(Color.white);
        pause.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(500), Constant.verticalAspectRatio(100)));
        pause.setFont(Constant.genericFont("Arial", Font.PLAIN, Constant.horizontalAspectRatio(80)));
        return pause;
    }

    private GridBagConstraints setButtonPosition(int gridy, int topPad, int botPad) {
        GridBagConstraints a = new GridBagConstraints();
        topPad = Constant.verticalAspectRatio(topPad);
        botPad = Constant.verticalAspectRatio(botPad);
        a.gridy = gridy;
        a.insets = new Insets(topPad, 0, botPad, 0);
        return a;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageModifier.scaleFullScreen(image), 0, 0, null);
    }

}
