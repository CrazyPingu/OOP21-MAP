package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import utilities.Constant;

public class MenuButton extends JButton {

    private static final long serialVersionUID = -8929834616886633143L;

    public MenuButton(final String text, final int font) {
        super(text);
        this.setFont(Constant.genericFont("Tahoma", Font.PLAIN, font));
        this.setBackground(new Color(197, 199, 196));
        this.setForeground(Color.BLACK);
        this.setOpaque(true);
        this.setFocusPainted(true);
        this.setBorder(
                BorderFactory.createLineBorder(new Color(67, 59, 103), Constant.horizontalAspectRatio(10), false));
    }

}
