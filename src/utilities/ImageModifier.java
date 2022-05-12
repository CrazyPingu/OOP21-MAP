package utilities;

import java.awt.Dimension;
import java.awt.Image;

public class ImageModifier {

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
