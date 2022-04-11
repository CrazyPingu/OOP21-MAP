package view.game.logStats;

/**
 * 
 * Create the log label to display.
 *
 */

public class Log extends TextAreaAppearance {

	private static final long serialVersionUID = 3777939147427639785L;

	private final String initialText = "Marcello has to escape to survive... RUN!!!!";

	/**
	 * Sets first log message.
	 */
	
	public Log() {
		this.setText(initialText);
	}

	/**
	 * Updates the log messages shown on the screen.
	 */
	
	public void update(String message) {
		this.setText(this.getText() + "\n" + message);
	}
}
