package utilities;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * 
 * Class to simplify the usage of the GridBagConstraints, adding more
 * constructor
 *
 */
public class GbcDimension extends GridBagConstraints {

  private static final long serialVersionUID = -6983927223360889689L;

  /**
   * @param gridx the horizontal position
   */
  public GbcDimension(final int gridx) {
    super();
    this.gridx = gridx;
  }

  /**
   * @param gridx the horizontal position
   * @param gridy the vertical position
   */
  public GbcDimension(final int gridx, final int gridy) {
    super();
    this.gridx = gridx;
    this.gridy = gridy;
  }

  /**
   * @param gridx the horizontal position
   * @param gridy the vertical position
   * @param ipadx the lenght
   */
  public GbcDimension(final int gridx, final int gridy, final int ipadx) {
    super();
    this.gridx = gridx;
    this.gridy = gridy;
    this.ipadx = Constant.horizontalAspectRatio(ipadx);
  }

  /**
   * @param gridx the horizontal position
   * @param gridy the vertical position
   * @param ipadx the lenght
   * @param ipady the height
   */
  public GbcDimension(final int gridx, final int gridy, final int ipadx, final int ipady) {
    super();
    this.gridx = gridx;
    this.gridy = gridy;
    this.ipadx = Constant.horizontalAspectRatio(ipadx);
    this.ipady = Constant.verticalAspectRatio(ipady);
  }

  /**
   * @param gridx  the horizontal position
   * @param gridy  the vertical position
   * @param ipadx  the lenght
   * @param ipady  the height
   * @param insets the padding space through component
   */
  public GbcDimension(final int gridx, final int gridy, final int ipadx, final int ipady, final Insets insets) {
    super();
    this.gridx = gridx;
    this.gridy = gridy;
    this.ipadx = Constant.horizontalAspectRatio(ipadx);
    this.ipady = Constant.verticalAspectRatio(ipady);
    this.insets = insets;
  }

  /**
   * @param gridy  the vertical position
   * @param insets the padding space through component
   */
  public GbcDimension(final int gridy, final Insets insets) {
    super();
    this.gridy = gridy;
    this.ipady = Constant.verticalAspectRatio(ipady);
    this.insets = insets;
  }

  /**
   * 
   * @param top    the space from the top
   * @param left   the space from the left
   * @param bottom the space from the bottom
   * @param right  the space from the right
   * @return the insets with the passed value scaled in 1920 x 1080
   */
  public static Insets createInsets(final int top, final int left, final int bottom, final int right) {
    return new Insets(Constant.verticalAspectRatio(top), Constant.horizontalAspectRatio(left),
        Constant.verticalAspectRatio(bottom), Constant.horizontalAspectRatio(right));
  }

}