package view.loadingScreen;


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
	 * Start the progress bar and show the game at the end of it
	 */
	public void startProgressBar();

}
