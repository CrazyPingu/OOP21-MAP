package logics.game_object.entity;

import java.util.ArrayList;
import java.util.List;

import ourTest.oldCode.AdvancedLife;
import ourTest.oldCode.BasicLife;
import ourTest.oldCode.EntityImpl;
import logics.strategy.movement.Movement;
import logics.strategy.weapon.Weapon;

/**
 * 
 * Create the player's entity based on a general entity.
 *
 */
public class Player extends EntityImpl {
	private int additionalDamage;

	/**
	 * @param artefact         : the list of the artefact that the player is
	 *                         currently holding.
	 * @param additionalDamage : the additional damage that an artefact will add to
	 *                         the base damage of the player's weapon.
	 * @param name             : the name of the player.
	 */
	public Player(AdvancedLife health, Weapon weapon, Movement movement,  int actionNumber, String name) {
		super(health, weapon, movement, actionNumber, name); 

		this.additionalDamage = 0;
	}

}
