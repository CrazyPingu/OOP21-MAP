package view.game;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logics.entity.Player;
import logics.room.works.Room;
import utilis.Constant;
import utilis.GbcDimension;
import view.game.central.GameArea;

public class TotalPanel extends JPanel {

	private static final long serialVersionUID = 3295995931719233232L;

	public TotalPanel(Room room, Player player) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		ScrollableLog log = new ScrollableLog();
		fixSize(Constant.LABEL_WIDTH, Constant.TOP_HEIGHT, log);
		this.add(log, new GbcDimension(0, 0));

		GameArea gameArea = new GameArea(room);
		System.out.println(gameArea.getClass());
		fixSize(Constant.GAME_WIDTH, Constant.TOP_HEIGHT, gameArea);
		this.add(gameArea, new GbcDimension(1));

		ScrollableStats stats = new ScrollableStats(player);
		fixSize(Constant.LABEL_WIDTH, Constant.TOP_HEIGHT, stats);
		this.add(stats, new GbcDimension(2));

		ActionMenu action = new ActionMenu();
		fixSize(Constant.WIDTH, Constant.ACTION_HEIGHT, action);
		GbcDimension gbc = new GbcDimension(0, 1);
		gbc.gridwidth = 3;
		this.add(action, gbc);
	}

	private void fixSize(int width, int height, Object o) {
		if (contains(o, "ScrollableLog") || contains(o, "ScrollableStats") || contains(o, "GameArea")
				|| contains(o, "ActionMenu")) {
			((JComponent) o).setPreferredSize(new Dimension(width, height));
			((JComponent) o).setMinimumSize(new Dimension(width, height));
			((JComponent) o).setMaximumSize(new Dimension(width, height));
		}
	}

	private boolean contains(Object o, String classToCheck) {
		return o.getClass().toString().contains(classToCheck);
	}
}
