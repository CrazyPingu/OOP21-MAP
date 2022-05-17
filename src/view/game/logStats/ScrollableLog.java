package view.game.logStats;

public class ScrollableLog extends ScrollPaneAppearance {

	private static final long serialVersionUID = -2513174390328036056L;

	private Log logMessage;

	public ScrollableLog(Log logMessage) {
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
