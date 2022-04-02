package view.loadingScreen;

import view.basicFrame;

/**
 * 
 * Interface to generate a LoadingScreen
 *
 */
public interface LoadingScreen {

	/**
	 * @param name : the file name of the image
	 */
	public void addImage(String name);

	/**
	 * Add the title "Marcello Apocalypse"
	 */
	public void addText();

	/**
	 * Method to add a progress bar
	 */
	public void addProgressBar();

	/**
	 * Method to add in the JPanel a JLabel that display the percentage value of the
	 * progress bar
	 */
	public void addMessage();

	/**
	 * 
	 * @param frame             : the frame where I'm currently working
	 * @param currentCardLayout : the name of the CardLayout of this LoadingScreen
	 * @param guiCardLayout     : the name of the CardLayout that will be shown when
	 *                          the progress bar reach 100%
	 */
	public void runningPBar(basicFrame frame, String currentCardLayout, String guiCardLayout);

}
