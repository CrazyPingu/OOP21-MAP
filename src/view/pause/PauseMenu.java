package view.pause;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import utilis.Constant;
import utilis.ImageModifier;

public class PauseMenu extends JPanel implements ActionListener {

    private static final long serialVersionUID = 8006565750742104587L;
    Image image;
    /*
     * Sarà composto da 4 bottoni: Continue, New Game, Main Menu, Quit Continue :
     * Mostra la CardLayout del Gioco e chiude quella del menu di pausa New Game :
     * Mostra la CardLayout del Gioco ma dall'inizio, perdendo tutti i salvataggi
     * fatti finora Main Menu : Mostrerà il CardLayout del Menù Principale (tutti i
     * salvataggi verranno persi anche in questo caso) Quit : Chiuderà il gioco
     * (System.Exit(0);)
     * 
     */

    public PauseMenu() {
        try {
            image = ImageIO.read(getClass().getResource("/resources/pause/Background.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        // this.setOpaque(false);
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
        quit.addActionListener(this);

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

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageModifier.scaleFullScreen(image), 0, 0, null);
    }

        
}
