package view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

import logics.room.works.Room;

/**
 * 
 * JPanel that will contain the top area of the game (with the stats, the log
 * and the gaming field) and the area for the action of the player
 *
 */
public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 5038270668520802248L;

	/**
	 * {@inheritDoc}
	 */
	public GameDisplay(Room room) {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.black);
		TopPanel top = new TopPanel(room);
		top.setOpaque(false);
		JPanel action = new JPanel();
		action.setOpaque(false);

		this.add(top, BorderLayout.NORTH);
		this.add(action, BorderLayout.SOUTH);
	}
}
