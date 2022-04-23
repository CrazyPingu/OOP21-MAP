package logics.game_object.entity;

import logics.life.BasicLife;
import logics.strategy.movement.Movement;
import logics.weapon.Weapon;

/**
 * 
 * Create the entity designed by the passed value implementing the Entity
 * interface.
 *
 */
public class EntityImpl implements Entity {
	private BasicLife health;
	private Weapon weapon;
	private Movement movement; 
	private String name;
	private int actionNumber; 

	/**
	 * 
	 * @param health the health of the entity.
	 * @param weapon the weapon that the entity is currently holding.
	 * @param movement encaplsulate the moving strategy of the entity. 
	 * @param actionNumber the number of action that the entity can do in a turn.
	 * @param name the name of the entity.
	 */
	public EntityImpl(BasicLife health, Weapon weapon, Movement movement,  int actionNumber, String name) {
		this.health = health;
		this.weapon = weapon;
		this.movement = movement;
		this.actionNumber = actionNumber; 
		this.name = name;
	}

	@Override
	public void heal(int healValue) {
		this.health.heal(healValue);

	}

	@Override
	public void damage(int damageValue) {
		this.health.takeDamage(damageValue);

	}

	@Override
	public int getHealth() {
		return this.health.getCurrentHealth();
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
	public void setMovementSystem(Movement movement) {
		this.movement = movement; 
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getActionNumber() {
		return this.actionNumber;
	}

	@Override
	public void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber; 
	}
	
	public String toString() {
		return "name = " + name + " " + 
			   "health = " + health.getCurrentHealth() + " " + 
			   "max health = " + health.getMaxHealth() + " " + 
			   "weapon damage = " + this.weapon.getDamage(); 
		
	}

}
