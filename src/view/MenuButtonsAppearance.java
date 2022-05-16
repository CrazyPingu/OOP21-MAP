package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import utilities.Constant;

public class MenuButtonsAppearance extends JButton {

    private static final long serialVersionUID = -8929834616886633143L;


    public static void SetMenuButtonsAppearance(JButton button) {
        button.setFont(Constant.genericFont("Tahoma", Font.PLAIN, Constant.horizontalAspectRatio(40)));
        button.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(350), Constant.verticalAspectRatio(150)));
        button.setBackground(new Color(197, 199, 196));
        button.setBorder(
                BorderFactory.createLineBorder(new Color(67, 59, 103), Constant.horizontalAspectRatio(10), false));
        
    }

}
