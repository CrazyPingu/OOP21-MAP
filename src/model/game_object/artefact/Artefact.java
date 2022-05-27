package model.game_object.artefact;

import java.awt.Image;

import model.game_object.ArtefactUserObject;
import model.game_object.GameObject;
import utilities.Pair;

/**
 * 
 * This interface declare the common method for every artefact.
 *
 */
public abstract class Artefact implements GameObject {

  private final Pair<Integer, Integer> pos;
  private final String name;
  private final Image textureImage;

  /**
   * 
   * @param pos  represent the position of the artefact in the game grid
   * @param name is the artefact name
   * @param the  texture of the player. Texture can be found in utilis.texture
   */
  public Artefact(final Pair<Integer, Integer> pos, final String name, final Image textureImage) {
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

  /**
   * 
   * @param subject represent the subject to which the effect will be applied
   */
  public abstract void execute(ArtefactUserObject subject);

}
