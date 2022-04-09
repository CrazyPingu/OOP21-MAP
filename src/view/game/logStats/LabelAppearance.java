package view.game.logStats;

import java.awt.*;
import javax.swing.*;

public class LabelAppareance extends JLabel {
	
	private static final long serialVersionUID = 7460837470380147330L;

	/**
	 * Sets the appearance of stats and log labels
	 */
	public void setAppearance () {
		this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("arial", Font.PLAIN, 20));
	}
}
