package view.game.central;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import logics.game_object.GameObject;
import utilities.ImageMethod;
import utilities.ImageModifier;
import utilities.Pair;

/**
 * 
 * Class to manage the single button of the GameArea
 *
 */
public class GameButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1384166202851332499L;
	private JLabel sprite;
	private JLabel strategyLabel;
	private Pair<Integer, Integer> pos;

	public GameButton(Pair<Integer, Integer> pos) {
		this.pos = pos;
		sprite = new JLabel("");
		strategyLabel = new JLabel("");
		this.add(strategyLabel);
		this.addActionListener(this);
		strategyLabel.add(sprite);
	}

	/**
	 * Method to draw the background of the GameButton
	 */
	protected void paintComponent(Graphics g) {
		g.drawImage(ImageModifier.scaleWithDimension(ImageMethod.getImage("room/Button.png"), this.getSize()), 0, 0,
				null);
	}

	/**
	 * @param object paints the image of the object
	 */
	public void drawGameObject(GameObject object) {
		sprite = new JLabel(new ImageIcon(object.getTextureImage()));
	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * TODO Auto-generated method stub Pass gameAreaController, and check flag if is
		 * moving or attacking
		 */
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
	public Pair<Integer, Integer> getPos() {
		return this.pos;
	}
	
	

}
