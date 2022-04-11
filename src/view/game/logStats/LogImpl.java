package view.game.logStats;

import logics.entity.Player;

/**
 * 
 * Create the log label to display.
 *
 */

public class LogImpl extends LabelAppearance {

	private static final long serialVersionUID = 3777939147427639785L;
	private final String initialText="<html>Marcello has to escape to survive...";

	public LogImpl() {
		super();
		this.setText(initialText);
		this.setAppearance();
	}
	
	/**
	 * Updates the log messages shown on the screen.
	 */

	public void update(String message) {
		this.setText(this.getText() + "<br/>" + message);
	}
	
}
