package logics.entity;

import java.util.ArrayList;
import java.util.List;
import logics.weapon.Weapon;
import logics.artefact.Artefact;
import logics.life.AdvancedLife;
import logics.life.BasicLife;
import logics.strategy.movement.Movement;

/**
 * 
 * Create the player's entity based on a general entity.
 *
 */
public class Player extends EntityImpl {
	private List<Artefact> artefact;
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
		this.artefact = new ArrayList<>();
		this.additionalDamage = 0;
	}

}
