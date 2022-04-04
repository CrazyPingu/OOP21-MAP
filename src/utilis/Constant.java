package utilis;

import java.awt.Toolkit;

/**
 * 
 * Class that will contain all constant variable and method
 *
 */
public class Constant {

	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	/**
	 * @param value : the number of pixel that we want the ratio
	 * @return the number of pixel that matches to the same in 1920
	 */
	public static final int horizontalAspectRatio(int value) {
		return HEIGHT * value / 1920;
	}
	
	/**
	 * @param value : the number of pixel that we want the ratio
	 * @return the number of pixel that matches to the same in 1080
	 */
	public static final int verticalAspectRatio(int value) {
		return HEIGHT * value / 1080;
	}

}
