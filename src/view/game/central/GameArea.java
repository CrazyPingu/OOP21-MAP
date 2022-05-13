package view.game.central;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.room.works.Room;
import utilities.Constant;
import utilities.Pair;

/**
 * 
 * Class to manage to central area of the game view
 *
 */
public class GameArea extends JPanel {

	private static final long serialVersionUID = 2941617427011748438L;
	private Room room;
	private Pair<Integer, Integer> size;
	private Dimension buttonDimension;

	public GameArea(Room room) {
		this.setOpaque(false);
		this.changeRoom(room);
	}

	/**
	 * Method that given a room it will place it on the GameArea, removing the last
	 * one
	 * 
	 * @param room the room to replace the older one
	 */
	public void changeRoom(Room room) {
		this.room = room;
		this.size = room.getSize();
		this.setLayout(new GridLayout(size.getY(), size.getX()));
		this.removeAll();
		this.buttonDimension = new Dimension(Constant.GAME_WIDTH / size.getX(), Constant.TOP_HEIGHT / size.getY());
		this.placeCells();
		this.initializeSprite(room);
		repaint();
	}

	/**
	 * Method that, given the room it initialize the game sprite
	 */
	private void initializeSprite(Room room) {
		this.drawEnemyFromList(this.room.getEnemyList());
		this.drawArtefactFromList(this.room.getArtefactList());
		this.drawPlayer(room.getPlayer());
	}

	/**
	 * Method to place the GameButton inside the GameArea and add them in the room
	 * cells
	 */
	private void placeCells() {
		for (int i = 0; i < size.getY(); i++) {
			for (int j = 0; j < size.getX(); j++) {
				final GameButton jb = new GameButton(buttonDimension);
				room.addButtonToCells(new Pair<Integer, Integer>(j, i), jb);
				this.add(jb);
			}
		}
	}

	/**
	 * Method that given a list of enemy it draws them in the correct position
	 * 
	 * @param enemyList the list of SimpleEnemy to draw
	 */
	private void drawEnemyFromList(List<SimpleEnemy> enemyList) {
		if (enemyList != null && !enemyList.isEmpty()) {
			for (SimpleEnemy enemy : enemyList) {
				this.room.getCells().get(enemy.getPos()).drawGameObject(enemy);
			}
		}
	}

	/**
	 * Method that given a list of artefact it draws them in the correct position
	 * 
	 * @param artefactList the list of Artefact to draw
	 */
	private void drawArtefactFromList(List<Artefact> artefactList) {
		if (artefactList != null && !artefactList.isEmpty()) {
			for (Artefact artefact : artefactList) {
				this.room.getCells().get(artefact.getPos()).drawGameObject(artefact);
			}
		}

	}

	/**
	 * Method that given a player it draws him
	 * 
	 * @param player the player to draw
	 */
	private void drawPlayer(Player player) {
		if (player != null) {
			this.room.getCells().get(player.getPos()).drawGameObject(player);
		}
	}

	/**
	 * @return the room of the game
	 */
	public Room getRoom() {
		return room;
	}

}
