package view.loadingScreen;

import javax.imageio.ImageIO;
import javax.swing.*;

import utilis.ImageModifier;
import view.basicFrame;
import java.awt.*;
import java.io.IOException;


/**
 * 
 * JPanel that contain the loading screen
 *
 */
public class LoadingScreenImpl extends JPanel implements LoadingScreen {

	private static final long serialVersionUID = 1L;
	private static final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	JProgressBar progressBar = new JProgressBar();
	JLabel message = new JLabel("", SwingConstants.CENTER);

	/**
	 * {@inheritDoc}
	 */
	public LoadingScreenImpl() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.black);
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
			Image image = ImageIO.read(getClass().getResource("resources/loadingScreen/" + fileName));
			ImageIcon imageScaled = new ImageIcon(ImageModifier.scale(image, new Dimension(width / 2, height / 2)));
			add(new JLabel(imageScaled), setDimensionObj(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	private GridBagConstraints setDimensionObj(int gridy) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = gridy;
		c.ipady = 80;
		return c;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addText() {
		JLabel text = new JLabel("Marcello Apocalypse", SwingConstants.CENTER);
		text.setFont(new Font("arial", Font.BOLD, width / 30));
		text.setForeground(Color.RED);
		add(text, setDimensionObj(1));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addMessage() {
		message.setFont(new Font("arial", Font.BOLD, width / 60));
		add(message, setDimensionObj(3));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addProgressBar() {
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.RED);
		progressBar.setPreferredSize(new Dimension(width / 3, height / 102));
		add(progressBar, setDimensionObj(2));
	}

	/**
	 * {@inheritDoc}
	 */
	public void runningPBar(basicFrame frame, String currentCardLayout, String guiCardLayout) {
		frame.showInFrame("currentCardLayout");
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