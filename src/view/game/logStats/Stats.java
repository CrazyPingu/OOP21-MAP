package view.game.logStats;

import logics.entity.Player;

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
	
	public void update(Player player) {
		this.setText("ACTIONS LEFT: " + /* player.getActionNumberLeft() + */ "/" + player.getActionNumber()
				+ "\nMAX HEALTH: +" + player.getMaxHealth()
				+ "\nATK: +" + /* (player.getAdditionalDamage+player.getBaseDamage) + */
				"");
	}

}
