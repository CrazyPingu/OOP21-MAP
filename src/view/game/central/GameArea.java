package view.game.central;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.room.works.Room;
import utilities.Constant;
import utilities.ImageMethod;
import utilities.Pair;
import utilities.RoomConstant;

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
		this.initializeSprite();
		repaint();
	}

	/**
	 * Method that, given the room it initialize the game sprite
	 */
	private void initializeSprite() {
		this.drawEnemyFromList(this.room.getEnemyList());
		this.drawArtefactFromList(this.room.getArtefactList());
		this.drawPlayer(this.room.getPlayer());
		this.drawDoor(this.room.getDoor());
	}

	/**
	 * Method that given the position of the door it draws it
	 * 
	 * @param door the position of the door
	 */
	private void drawDoor(List<Pair<Integer, Integer>> door) {
		for (var x : this.room.getCells().entrySet()) {
			if (door.contains(x.getKey())) {
				x.getValue().drawDoor();
			}
		}
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

	/**
	 * Method to move game object around the GameArea
	 * 
	 * @param oldPos the actual position of the GameObject
	 * @param newPos the position that the GameObject will go on
	 */
	public void moveGameObject(Pair<Integer, Integer> oldPos, Pair<Integer, Integer> newPos) {
		this.room.getCells().get(oldPos).removeSprite();
		this.room.updatePosition(oldPos, newPos);
		this.room.getCells().get(newPos).drawGameObject(room.getPlayer());
	}

	/**
	 * @param pos  the list of position to highlight
	 * @param flag the flag that will say which action the player is doing
	 */
	public void highlightCells(List<Pair<Integer, Integer>> pos, ActionFlag flag) {
		ImageIcon image = null;
		if (flag.equals(ActionFlag.ATTACK)) {
			image = RoomConstant.ATTACK_HIGHLIGHT;
		} else if (flag.equals(ActionFlag.MOVE)) {
			image = RoomConstant.MOVE_HIGHLIGHT;
		}
		for (var x : pos) {
			this.room.getCells().get(x).highlightCell(image);
		}
	}

}
