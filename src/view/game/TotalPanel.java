package view.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import controller.ActionMenuController;
import controller.GameAreaController;
import controller.PageController;
import model.game_statistics.GameStatisticsImpl;
import model.room.Room;
import utilities.Constant;
import utilities.GbcDimension;
import view.game.action.ActionMenu;
import view.game.central.GameArea;
import view.game.log_stats.Log;
import view.game.log_stats.ScrollableLog;
import view.game.log_stats.ScrollableStats;
import view.game.log_stats.Stats;

/**
 * 
 * The panel that rappresent the game, composed with the log, the stats the
 * action menu and the game area
 *
 */
public class TotalPanel extends JPanel {

  private static final long serialVersionUID = 3295995931719233232L;
  private final ScrollableLog log;
  private final GameArea gameArea;
  private final ScrollableStats stats;
  private final ActionMenu actionMenu;

  public TotalPanel(final Room room, final ActionMenuController actionMenuController,
      final GameAreaController gameAreaController, final PageController pageController,
      final GameStatisticsImpl gameStats) {
    this.setLayout(new GridBagLayout());
    this.setBackground(Color.black);

    stats = new ScrollableStats(room.getPlayer(), new Stats(), gameStats, room.getPlayer().getActionNumber());
    fixSize(Constant.LABEL_WIDTH, Constant.TOP_HEIGHT, stats);
    this.add(stats, new GbcDimension(0));

    gameArea = new GameArea(room, gameAreaController);
    fixSize(Constant.GAME_WIDTH, Constant.TOP_HEIGHT, gameArea);
    this.add(gameArea, new GbcDimension(1));

    log = new ScrollableLog(new Log());
    fixSize(Constant.LABEL_WIDTH, Constant.TOP_HEIGHT, log);
    this.add(log, new GbcDimension(2));

    this.actionMenu = new ActionMenu(pageController, actionMenuController);
    fixSize(Constant.WIDTH, Constant.ACTION_HEIGHT, actionMenu);
    final GbcDimension gbc = new GbcDimension(0, 1);
    gbc.gridwidth = 3;
    this.add(actionMenu, gbc);

  }

  private void fixSize(final int width, final int height, final JComponent jComponent) {
    jComponent.setPreferredSize(new Dimension(width, height));
    jComponent.setMinimumSize(new Dimension(width, height));
    jComponent.setMaximumSize(new Dimension(width, height));

  }

  /**
   * @return the log
   */
  public ScrollableLog getScrollableLog() {
    return log;
  }

  /**
   * @return the gameArea
   */
  public GameArea getGameArea() {
    return gameArea;
  }

  /**
   * @return the stats
   */
  public ScrollableStats getScrollableStats() {
    return stats;
  }

  /**
   * @return the action menu
   */
  public ActionMenu getActionMenu() {
    return actionMenu;
  }
}
