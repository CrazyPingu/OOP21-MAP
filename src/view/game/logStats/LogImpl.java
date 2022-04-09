package view.game.logStats;

import logics.entity.Player;

/**
 * 
 * Create the log label to display.
 *
 */

public class LogImpl extends LabelAppearance implements LogStats {

	private static final long serialVersionUID = 3777939147427639785L;
	private final String initialText="Marcello has to escape to survive...";

	public LogImpl() {
		this.setText(initialText);
		this.setAppearance();
	}
	
	/**
	 * {@inheritDoc}
	 */

	public void update(Player player, String message) {
		this.setText(player.getName() + " " + message);
	}
	
}
