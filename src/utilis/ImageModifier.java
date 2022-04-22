package utilis;

import java.awt.*;
import javax.swing.JButton;

public class ImageModifier {

	// given the image, and the size of the button / label it will scale based on
	// your monitor
	public static final Image scale(Image image, Dimension size) {
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

	// given an image and the size of the button / label it will fill the
	public static final Image scaleFullScreen(Image img) {
		return img.getScaledInstance(Constant.WIDTH, Constant.HEIGHT, Image.SCALE_DEFAULT);
	}

	// given an image and the size of the button / label it will fill the
	public static final Image scaleStretch(Image img, Dimension dim) {
		return img.getScaledInstance((int) dim.getHeight(), (int) dim.getWidth(), Image.SCALE_DEFAULT);
	}

}
