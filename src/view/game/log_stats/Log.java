package view.game.log_stats;

/**
 * 
 * Create the log label to display.
 *
 */

public class Log extends TextAreaAppearance {

    private static final long serialVersionUID = 3777939147427639785L;

    private static final String INIT_TEXT = "Marcello has to escape to survive... RUN!!!!";

    /**
     * Sets first log message.
     */
    public Log() {
        this.setText(INIT_TEXT);
    }

    /**
     * Updates the log messages shown on the screen.
     */
    public void update(final String message) {
        this.setText(this.getText() + "\n" + message);
    }
}
