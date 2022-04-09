package view.game.logStats;

import logics.entity.Player;

/**
 * 
 * Interface to define stats and log labels' methods.
 * 
 */

public interface LogStats {
	/**
	 * Updates the output shown on the screen.
	 */
	public void update(Player player, String message);
}
