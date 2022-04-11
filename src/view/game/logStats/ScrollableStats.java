package view.game.logStats;

import logics.entity.Player;

public class ScrollableStats extends ScrollPaneAppearance {

	private static final long serialVersionUID = 3192980786022666161L;

	private static Stats statsValues = new Stats();

	public ScrollableStats(Player player) {
		super(statsValues);
		statsValues.update(player);
		this.setScrollPaneAppearance();
	}

	/**
	 * @return stats values implemented as JTextPane.
	 */
	public static Stats getStatsValues() {
		return statsValues;
	}
}
