package view.game.central;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import utilis.ImageMethod;
/**
 * 
 * Class to manage the single button of the GameArea
 *
 */
public class GameButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1384166202851332499L;
	Graphics2D g2;
	private JLabel sprite;
	
	public GameButton() {
		sprite = new JLabel("");
		this.add(sprite);
	}

	/**
	 * Method to draw the background of the GameButton
	 */
	protected void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.drawImage(ImageMethod.getImage("room/Button.png"), 0, 0, (int) getSize().getWidth(),
				(int) getSize().getHeight(), null);

	}
	
	/**
	 * @param object paints the image of the object
	 */
	public void drawGameObject(GameObject object) {
		sprite = new JLabel(ImageMethod.getImageIcon(object.getImagePath()));
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the label sprite
	 */
	public JLabel getSprite() {
		return sprite;
	}
	
	/**
	 * @param label change the label sprite
	 */
	public void setSprite(JLabel label) {
		this.sprite = label;
	}

}
