package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

import utilities.Constant;

public class MenuLabel extends JLabel {

  /**
   * 
   */
  private static final long serialVersionUID = -3673551791024448061L;

  /**
   * 
   * @param name : the string that label will show
   * @return the label with string passed
   */
  public MenuLabel(final String name) {
    this.setHorizontalAlignment(CENTER);
    this.setText(name);
    this.setForeground(Color.white);
    this.setPreferredSize(new Dimension(Constant.horizontalAspectRatio(500), Constant.verticalAspectRatio(100)));
    this.setFont(Constant.genericFont("Arial", Font.PLAIN, Constant.horizontalAspectRatio(80)));
  }

}
