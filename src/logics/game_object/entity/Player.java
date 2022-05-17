package logics.game_object.entity;

import java.awt.Image;
import logics.game_object.ArtefactUserObject;
import logics.game_object.GameObject;
import logics.game_object.KillableObject;
import logics.game_object.MovingObject;
import logics.game_object.WeaponizedObject;
import logics.game_object.MultipleActionObject;
import logics.life.ExtendibleMaxLifeSystem;
import logics.strategy.movement.Movement;
import logics.strategy.weapon.Weapon;
import utilities.Pair;

/**
 * 
 * Create the player's entity that can perform multiple action in a turn, can
 * change is position, can use artefact, can take damage and can carry a weapon.
 *
 */
public class Player implements MultipleActionObject, ArtefactUserObject, MovingObject, WeaponizedObject, KillableObject,
		GameObject {

	private final int INITIAL_ACTION_NUMBER = 0;
	private final static Pair<Integer, Integer> STANDARD_SPAWN_POSITION = new Pair<Integer, Integer>(0, 0);
	
	private ExtendibleMaxLifeSystem life;
	private Pair<Integer, Integer> pos;
	private Weapon weapon;
	private Movement movement;
	private String name;
	private Image textureImage;
	private int actionNumber;

	/**
	 * 
	 * @param life         is the life system of the player
	 * @param pos          is the position of the player
	 * @param weapon       is the weapon the player is holding
	 * @param movement     is the movement system of the player
	 * @param name         the name of the player
	 * @param textureImage the texture of the player. Texture can be found in
	 *                     utilis.texture
	 */
	public Player(ExtendibleMaxLifeSystem life, Pair<Integer, Integer> pos, Weapon weapon, Movement movement,
			String name, Image textureImage) {
		this.life = life;
		this.pos = pos;
		this.weapon = weapon;
		this.movement = movement;
		this.name = name;
		this.textureImage = textureImage;
		this.actionNumber = this.INITIAL_ACTION_NUMBER;
	}
	
	/**
	 * 
	 * @param life         is the life system of the player
	 * @param weapon       is the weapon the player is holding
	 * @param movement     is the movement system of the player
	 * @param name         the name of the player
	 * @param textureImage the texture of the player. Texture can be found in
	 *                     utilis.texture
	 */
	public Player(ExtendibleMaxLifeSystem life, Weapon weapon, Movement movement, String name, Image textureImage) {
		this(life, STANDARD_SPAWN_POSITION, weapon, movement, name, textureImage);
	}
	
	@Override
	public void changeWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public void changeMovement(Movement movement) {
		this.movement = movement;
	}

	@Override
	public void heal(int healValue) {
		this.life.heal(healValue);
	}

	@Override
	public void setMaxHealth(int maxHealthValue) {
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
	public void damage(int damageValue) {
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
	public void setPos(Pair<Integer, Integer> pos) {
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
		return " name = " + this.name + "\n health = " + this.getHealth() + "\n max health" + this.getMaxHealth()
				+ "\n weapon damage = " + this.weapon.getDamage() + "\n number action = " + this.getActionNumber();
	}
}
