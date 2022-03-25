package logics.entity;

import java.util.List;

import logics.weapon.Weapon;
import utilis.Pair;

/**
 * 
 * Interface that declares methods for the entity.
 *
 */
public interface Entity {

	/**
	 * @return a List<Pair<>> that rappresent the cells where the entity can move.
	 */
	public List<Pair<Integer, Integer>> movingStrategy();

	/**
	 * @param damageValue : value that will be decreased from the entity's current
	 *                    health.
	 */
	public void takeDamage(int damageValue);

	/**
	 * @param healthValue : value that will be added to the entity's current health.
	 */
	public void takeHeal(int healValue);

	/**
	 * @return an Integer that rappresent the entity's current health.
	 */
	public int getHealth();

	/**
	 * @return an Integer that rappresent the entity's maximum health.
	 */
	public int getMaxHealth();

	/**
	 * @return the weapon that the entity is holding.
	 */
	public Weapon getWeapon();

	/**
	 * @return an Integer that rappresent the number of actions that the entity can
	 *         do in a turn.
	 */
	public int getActionNumber();

	/**
	 * @return the name of the entity.
	 */
	public String getName();
}
