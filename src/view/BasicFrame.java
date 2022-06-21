package view;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.CardName;
import utilities.Constant;

/**
 * 
 * Class to create the frame that will contain the whole GUI using the CardLayout
 * 
 */
public class BasicFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  CardLayout cardLayout;
  JPanel panel;

  /**
   * Create a new JFrame based on CardLayout
   */
  public BasicFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setUndecorated(true);
    Constant.SCREEN.setFullScreenWindow(this);
    cardLayout = new CardLayout();
    panel = new JPanel(cardLayout);
    panel.setBackground(Color.black);
    add(panel);
  }

  /**
   * @param cardName : the name of the CardLayout that will be shown
   */
  public void showInFrame(final CardName cardName) {
    this.cardLayout.show(this.panel, cardName.name());
  }

  /**
   * @param panel    : the current panel to add
   * @param cardName : the name to give to the CardLayout
   */
  public void addToCardLayout(final JPanel panel, final CardName cardName) {
    this.panel.add(panel, cardName.name());
  }
}
