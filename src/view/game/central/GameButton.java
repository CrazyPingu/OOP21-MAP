package view.game.central;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.GameAreaController;
import model.game_object.GameObject;
import utilities.ImageModifier;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Class to manage the single button of the GameArea
 *
 */
public class GameButton extends JButton implements ActionListener {

  private static final long serialVersionUID = 1384166202851332499L;
  private final Dimension buttonDimension;
  private final GameAreaController gameAreaController;
  private final Pair<Integer, Integer> pos;
  private Image image;
  private Color color;
  private final boolean isDoor;
  private final Pair<Integer, Integer> radius;
  private final Pair<Integer, Integer> dim;

  public GameButton(final Dimension buttonDimension, final GameAreaController gameAreaController,
      final Pair<Integer, Integer> pos, final boolean isDoor) {
    this.isDoor = isDoor;
    this.color = RoomConstant.BASIC_CELL_COLOR;
    radius = new Pair<>((int) buttonDimension.getWidth() / 4, (int) buttonDimension.getHeight() / 4);
    dim = new Pair<>((int) buttonDimension.getWidth() / 2 - radius.getX() / 2,
        (int) buttonDimension.getHeight() / 2 - radius.getY() / 2);
    this.pos = pos;
    image = null;
    this.setContentAreaFilled(false);
    this.gameAreaController = gameAreaController;
    this.buttonDimension = buttonDimension;
    this.setEnabled(false);
    this.addActionListener(this);
    this.setOpaque(true);
  }

  protected void paintComponent(final Graphics g) {
    super.paintComponent(g);
    if (isDoor) {
      g.setColor(RoomConstant.DOOR_CELL_COLOR);
      g.fillRect(0, 0, (int) buttonDimension.getWidth(), (int) buttonDimension.getHeight());
    } else {
      g.drawImage(RoomConstant.BUTTON_IMAGE, 0, 0, (int) buttonDimension.getWidth(), (int) buttonDimension.getHeight(),
          null);
    }
    if (image != null) {
      g.drawImage(image, 0, 0, (int) buttonDimension.getWidth(), (int) buttonDimension.getHeight(), null);
    }
    if (checkHighlight()) {
      g.setColor(color);
      g.fillOval(dim.getX(), dim.getY(), radius.getX(), radius.getY());
    }

  }

  private boolean checkHighlight() {
    return this.color.equals(RoomConstant.ATTACK_HIGHLIGHT) || this.color.equals(RoomConstant.MOVE_HIGHLIGHT)
        || this.color.equals(RoomConstant.ENEMY_RANGE);
  }

  /**
   * @param object paints the image of the object
   */
  public void drawGameObject(final GameObject object) {
    image = ImageModifier.scaleMaintainingAspectRatio(object.getTextureImage(), buttonDimension);
    repaint();
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
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
  public void highlightCell(final Color backgroundColor) {
    if(backgroundColor != RoomConstant.ENEMY_RANGE) {
      this.setEnabled(true);
    }
    this.color = backgroundColor;
  }

  /**
   * Method that remove the highlight from the cell
   */
  public void removeHighlight() {
    this.setEnabled(false);
    this.color = RoomConstant.BASIC_CELL_COLOR;
    repaint();
  }
}
