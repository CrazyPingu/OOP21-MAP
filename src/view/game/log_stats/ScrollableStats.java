package view.game.log_stats;

import model.game_object.entity.Player;
import model.game_statistics.GameStatisticsImpl;

/**
 * 
 * Sets a scrollable type of stats text area.
 *
 */
public class ScrollableStats extends ScrollPaneAppearance {

    private static final long serialVersionUID = 3192980786022666161L;

    private final Stats statsValues;

    public ScrollableStats(final Player player, final Stats statsValues, final GameStatisticsImpl gameStats,
            final int currentActionNumber) {
        super(statsValues);
        this.statsValues = statsValues;
        this.statsValues.update(player, gameStats, currentActionNumber);
        this.setScrollPaneAppearance();
    }

    /**
     * @return stats values implemented as JTextPane.
     */
    public Stats getStatsValues() {
        return this.statsValues;
    }
}
