package logics.game_object.artefact;

import logics.entity.Player;

/**
 * 
 * This interface declare the common method for every artefact. 
 *
 */
public interface Artefact {

	/**
	 * 
	 * @param player represent the player to which the effect will be applied
	 */
	public void execute(Player player); 
	
}
