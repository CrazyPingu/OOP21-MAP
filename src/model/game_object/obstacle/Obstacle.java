package model.game_object.obstacle;

import java.awt.Image;

import model.game_object.GameObject;
import utilities.Pair;

/**
 * 
 * This interface declare the common methods for every Obstacle
 * 
 */
public class Obstacle implements GameObject {

  private final Pair<Integer, Integer> pos;
  private final String name;
  private final Image textureImage;

  /**
   * 
   * @param pos          the position of the obstacle in the game field
   * @param name         the name of the obstacle
   * @param textureImage the image that represents the ostacle
   */
  public Obstacle(final Pair<Integer, Integer> pos, final String name, final Image textureImage) {
    this.pos = pos;
    this.name = name;
    this.textureImage = textureImage;

  }

  @Override
  public Pair<Integer, Integer> getPos() {
    return this.pos;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Image getTextureImage() {
    return this.textureImage;
  }

}
