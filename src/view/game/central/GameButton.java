package view.game.central;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import utilis.ImageMethod;

public class GameButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1384166202851332499L;

	public GameButton(String text) {
		super(text);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(ImageMethod.getImage("room/Button.png"), 0, 0, (int) getSize().getWidth(),
				(int) getSize().getHeight(), null);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
