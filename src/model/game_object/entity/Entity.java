package model.game_object.entity;

import java.awt.Image;
import java.util.List;
import java.util.Optional;
import model.game_object.KillableObject;
import model.game_object.MovingObject;
import model.game_object.WeaponizedObject;
import model.life_system.LifeSystem;
import model.movement.Movement;
import model.weapon.Weapon;
import utilities.Pair;

/**
 * 
 * Class to incapsulate an entity behaviur. This class will be extends to create
 * more complex Entity.
 * Implements all the common method for a simple game object able to hold a
 * weapon, move and take damage. This class is used for the enemy
 * implementation.
 */
public class Entity implements MovingObject, WeaponizedObject, KillableObject {

  private final LifeSystem life;
  private final String name;
  private final Image textureImage;
  private Movement movement;
  private Weapon weapon;
  private Pair<Integer, Integer> pos;

  /**
   * 
   * @param life         is the life system of the entity
   * @param pos          is the position of the entity
   * @param weapon       is the weapon the entity is holding
   * @param movement     is the movement sistem of the entity
   * @param name         the name of the entity
   * @param textureImage the texture of the entity. Texture can be found in
   *                     utilis.texture
   */
  public Entity(final LifeSystem life, final Pair<Integer, Integer> pos, final Weapon weapon, final Movement movement,
      final String name, final Image textureImage) {
    this.life = life;
    this.pos = pos;
    this.weapon = weapon;
    this.movement = movement;
    this.name = name;
    this.textureImage = textureImage;
  }

  @Override
  public void damage(final int damageValue) {
    this.life.damage(damageValue);
  }

  @Override
  public int getHealth() {
    return life.getCurrentHealth();
  }

  @Override
  public Boolean isDead() {
    return this.life.isDead();
  }

  @Override
  public void setPos(final Pair<Integer, Integer> pos) {
    this.pos = pos;
  }

  public Pair<Integer, Integer> getPos() {
    return this.pos;
  }

  @Override
  public Weapon getWeapon() {
    return this.weapon;
  }

  @Override
  public Optional<List<Pair<Integer, Integer>>> getReachableArea(final Pair<Integer, Integer> size) {
    return Optional.of(movement.reachableCells(pos, size));
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
   * This method is used by the subclass to change the weapon.
   * 
   * @param weapon is the weapon that will substitute the the actual one
   */
  protected void setWeapon(final Weapon weapon) {
    this.weapon = weapon;
  }

  /**
   * This method is used by the subclass to change the movement.
   * 
   * @param movement is the movement that will substitute the actual one
   */
  protected void setMovement(final Movement movement) {
    this.movement = movement;
  }

  public String toString() {
    return "name = " + name + " " + "health = " + this.life.getCurrentHealth() + " " + "weapon damage = "
        + this.weapon.getDamage();
  }

}
