package view.game.logStats;

import logics.game_object.entity.Player;
import logics.game_statistics.GameStatisticsImpl;

/**
 *
 * Create the stats label to display.
 *
 */

public class Stats extends TextAreaAppearance {

	private static final long serialVersionUID = -678263256165523272L;

	public Stats() {
		super();
	}

	/**
	 * @param player : player object to init first values in the stats view
	 */
	
	public void update(Player player, GameStatisticsImpl gameStats, int currentActionNumber) {
		this.setText(player.toString() + gameStats.toString() + currentActionNumber);
	}

}
