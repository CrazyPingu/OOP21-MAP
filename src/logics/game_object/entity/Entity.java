package logics.game_object.entity;

import logics.strategy.movement.Movement;
import logics.weapon.Weapon;

/**
 * 
 * Interface that declares methods for the entity.
 *
 */
public interface Entity {

	/**
	 * @param healthValue value that will be added to the entity's current health.
	 */
	public void heal(int healValue);

	/**
	 * @param damageValue value that will be decreased from the entity's current
	 *                    health.
	 */
	public void damage(int damageValue);

	/**
	 * @return an Integer that rappresent the entity's current health.
	 */
	public int getHealth();

	/**
	 * 
	 * @return the number of action that the entity can perform
	 */
	public int getActionNumber(); 
	
	/**
	 * 
	 * @param actionNumber represent the new number of action that a entity can
	 *                     perform in a turn
	 */
	public void setActionNumber(int actionNumber);

	/**
	 * @return the weapon that the entity is holding.
	 */
	public Weapon getWeapon();

	/**
	 * @return a Movement that encapsulate number of anction and movement strategy
	 */
	public Movement getMovementSystem();

	/**
	 * 
	 * @param movementSystem movement that will substitute the current one
	 */
	public void setMovementSystem(Movement movement);

	/**
	 * @return the name of the entity.
	 */
	public String getName();

}
