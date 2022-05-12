package utilities;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * 
 * Class to work easily with images
 *
 */
public class ImageMethod {

	/**
	 * @param fileName : the name of the images (and his path from resources)
	 * @return the image correlated
	 */
	public static Image getImage(String fileName) {
		try {
			return ImageIO.read(ImageMethod.class.getResource("/resources/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param fileName : the name of the images (and his path from resources)
	 * @return the ImageIcon
	 */
	public static ImageIcon getImageIcon(String fileName) {
		return new ImageIcon(getImage(fileName));
	}
}
