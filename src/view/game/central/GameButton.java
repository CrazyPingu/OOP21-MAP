package view.game.central;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.GameAreaController;
import logics.game_object.GameObject;
import utilities.ImageModifier;
import utilities.Pair;

/**
 * 
 * Class to manage the single button of the GameArea
 *
 */
public class GameButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1384166202851332499L;
	private Dimension buttonDimension;
	private GameAreaController gameAreaController;
	private Pair<Integer, Integer> pos;
	private Image image;
	private Color color;

	public GameButton(Dimension buttonDimension, GameAreaController gameAreaController, Pair<Integer, Integer> pos) {
		this.color = Color.gray;
		this.pos = pos;
		image = null;
		this.setContentAreaFilled(false);
		this.gameAreaController = gameAreaController;
		this.buttonDimension = buttonDimension;
		this.setEnabled(false);
		this.addActionListener(this);
		this.setOpaque(true);
	}

	protected void paintComponent(Graphics g) {
		this.setBackground(color);
		super.paintComponent(g);
		if(image != null) {
			g.drawImage(image, 0, 0, (int) buttonDimension.getWidth(), (int) buttonDimension.getHeight(), null);
		}
		
	}

	/**
	 * @param object paints the image of the object
	 */
	public void drawGameObject(GameObject object) {
		image = ImageModifier.scaleMaintainingAspectRatio(object.getTextureImage(), buttonDimension);
		repaint();
	}

	/**
	 * Method to draw the door
	 */
	public void drawDoor() {
		this.color = new Color(110, 38, 14);
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		this.gameAreaController.makeAction(pos);
	}

	/**
	 * Method to remove the sprite from a GameButton
	 */
	public void removeSprite() {
		this.image = null;
		repaint();
	}

	/**
	 * Method that highlight the background with the passed image
	 * 
	 * @param image the image to place on background
	 */
	public void highlightCell(Color backgroundColor) {
		this.setEnabled(true);
		this.color = backgroundColor;
	}

	/**
	 * Method that remove the highlight from the cell
	 */
	public void removeHighlight() {
		this.setEnabled(false);
		this.color = Color.gray;
		repaint();
	}
}
