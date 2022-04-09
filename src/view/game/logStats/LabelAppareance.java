package view.game.logStats;

import java.awt.*;
import javax.swing.*;

public class LabelAppareance extends JLabel {
	
	private static final long serialVersionUID = 7460837470380147330L;

	/**
	 * Sets the appareance of stats and log labels
	 */
	public void setAppareance () {
		this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("arial", Font.PLAIN, 20));
	}
}
