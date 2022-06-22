package utilities.texture;

import java.awt.Image;

import utilities.ImageMethod;

/**
 * 
 * Class that conteins references for the texture of entities.
 *
 */
public class EntityTexture {

  /**
   * PLAYER TEXTURE
   */
  public static final Image PLAYER = ImageMethod.getImage("player/Player.png");
    
  /**
   * ENEMY TEXTURES
   */
  public static final Image ZOMBIE_STICK = ImageMethod.getImage("enemy/ZombieStick.png");
  public static final Image ZOMBIE_AXE = ImageMethod.getImage("enemy/ZombieAxe.png");
  public static final Image ZOMBIE_DAGGER = ImageMethod.getImage("enemy/ZombieDagger.png");
  public static final Image ZOMBIE_TUBE = ImageMethod.getImage("enemy/ZombieTube.png");
  public static final Image ZOMBIE_GUN = ImageMethod.getImage("enemy/ZombieGun.png");

  /**
   * OBSTACLE TEXTURES
   */
  public static final Image ROCK = ImageMethod.getImage("obstacle/Rock.png");
  public static final Image PEBBLE = ImageMethod.getImage("obstacle/Pebble.png");

}
