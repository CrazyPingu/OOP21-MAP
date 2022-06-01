package utilities;

import java.awt.Dimension;
import java.awt.Image;

public final class ImageModifier {

  private ImageModifier() {

  }

  /**
   * Method that return a scaled image maintaining the aspect ratio
   * 
   * @param image the image to resize
   * @param size  the dimension to resize
   * @return an image scaled with the same aspect ratio (not stretched)
   */
  public static Image scaleMaintainingAspectRatio(final Image image, final Dimension size) {
    final double scaleFactor = getScaleFactorToFit(new Dimension(image.getWidth(null), image.getHeight(null)), size);
    final int scaleWidth = (int) Math.round(image.getWidth(null) * scaleFactor);
    final int scaleHeight = (int) Math.round(image.getHeight(null) * scaleFactor);
    return image.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
  }

  private static double getScaleFactorToFit(final Dimension original, final Dimension toFit) {
    double dScale = 0;
    if (original != null && toFit != null) {
      final double dScaleWidth = (double) toFit.width / (double) original.width;
      final double dScaleHeight = (double) toFit.height / (double) original.height;
      dScale = Math.min(dScaleHeight, dScaleWidth);
    }
    return dScale;
  }

  /**
   * @param img the image that will be scaled
   * @return the image scaled with the dimension of your screen
   */
  public static Image scaleFullScreen(final Image img) {
    return scaleWithDimension(img, new Dimension(Constant.WIDTH, Constant.HEIGHT));
  }

  /**
   * 
   * @param img the image that will be scaled
   * @param dim the dimension your image will be
   * @return the image scaled with the dimension you passed
   */
  public static Image scaleWithDimension(final Image img, final Dimension dim) {
    return img.getScaledInstance((int) dim.getWidth(), (int) (dim.getHeight()), Image.SCALE_DEFAULT);
  }
}
