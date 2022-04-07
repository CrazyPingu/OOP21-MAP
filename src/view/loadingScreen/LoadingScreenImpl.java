package view.loadingScreen;

import javax.imageio.ImageIO;
import javax.swing.*;

import utilis.Constant;
import utilis.GBCDimension;
import utilis.ImageModifier;
import view.frame.BasicFrame;

import java.awt.*;
import java.io.IOException;


/**
 * 
 * JPanel that contain the loading screen
 *
 */
public class LoadingScreenImpl extends JPanel implements LoadingScreen {

	private static final long serialVersionUID = 8291207301630291996L;
	JProgressBar progressBar = new JProgressBar();
	JLabel message = new JLabel("", SwingConstants.CENTER);

	/**
	 * {@inheritDoc}
	 */
	public LoadingScreenImpl() {
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
		try {
			Image image = ImageIO.read(getClass().getResource("/resources/loadingScreen/" + fileName));
			ImageIcon imageScaled = new ImageIcon(ImageModifier.scale(image, new Dimension(Constant.WIDTH / 2, Constant.HEIGHT / 2)));
			add(new JLabel(imageScaled), GBCDimension.setDimension(0, 0, 0, Constant.verticalAspectRatio(80)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addText() {
		JLabel text = new JLabel("Marcello Apocalypse", SwingConstants.CENTER);
		text.setFont(new Font("arial", Font.BOLD, Constant.horizontalAspectRatio(70)));
		text.setForeground(Color.RED);
		add(text, GBCDimension.setDimension(0, 1, 0, Constant.verticalAspectRatio(80)));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMessage() {
		message.setFont(Constant.genericFont("Arial", Font.BOLD, 70));
		add(message, GBCDimension.setDimension(0, 3, 0, Constant.verticalAspectRatio(80)));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addProgressBar() {
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.RED);
		progressBar.setPreferredSize(new Dimension(Constant.WIDTH / 3, Constant.HEIGHT / 102));
		add(progressBar, GBCDimension.setDimension(0, 2, 0, Constant.verticalAspectRatio(80)));
	}

	/**
	 * {@inheritDoc}
	 */
	public void runningPBar(BasicFrame frame, String currentCardLayout, String guiCardLayout) {
		frame.showInFrame(currentCardLayout);
		int i = 0;
		while (i < 100) {
			try {
				Thread.sleep(20);
				this.progressBar.setValue(i);
				this.message.setForeground(Color.BLUE);
				this.message.setText("LOADING " + Integer.toString(i) + "%");
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		frame.showInFrame(guiCardLayout);
	}
}