package view.frame;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utilities.Constant;

/*
 * 
 * Class to create the frame that will contain the whole GUI using the CardLayout
 * 
 */
public class BasicFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout cardLayout;
	JPanel panel;

	/**
	 * {@inheritDoc}
	 */
	public BasicFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		Constant.SCREEN.setFullScreenWindow(this);
		cardLayout = new CardLayout();
		panel = new JPanel(cardLayout);
		panel.setBackground(Color.black);
		add(panel);
	}

	/**
	 * @param cardLayoutName : the name of the CardLayout that will be shown
	 */
	public void showInFrame(String cardLayoutName) {
		this.cardLayout.show(this.panel, cardLayoutName);
	}

	/**
	 * @param panel          : the current panel to add
	 * @param cardLayoutName : the name to give to the CardLayout
	 */
	public void addToCardLayout(JPanel panel, String cardLayoutName) {
		this.panel.add(panel, cardLayoutName);
	}
}
