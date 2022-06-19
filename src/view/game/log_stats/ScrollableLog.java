package view.game.log_stats;

/**
 * 
 * Sets a scrollable type of log text area.
 *
 */
public class ScrollableLog extends ScrollPaneAppearance {

    private static final long serialVersionUID = -2513174390328036056L;

    private final Log logMessage;

    public ScrollableLog(final Log logMessage) {
        super(logMessage);
        this.logMessage = logMessage;
        this.setScrollPaneAppearance();
    }

    /**
     * @return log message implemented as JTextPane.
     */
    public Log getLogMessage() {
        return this.logMessage;
    }

}
