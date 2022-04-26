package view.game.central;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logics.room.works.Room;
import utilis.ImageMethod;
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
				final GameButton jb = new GameButton(this);
				room.addToCells(new Pair<>(j, i), jb);
				this.add(jb);
			}
		}
	}

	/**
	 * Method to remove the objects at given position
	 * 
	 * @param pos the position of the object
	 */
	private void clearGameObject(Pair<Integer, Integer> pos) {
		room.getCells().get(pos).setSprite(new JLabel(""));
	}

	/**
	 * Method to change the player position
	 * 
	 * @param oldPos the old position of the player
	 * @param newPos the new position of the player
	 */
	private void movePlayer(Pair<Integer, Integer> oldPos, Pair<Integer, Integer> newPos) {
		clearGameObject(oldPos);
		room.getCells().get(newPos).setSprite(new JLabel(ImageMethod.getImageIcon("player/player.png")));
	}
}
