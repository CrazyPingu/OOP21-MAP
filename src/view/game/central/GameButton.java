package view.game.central;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.GameAreaController;
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
	private Dimension buttonDimension;
	private GameAreaController gameAreaController;
	private Pair<Integer, Integer> pos;

	public GameButton(Dimension buttonDimension, GameAreaController gameAreaController, Pair<Integer, Integer> pos) {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.pos = pos;
		this.gameAreaController = gameAreaController;
		this.buttonDimension = buttonDimension;
		this.setEnabled(false);
		sprite = new JLabel();
		strategyLabel = new JLabel();
		this.addActionListener(this);
		this.add(sprite);
		this.add(strategyLabel);
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
		sprite.setIcon(new ImageIcon(ImageModifier.scaleWithDimension(object.getTextureImage(), buttonDimension)));
	}

	/**
	 * Method to draw the door
	 */
	public void drawDoor() {
		sprite.setIcon(new ImageIcon(
				ImageModifier.scaleWithDimension(ImageMethod.getImage("room/door.png"), buttonDimension)));
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		this.gameAreaController.makeAction(pos);
	}

	/**
	 * Method to remove the sprite from a GameButton
	 */
	public void removeSprite() {
		this.sprite.setIcon(null);
		repaint();
	}

	/**
	 * Method that highlight the background with the passed image
	 * 
	 * @param image the image to place on background
	 */
	public void highlightCell(ImageIcon image) {
		this.strategyLabel.setIcon(image);
	}

	/**
	 * Method that remove the highlight from the cell
	 */
	public void removeHighlight() {
		this.strategyLabel.setIcon(null);
	}
}
