package view.game.logStats;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import logics.entity.Player;
import utilis.Constant;

/**
 *
 * Create the stats label to display.
 *
 */

public class Stats extends LabelAppearance {

	private static final long serialVersionUID = -678263256165523272L;
	
	Border border;
	
	/**
	 * @param player	: player object to init first values in the stats view
	 */
	public Stats (Player player) {
		super();
		this.update(player);
		this.setAppearance();
        border = BorderFactory.createLineBorder(Color.GRAY,3);
        this.setBorder(border);
        this.setPreferredSize(new Dimension (Constant.WIDTH / 4,  Constant.HEIGHT * 2 / 3));
	}

	/**
	 * Updates the stats values shown on the screen.
	 */

	public void update(Player player) {
		this.setText("<html>&nbsp ACTIONS LEFT: " + /*player.getActionNumberLeft() +*/
				"/" + player.getActionNumber() +
				"<br/>&nbsp MAX HEALTH: +" + player.getMaxHealth() +
				"<br/>&nbsp ATK: +" + /*(player.getAdditionalDamage+player.getBaseDamage) +*/ "</html>");
	}	

}
