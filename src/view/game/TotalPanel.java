package view.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import logics.game_object.entity.Player;
import logics.room.works.Room;
import utilities.Constant;
import utilities.GbcDimension;
import view.game.central.GameArea;
import view.game.logStats.ScrollableLog;
import view.game.logStats.ScrollableStats;

public class TotalPanel extends JPanel {

	private static final long serialVersionUID = 3295995931719233232L;
	ScrollableLog log;
	GameArea gameArea;
	ScrollableStats stats;
	ActionMenu actionMenu;

	public TotalPanel(Room room) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.setBackground(Color.black);

		stats = new ScrollableStats(room.getPlayer());
		fixSize(Constant.LABEL_WIDTH, Constant.TOP_HEIGHT, stats);
		this.add(stats, new GbcDimension(0));

		gameArea = new GameArea(room);
		System.out.println(gameArea.getClass());
		fixSize(Constant.GAME_WIDTH, Constant.TOP_HEIGHT, gameArea);
		this.add(gameArea, new GbcDimension(1));

		log = new ScrollableLog();
		fixSize(Constant.LABEL_WIDTH, Constant.TOP_HEIGHT, log);
		this.add(log, new GbcDimension(2));

		actionMenu = new ActionMenu();
		fixSize(Constant.WIDTH, Constant.ACTION_HEIGHT, actionMenu);
		GbcDimension gbc = new GbcDimension(0, 1);
		gbc.gridwidth = 3;
		this.add(actionMenu, gbc);
	}

	private void fixSize(int width, int height, JComponent jComponent) {
		jComponent.setPreferredSize(new Dimension(width, height));
		jComponent.setMinimumSize(new Dimension(width, height));
		jComponent.setMaximumSize(new Dimension(width, height));

	}

	public ScrollableLog getScrollableLog() {
		return log;
	}

	public GameArea getGameArea() {
		return gameArea;
	}

	public ScrollableStats getScrollableStats() {
		return stats;
	}

	public ActionMenu getActionMenu() {
		return actionMenu;
	}
}
