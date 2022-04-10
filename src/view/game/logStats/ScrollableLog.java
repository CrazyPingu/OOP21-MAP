package view.game.logStats;

import java.awt.*;
import javax.swing.*;

import utilis.Constant;

public class ScrollableLog extends JScrollPane {

	private static final long serialVersionUID = -2513174390328036056L;
	
	private static LogImpl logMessage = new LogImpl ();

	public ScrollableLog () {
		super(logMessage);
		this.setScroll();
	}
	
	/**
	 * Sets the appearance of the scrolling bar.
	 */
	public void setScroll () {
		
	}
	
	
	public LogImpl getLogMessage() {
		return logMessage;
	}

}
