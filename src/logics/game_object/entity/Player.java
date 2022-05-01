package logics.game_object.entity;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import logics.game_object.ArtefactUserObject;
import logics.game_object.GameObject;
import logics.game_object.KillableObject;
import logics.game_object.MovingObject;
import logics.game_object.WeponizedObject;
import logics.strategy.movement.Movement;
import logics.strategy.weapon.Weapon;
import utilis.Pair;

/**
 * 
 * Create the player's entity based on a general entity.
 *
 */
public class Player extends SimpleEntity implements ArtefactUserObject {
	private int additionalDamage;

	
	public Player() {
		super(health, weapon, movement, actionNumber, name); 

	}


		
}

