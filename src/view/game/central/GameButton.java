package view.game.central;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import utilis.ImageMethod;
import utilis.ImageModifier;

public class GameButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1384166202851332499L;

	public GameButton() {
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageModifier.scale(ImageMethod.getImage("room/Button.png"), getSize()), 0, 0, null);

	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	

}
