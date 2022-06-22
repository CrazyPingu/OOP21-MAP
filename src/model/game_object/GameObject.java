package model.game_object;

import java.awt.Image;
import utilities.Pair;

/**
 * 
 * This class declare the common method for every object in game that can be
 * displayed in the game grid.
 */
public interface GameObject {

  /**
   * 
   * @return the current position of the object
   */
  Pair<Integer, Integer> getPos();

  /**
   * 
   * @return the name of the GameObject
   */
  String getName();

  /**
   * 
   * @return the object's texture image
   */
  Image getTextureImage();

}
