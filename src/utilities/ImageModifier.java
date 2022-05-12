package utilities;

import java.awt.Dimension;
import java.awt.Image;

public class ImageModifier {

	/**
	 * Method that return a scaled image maintaining the aspect ratio
	 * 
	 * @param image the image to resize
	 * @param size  the dimension to resize
	 * @return an image scaled with the same aspect ratio (not stretched)
	 */
	public static final Image scaleMaintainingAspectRatio(Image image, Dimension size) {
		double scaleFactor = Math.min(1d,
				getScaleFactorToFit(new Dimension(image.getWidth(null), image.getHeight(null)), size));
		int scaleWidth = (int) Math.round(image.getWidth(null) * scaleFactor);
		int scaleHeight = (int) Math.round(image.getHeight(null) * scaleFactor);
		return image.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
	}

	private static final double getScaleFactorToFit(Dimension original, Dimension toFit) {
		double dScale = 1d;
		if (original != null && toFit != null) {
			double dScaleWidth = (double) toFit.width / (double) original.width;
			double dScaleHeight = (double) toFit.height / (double) original.height;
			dScale = Math.min(dScaleHeight, dScaleWidth);
		}
		return dScale;
	}

	/**
	 * @param img the image that will be scaled
	 * @return the image scaled with the dimension of your screen
	 */
	public static final Image scaleFullScreen(Image img) {
		return scaleWithDimension(img, new Dimension(Constant.WIDTH, Constant.HEIGHT));
	}

	/**
	 * 
	 * @param img the image that will be scaled
	 * @param dim the dimension your image will be
	 * @return the image scaled with the dimension you passed
	 */
	public static final Image scaleWithDimension(Image img, Dimension dim) {
		return img.getScaledInstance((int) dim.getWidth(), (int) (dim.getHeight()), Image.SCALE_DEFAULT);
	}

}
