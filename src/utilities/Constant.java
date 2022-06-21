package utilities;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.Random;

/**
 * 
 * Class that will contain all constant variable and method
 *
 */
public final class Constant {

  public static final GraphicsDevice SCREEN = GraphicsEnvironment.getLocalGraphicsEnvironment()
      .getDefaultScreenDevice();
  public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
  public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
  public static final int TOP_HEIGHT = 3 * HEIGHT / 4;
  public static final int ACTION_HEIGHT = HEIGHT / 4;
  public static final int GAME_WIDTH = 11 * WIDTH / 17;
  public static final int LABEL_WIDTH = 3 * WIDTH / 17;

  public static final Random RANDOM = new Random();

  private static final Dimension ASPECT_RATIO = new Dimension(1920, 1080);

  private Constant() {

  }

  /**
   * @param value : the number of pixel that we want the ratio
   * @return the number of pixel that matches to the same in 1920
   */
  public static int horizontalAspectRatio(final int value) {
    return WIDTH * value / (int) ASPECT_RATIO.getWidth();
  }

  /**
   * @param value : the number of pixel that we want the ratio
   * @return the number of pixel that matches to the same in 1080
   */
  public static int verticalAspectRatio(final int value) {
    return HEIGHT * value / (int) ASPECT_RATIO.getHeight();
  }

  /**
   * @param fontName  : the name of the font like Arial
   * @param fontStyle : the style of the font like Plain or Bold
   * @param fontSize  : the size of the font in pixels
   * @return a new font with the passed param
   */
  public static Font genericFont(final String fontName, final int fontStyle, final int fontSize) {
    return new Font(fontName, fontStyle, horizontalAspectRatio(fontSize));
  }
}
