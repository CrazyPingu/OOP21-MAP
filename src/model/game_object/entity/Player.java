package model.game_object.entity;

import java.awt.Image;
import model.game_object.ArtefactUserObject;
import model.life.impl.ExtendibleMaxLifeSystem;
import model.movement.Movement;
import model.weapon.Weapon;
import utilities.Pair;

/**
 * 
 * This class model the player's entity. Can perform multiple action in a turn, can
 * change is position, can use artefact, can take damage and can carry a weapon.
 */
public class Player extends Entity implements ArtefactUserObject {

  private final static int INITIAL_ACTION_NUMBER = 2;
  private final static Pair<Integer, Integer> STANDARD_SPAWN_POSITION = new Pair<>(0, 0);
  private final ExtendibleMaxLifeSystem life;
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
    super(life, pos, weapon, movement, name, textureImage);
    this.life = life;
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
    super.setWeapon(weapon);
  }

  @Override
  public void changeMovement(final Movement movement) {
    super.setMovement(movement);
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
  public int getMaxHealth() {
    return this.life.getMaxHealth();
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
    return " name = " + super.getName() + "\n health = " + this.getHealth() + "\n max health = " + this.getMaxHealth()
        + "\n current weapon = " + super.getWeapon().getName() + "\n weapon damage = " + super.getWeapon().getDamage()
        + "\n number action = " + this.getActionNumber();
  }

}
