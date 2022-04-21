package utilis;

import java.awt.Font;
import java.awt.Toolkit;

/**
 * 
 * Class that will contain all constant variable and method
 *
 */
public class Constant {
	
	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static final int TOP_HEIGHT = 3 * HEIGHT / 4;
	public static final int ACTION_HEIGHT = HEIGHT / 4;
	public static final int GAME_WIDTH = 11 * WIDTH / 17;
	public static final int LABEL_WIDTH = 3 * WIDTH / 17;
	
	
	/**
	 * @param value : the number of pixel that we want the ratio
	 * @return the number of pixel that matches to the same in 1920
	 */
	public static final int horizontalAspectRatio(int value) {
		return WIDTH * value / 1920;
	}
	
	/**
	 * @param value : the number of pixel that we want the ratio
	 * @return the number of pixel that matches to the same in 1080
	 */
	public static final int verticalAspectRatio(int value) {
		return HEIGHT * value / 1080;
	}
	 /**
         * @param fontName : the name of the font like Arial
         * @param fontStyle : the style of the font like Plain or Bold
         * @param fontSize : the size of the font in pixels
         * @return a new font with the passed param
         */
        public static final Font genericFont(String fontName, int fontStyle, int fontSize) {
            return new Font(fontName, fontStyle, horizontalAspectRatio(fontSize));
        }

}
