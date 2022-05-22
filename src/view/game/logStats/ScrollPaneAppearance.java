package view.game.logStats;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import utilities.Constant;

public class ScrollPaneAppearance extends JScrollPane {

    private static final long serialVersionUID = 7085461478629284287L;

    private final Border border = BorderFactory.createLineBorder(Color.GRAY, 3);

    public ScrollPaneAppearance(final Component c) {
        super(c);
    }

    /**
     * Sets the appearance of the scroll pane.
     */
    public void setScrollPaneAppearance() {
        this.setScrollBar();
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setPreferredSize(new Dimension(Constant.LABEL_WIDTH, Constant.TOP_HEIGHT));
        this.setBorder(border);
    }

    /**
     * Sets the appearance of the scroll bars.
     */
    public void setScrollBar() {
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(15);
        this.getVerticalScrollBar().setOpaque(false);
    }

}
