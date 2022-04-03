package view;

import java.awt.CardLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 
 * Class to create the frame that will contain the whole GUI using the CardLayout
 * 
 */
public class basicFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	CardLayout cl;
	JPanel panel;
	
	/**
	 * {@inheritDoc}
	 */
	public basicFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		device.setFullScreenWindow(this);
		cl = new CardLayout();
		panel = new JPanel(cl);
		add(panel);
	}
	
	public CardLayout getCardLayout() {
		return this.cl;
	}
	
	public JPanel getJPanel() {
		return this.panel;
	}
}
