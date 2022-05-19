package view.game.logStats;

import logics.game_object.entity.Player;

public class ScrollableStats extends ScrollPaneAppearance {

	private static final long serialVersionUID = 3192980786022666161L;

	private Stats statsValues;

	public ScrollableStats(Player player, Stats statsValues) {
		super(statsValues);
		this.statsValues = statsValues;
		this.statsValues.update(player);
		this.setScrollPaneAppearance();
	}

	/**
	 * @return stats values implemented as JTextPane.
	 */
	public Stats getStatsValues() {
		return this.statsValues;
	}
}
