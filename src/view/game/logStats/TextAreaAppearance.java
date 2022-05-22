package view.game.logStats;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import utilities.Constant;

/**
 * 
 * Sets the appearance of stats and log text areas.
 *
 */

public class TextAreaAppearance extends JTextPane {

    private static final long serialVersionUID = 7460837470380147330L;

    /**
     * Sets appearance of the JTextPane
     */

    public TextAreaAppearance() {
        super.setEditable(false);
        super.setBorder(generateBorder(20, 10, 20, 0));
        super.setOpaque(false);
        super.setForeground(Color.WHITE);
        super.setFont(Constant.genericFont("Arial", Font.PLAIN, 20));
        this.setHighlighter(null);
    }

    /**
     * @param top    : top padding value to be scaled
     * @param left   : left padding value to be scaled
     * @param bottom : bottom padding value to be scaled
     * @param right  : right padding value to be scaled
     * @return an EmptyBorder to set JTextPane padding.
     */

    private EmptyBorder generateBorder(final int top, final int left, final int bottom, final int right) {
        return new EmptyBorder(Constant.verticalAspectRatio(top), Constant.horizontalAspectRatio(left),
                Constant.verticalAspectRatio(bottom), Constant.horizontalAspectRatio(right));
    }
}
