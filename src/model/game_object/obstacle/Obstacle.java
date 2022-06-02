package model.game_object.obstacle;

import java.awt.Image;

import model.game_object.GameObject;
import utilities.Pair;

public class Obstacle implements GameObject{
  
  private final Pair<Integer, Integer> pos;
  private final String name;
  private final Image textureImage;
  
  public Obstacle(final Pair<Integer, Integer> pos, final String name, final Image textureImage) {
    this.pos = pos;
    this.name = name;
    this.textureImage = textureImage;
    
  }

  public Pair<Integer, Integer> getPos() {
    return this.pos;
  }

  public String getName() {
    return this.name;
  }

  public Image getTextureImage() {
    return this.textureImage;
  }
  
}
