package view.game.logStats;

public class ScrollableLog extends ScrollPaneAppearance {

	private static final long serialVersionUID = -2513174390328036056L;

	private static Log logMessage = new Log();

	public ScrollableLog() {
		super(logMessage);
		this.setScrollPaneAppearance();
	}
	
	/**
	 * @return log message implemented as JTextPane.
	 */
	public static Log getLogMessage() {
		return logMessage;
	}

}
