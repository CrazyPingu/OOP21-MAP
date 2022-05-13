package view.game.central;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import logics.game_object.GameObject;
import utilities.ImageMethod;
import utilities.ImageModifier;

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

	public GameButton(Dimension buttonDimension) {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
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
		sprite.setIcon(
				new ImageIcon(ImageModifier.scaleWithDimension(object.getTextureImage(), buttonDimension)));
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
}
