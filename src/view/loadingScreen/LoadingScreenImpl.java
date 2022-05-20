package view.loadingScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import controller.PageController;
import utilities.Constant;
import utilities.GbcDimension;
import utilities.ImageMethod;
import utilities.ImageModifier;

/**
 * 
 * JPanel that contain the loading screen
 *
 */
public class LoadingScreenImpl extends JPanel implements LoadingScreen, Runnable {

	private static final long serialVersionUID = 8291207301630291996L;
	private JProgressBar progressBar = new JProgressBar();
	private JLabel message = new JLabel("", SwingConstants.CENTER);
	private PageController pageController;

	/**
	 * {@inheritDoc}
	 */
	public LoadingScreenImpl(PageController pageController) {
		this.pageController = pageController;
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		addImage("aldoGiovanniEGiacomo.png");
		addText();
		addProgressBar();
		addMessage();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addImage(String fileName) {
		Image image = ImageModifier.scaleWithDimension(ImageMethod.getImage("loadingScreen/" + fileName),
				new Dimension(Constant.WIDTH/2, Constant.HEIGHT/2));
		add(new JLabel(new ImageIcon(image)), new GbcDimension(0, 0, 0, 80));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addText() {
		JLabel text = new JLabel("Marcello Apocalypse", SwingConstants.CENTER);
		text.setFont(new Font("Arial", Font.BOLD, 70));
		text.setForeground(Color.RED);
		add(text, new GbcDimension(0, 1, 0,80));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMessage() {
		message.setFont(Constant.genericFont("Arial", Font.BOLD, 70));
		add(message, new GbcDimension(0, 3, 0, 80));
		message.setForeground(Color.BLUE);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addProgressBar() {
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.RED);
		add(progressBar, new GbcDimension(0, 2, 640, 80));
	}

	/**
	 * {@inheritDoc}
	 */
	public void startProgressBar() {
		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		this.pageController.showLoadingScreen();
		int i = 0;
		while (i < 100) {
			try {
				Thread.sleep(20);
				this.progressBar.setValue(i);
				this.message.setText("LOADING " + Integer.toString(i) + "%");
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.pageController.showGame();
	}
}