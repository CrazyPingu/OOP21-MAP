package view.game.log_stats;

import model.game_object.entity.Player;
import model.game_statistics.GameStatisticsImpl;

/**
 *
 * Create the stats label to display.
 *
 */

public class Stats extends TextAreaAppearance {

    private static final long serialVersionUID = -678263256165523272L;

    /**
     * @param player:              player object to init first values in the stats
     *                             view
     * @param gameStats:           statistics of the game
     * @param currentActionNumber: actions left in a turn
     */

    public void update(final Player player, final GameStatisticsImpl gameStats, final int currentActionNumber) {
        this.setText(player.toString() + gameStats.toString() + "\n Actions left: " + currentActionNumber);
    }

}
