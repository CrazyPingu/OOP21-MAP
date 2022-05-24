package view.game.log_stats;

public class ScrollableLog extends ScrollPaneAppearance {

    private static final long serialVersionUID = -2513174390328036056L;
    
    @SuppressWarnings("PMD.ProperLogger")
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
