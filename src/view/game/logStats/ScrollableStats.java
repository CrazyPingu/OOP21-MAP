package view.game.logStats;

import logics.game_object.entity.Player;
import logics.game_statistics.GameStatisticsImpl;

public class ScrollableStats extends ScrollPaneAppearance {

	private static final long serialVersionUID = 3192980786022666161L;

	private Stats statsValues;

	public ScrollableStats(Player player, Stats statsValues, GameStatisticsImpl gameStats, int currentActionNumber) {
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
