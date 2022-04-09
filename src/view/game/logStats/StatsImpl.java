package view.game.logStats;

import logics.entity.Player;

/**
 *
 * Create the stats label to display.
 *
 */

public class StatsImpl extends LabelAppearance implements LogStats {

	private static final long serialVersionUID = -678263256165523272L;

	/**
	 * @param player	: player object to init first values in the stats view
	 */
	public StatsImpl (Player player) {
		this.update(player, null);
		this.setAppearance();
	}

	/**
	 * {@inheritDoc}
	 */

	public void update(Player player, String message) {
		this.setText("<html>Actions left: " + /*player.getActionNumberLeft() +*/
				"<br/>/" + player.getActionNumber() +
				"<br/>MAX HEALTH: +" + player.getMaxHealth() +
				"<br/>ATK: +" + /*(player.getAdditionalDamage+player.getBaseDamage) +*/ "</html>");
	}	

}
