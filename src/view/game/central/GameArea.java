package view.game.central;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logics.room.works.Room;
import utilis.Pair;

/**
 * 
 * Class to manage to central area of the game view
 *
 */
public class GameArea extends JPanel {

	private static final long serialVersionUID = 2941617427011748438L;
	private Room room;
	private Pair<Integer, Integer> size;

	public GameArea(Room room) {
		this.room = room;
		this.size = room.getSize();
		this.setOpaque(false);
		this.setLayout(new GridLayout(size.getX(), size.getY()));
		placeCells();
	}

	/**
	 * Method to place the GameButton inside the GameArea
	 */
	private void placeCells() {
		for (int i = 0; i < size.getX(); i++) {
			for (int j = 0; j < size.getY(); j++) {
				final GameButton jb = new GameButton();
				room.addToCells(new Pair<>(j, i), jb);
				this.add(jb);
			}
		}
	}

	/**
	 * Method to remove all the objects from the room
	 */
	public void clearButton() {
		room.getCells().entrySet().forEach(x -> x.getValue().setSprite(new JLabel("")));
	}

}
