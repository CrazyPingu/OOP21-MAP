package view.game.central;

import javax.swing.JButton;
import javax.swing.JPanel;
import logics.room.works.Room;
import utilis.Pair;

public class GameArea extends JPanel {

	private static final long serialVersionUID = 2941617427011748438L;
	private Room room;
	private Pair<Integer, Integer> size;

	public GameArea(Room room) {
		this.room = room;
		this.size = room.getSize();
		this.setOpaque(false);
		placeCells(room.getSize(), room);
	}

	private void placeCells(Pair<Integer, Integer> size, Room room) {
		for (int i = 0; i < size.getX(); i++) {
			for (int j = 0; j < size.getY(); j++) {
				JButton jb = new JButton();
				room.addToCells(size, jb);
				this.add(jb);
			}
		}
	}

}
