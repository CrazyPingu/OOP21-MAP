package model.game_object.entity;

import java.awt.Image;

import model.game_object.ArtefactUserObject;
import model.game_object.GameObject;
import model.game_object.KillableObject;
import model.game_object.MovingObject;
import model.game_object.MultipleActionObject;
import model.game_object.WeaponizedObject;
import model.life.impl.ExtendibleMaxLifeSystem;
import model.strategy.movement.Movement;
import model.strategy.weapon.Weapon;
import utilities.Pair;

/**
 * 
 * Create the player's entity that can perform multiple action in a turn, can
 * change is position, can use artefact, can take damage and can carry a weapon.
 *
 */
public class Player
    implements MultipleActionObject, ArtefactUserObject, MovingObject, WeaponizedObject, KillableObject, GameObject {

  private final static int INITIAL_ACTION_NUMBER = 2;
  private final static Pair<Integer, Integer> STANDARD_SPAWN_POSITION = new Pair<>(0, 0);
  private final String name;
  private final ExtendibleMaxLifeSystem life;
  private final Image textureImage;
  private Pair<Integer, Integer> pos;
  private Weapon weapon;
  private Movement movement;
  private int actionNumber;

  /**
   * This method allows an initialization for the player whit complete
   * customizable fields
   * 
   * @param life         is the life system of the player
   * @param pos          is the position of the player
   * @param weapon       is the weapon the player is holding
   * @param movement     is the movement system of the player
   * @param name         the name of the player
   * @param textureImage the texture of the player. Texture can be found in
   *                     utilis.texture
   */
  public Player(final ExtendibleMaxLifeSystem life, final Pair<Integer, Integer> pos, final Weapon weapon,
      final Movement movement, final String name, final Image textureImage, final int initialActionNumber) {
    this.life = life;
    this.pos = pos;
    this.weapon = weapon;
    this.movement = movement;
    this.name = name;
    this.textureImage = textureImage;
    this.actionNumber = initialActionNumber;
  }

  /**
   * This method allows a fast initialization for the player using standard values
   * for the spawn position and action number
   * 
   * @param life         is the life system of the player
   * @param weapon       is the weapon the player is holding
   * @param movement     is the movement system of the player
   * @param name         the name of the player
   * @param textureImage the texture of the player. Texture can be found in
   *                     utilis.texture
   */
  public Player(final ExtendibleMaxLifeSystem life, final Weapon weapon, final Movement movement, final String name,
      final Image textureImage) {
    this(life, STANDARD_SPAWN_POSITION, weapon, movement, name, textureImage, INITIAL_ACTION_NUMBER);
  }

  @Override
  public void changeWeapon(final Weapon weapon) {
    this.weapon = weapon;
  }

  @Override
  public void changeMovement(final Movement movement) {
    this.movement = movement;
  }

  @Override
  public void heal(final int healValue) {
    this.life.heal(healValue);
  }

  @Override
  public void setMaxHealth(final int maxHealthValue) {
    this.life.setMaxHealth(maxHealthValue);

  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Image getTextureImage() {
    return this.textureImage;
  }

  @Override
  public void damage(final int damageValue) {
    this.life.damage(damageValue);
  }

  @Override
  public int getHealth() {
    return this.life.getCurrentHealth();
  }

  @Override
  public int getMaxHealth() {
    return this.life.getMaxHealth();
  }

  @Override
  public Boolean isDead() {
    return this.life.isDead();
  }

  @Override
  public Weapon getWeapon() {
    return this.weapon;
  }

  @Override
  public void setPos(final Pair<Integer, Integer> pos) {
    this.pos = pos;
  }

  @Override
  public Pair<Integer, Integer> getPos() {
    return this.pos;
  }

  @Override
  public Movement getMovementSystem() {
    return this.movement;
  }

  @Override
  public void increaseActionNumber() {
    this.actionNumber++;
  }

  @Override
  public int getActionNumber() {
    return this.actionNumber;
  }

  public String toString() {
    return " name = " + this.name + "\n health = " + this.getHealth() + "\n max health = " + this.getMaxHealth()
        + "\n current weapon = " + this.weapon.getName() + "\n weapon damage = " + this.weapon.getDamage()
        + "\n number action = " + this.getActionNumber();
  }
}
