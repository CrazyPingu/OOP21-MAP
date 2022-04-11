package view.game.logStats;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import utilis.Constant;

public class ScrollPaneAppearance extends JScrollPane {

	private static final long serialVersionUID = 7085461478629284287L;

	private final Border border = BorderFactory.createLineBorder(Color.GRAY, 3);

	public ScrollPaneAppearance(Component c) {
		super(c);
	}

	/**
	 * Sets the appearance of the scroll pane.
	 */
	public void setScrollPaneAppearance() {
		this.setScrollBar();
		super.setOpaque(false);
		super.getViewport().setOpaque(false);
		super.setPreferredSize(new Dimension(Constant.WIDTH / 4, Constant.HEIGHT * 2 / 3));
		super.setBorder(border);
	}

	/**
	 * Sets the appearance of the scroll bars.
	 */
	public void setScrollBar() {
		super.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		super.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		super.getVerticalScrollBar().setUnitIncrement(15);
		super.getVerticalScrollBar().setOpaque(false);
	}

}
