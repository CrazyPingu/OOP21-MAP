package logics.entity;

import java.util.List;

import logics.weapon.Weapon;
import utilis.Pair;

/**
 * 
 * Create the entity designed by the passed value implementing the Entity
 * interface.
 *
 */
public class EntityImpl implements Entity {
	private int health;
	private int maxHealth;
	private Weapon weapon;
	private int actionNumber;
	private String name;

	/**
	 * @param health       : the health of the entity.
	 * @param maxHealth    : the maximum health that the entity can have.
	 * @param weapon       : the weapon that the entity is currently holding.
	 * @param actionNumber : the number of action that the entity can do in a turn.
	 * @param name         : the name of the entity.
	 */
	public EntityImpl(int health, int maxHealth, Weapon weapon, int actionNumber, String name) {
		this.health = health;
		this.maxHealth = maxHealth;
		this.weapon = weapon;
		this.actionNumber = actionNumber;
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Pair<Integer, Integer>> movingStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void takeDamage(int damageValue) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void takeHeal(int healValue) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public int getHealth() {
		return this.health;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getMaxHealth() {
		return this.maxHealth;
	}

	/**
	 * {@inheritDoc}
	 */
	public Weapon getWeapon() {
		return this.weapon;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getActionNumber() {
		return this.actionNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return this.name;
	}
}
