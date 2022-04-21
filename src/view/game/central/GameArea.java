package view.game.central;

import javax.swing.JPanel;
import logics.room.works.Room;
import utilis.Pair;

public class GameArea extends JPanel{

	private static final long serialVersionUID = 2941617427011748438L;

	public GameArea(Room room) {
		placeCells(room.getSize());
	}

	private void placeCells(Pair<Integer, Integer> size) {
		
	}

}
