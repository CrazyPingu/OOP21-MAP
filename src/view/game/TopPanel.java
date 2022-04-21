package view.game;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

import logics.room.works.Room;
import utilis.Constant;
import utilis.GbcDimension;
import view.game.central.GameArea;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = 3295995931719233232L;

	public TopPanel(Room room) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
//		Log log = new Log();
//		this.add(log, new GbcDimension(0, 0, Constant.WIDTH / 5, 2 * Constant.HEIGHT / 3));

		GameArea gameArea = new GameArea(room);
		this.add(gameArea, new GbcDimension(1, 0, 3 * Constant.WIDTH / 5, 2 * Constant.HEIGHT / 3));

//		Stats stats = new stats();
//		this.add(log, new GbcDimension(2, 0, Constant.WIDTH / 5, 2 * Constant.HEIGHT / 3));		
	}

}
