package model.game_object.entity;

import java.awt.Image;

import model.life_system.LifeSystem;
import model.movement.Movement;
import model.weapon.Weapon;
import utilities.Pair;

/**
 * 
 * Wraps the entity class and allow a simple way to distingue a entity from a
 * simpleEnemy
 */
public class SimpleEnemy extends Entity {

  /**
   * 
   * @param life         is the life system of the SimpleEnemy
   * @param pos          is the position of the SimpleEnemy
   * @param weapon       is the weapon the SimpleEnemy is holding
   * @param movement     is the movement sistem of the SimpleEnemy
   * @param name         the name of the SimpleEnemy
   * @param textureImage the texture of the SimpleEnemy. Texture can be found in
   *                     utilis.texture
   */
  public SimpleEnemy(final LifeSystem life, final Pair<Integer, Integer> pos, final Weapon weapon,
      final Movement movement, final String name, final Image textureImage) {
    super(life, pos, weapon, movement, name, textureImage);
  }

}
