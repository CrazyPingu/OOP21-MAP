package view.game.logStats;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import utilis.Constant;

public class ScrollableLog extends JScrollPane {

	private static final long serialVersionUID = -2513174390328036056L;
	
	private static Log logMessage = new Log ();
	Border border;

	public ScrollableLog () {
		super(logMessage);
		this.setScroll();
	}
	
	/**
	 * Sets the appearance of the scroll pane.
	 */
	public void setScroll () {        
		this.setScrollBars();
		super.setBackground(Color.BLACK);
		super.setPreferredSize(new Dimension (Constant.WIDTH / 4,  Constant.HEIGHT * 2 / 3));
		border = BorderFactory.createLineBorder(Color.GRAY,3);
        this.setBorder(border);
	}
	
	/**
	 * Sets the appearance of the scroll bars.
	 */
	public void setScrollBars () {
		super.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		super.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		super.getVerticalScrollBar().setUnitIncrement(15);
		super.getVerticalScrollBar().setBackground(Color.BLACK);
		super.getHorizontalScrollBar().setBackground(Color.BLACK);
	}
	
	
	public Log getLogMessage() {
		return logMessage;
	}

}
