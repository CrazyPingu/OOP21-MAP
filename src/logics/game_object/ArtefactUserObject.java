package logics.game_object;

import logics.strategy.movement.Movement;
import logics.strategy.weapon.Weapon;

/**
 * 
 * Declare the common method for the Object that can be used from an artefact
 * excecute method.
 *
 */
public interface ArtefactUserObject {

	/**
	 * 
	 * @param weapon is the weapon that will substitute the the object is using
	 */
	public void changeWeapon(Weapon weapon);

	/**
	 * 
	 * @param movement is the new movement of the object
	 */
	public void changeMovement(Movement movement);

	/**
	 * 
	 * @param healValue the value of the heal
	 */
	public void heal(int healValue);

	/**
	 * 
	 * @param maxHealthValue the new maximum amount of health
	 */
	public void setMaxHealth(int maxHealthValue);

	/**
	 * 
	 * @return the max health the entity can currently reach. The max health limit
	 *         is specified in the constructor
	 */
	public int getMaxHealth();

	/**
	 * increase the number of action the entity can perform in a turn
	 */
	public void increaseActionNumber();

}
