package utilis;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageMethod {

	public static Image getImage(String fileName) {
		try {
			return ImageIO.read(ImageMethod.class.getResource("/resources/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ImageIcon getImageIcon(String fileName) {
		return new ImageIcon(getImage(fileName));
	}
}
