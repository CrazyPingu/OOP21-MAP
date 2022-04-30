package logics.game_object.entity;

import java.awt.Image;

import logics.game_object.GameObject;
import logics.game_object.KillableObject;
import logics.game_object.MovingObject;
import logics.game_object.WeponizedObject;
import logics.life.LifeSystem;
import logics.strategy.movement.Movement;
import logics.strategy.weapon.Weapon;
import utilis.Pair;

/**
 * 
 * Implements all the common method for a simple game object able to hold a
 * weapon, move and take damage. This class is used in enemy and player class to
 * avoid code repetition.
 *
 */
public class SimpleEntity implements MovingObject, WeponizedObject, KillableObject, GameObject {

	private LifeSystem life;
	private Pair<Integer, Integer> pos;
	private Weapon weapon;
	private Movement movement;
	private String name;
	private Image textureImage;

	/**
	 * 
	 * @param life         is the life system of the entity
	 * @param pos          is the position of the entity
	 * @param weapon       is the weapon the entity is holding
	 * @param movement     is the movement sistem of the entity
	 * @param name         the name of the entity
	 * @param textureImage the path where to find the texture. Texture references
	 *                     can be found in utilis.texture
	 */
	public SimpleEntity(LifeSystem life, Pair<Integer, Integer> pos, Weapon weapon, Movement movement, String name,
			Image textureImage) {
		this.life = life;
		this.pos = pos;
		this.weapon = weapon;
		this.movement = movement;
		this.name = name;
		this.textureImage = textureImage;
	}

	@Override
	public void damage(int damageValue) {
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
	public void setPos(Pair<Integer, Integer> pos) {
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
	public Movement getMovementSystem() {
		return this.movement;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Image getTextureImage() {
		return this.textureImage;
	}

	public String toString() {
		return "name = " + name + " " + "health = " + this.life.getCurrentHealth() + " " + "weapon damage = "
				+ this.weapon.getDamage();
	}

}
