package view.game.logStats;

import java.awt.*;
import javax.swing.*;

import utilis.Constant;

/**
 * 
 * Sets the appearance of stats and log labels
 *
 */

public class LabelAppearance extends JLabel {
	
	private static final long serialVersionUID = 7460837470380147330L;
	
	public void setAppearance () {
		super.setOpaque(true);
		super.setBackground(Color.BLACK);
		super.setForeground(Color.WHITE);
		super.setFont(Constant.genericFont("arial", Font.PLAIN, 20));
	}
}
