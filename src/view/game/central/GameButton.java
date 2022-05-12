package view.game.central;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import logics.game_object.GameObject;
import utilities.ImageMethod;
import utilities.Pair;

/**
 * 
 * Class to manage the single button of the GameArea
 *
 */
public class GameButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1384166202851332499L;
	private Graphics2D g2;
	private GameArea gameArea;
	private JLabel sprite;
	private JLabel strategyLabel;
	private Pair<Integer, Integer> pos;

	public GameButton(GameArea gameArea, Pair<Integer, Integer> pos) {
		this.pos = pos;
		this.gameArea = gameArea;
		sprite = new JLabel("");
		strategyLabel = new JLabel("");
		this.add(strategyLabel);
		strategyLabel.add(sprite);
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
	/**
	 * @return the pos of the button in the room
	 */
	public Pair<Integer, Integer> getPos(){
		return this.pos;
	}

}
