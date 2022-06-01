package model.room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.game_object.artefact.Artefact;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.room.works.RandomArtefactList;
import model.room.works.RandomEnemyList;
import utilities.Pair;
import utilities.RoomConstant;
import view.game.central.GameButton;

/**
 * 
 * Create the room designed by the passed value implementing the room interface.
 *
 */
public class RoomImpl implements Room {
  private final Pair<Integer, Integer> size;
  private final Map<Pair<Integer, Integer>, GameButton> cells;
  private final List<SimpleEnemy> enemyList;
  private final List<Artefact> artefactList;
  private Player player;
  private final List<Pair<Integer, Integer>> door;

  /**
   * @param size         the size of the room.
   * @param player       the player of the game
   * @param newPosPlayer the new position of the player
   */
  @SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
  public RoomImpl(final Pair<Integer, Integer> size, final Player player, final Pair<Integer, Integer> newPosPlayer) {
    player.setPos(newPosPlayer);
    this.size = size;
    this.player = player;
    this.cells = new HashMap<>();
    this.door = this.generateDoor(size);
    this.enemyList = new RandomEnemyList(size, player, door);
    this.artefactList = new RandomArtefactList(size, enemyList, player, door);
  }

  @Override
  public boolean playerOnDoor() {
    return this.door.contains(this.player.getPos());
  }

  @Override
  public List<Pair<Integer, Integer>> generateDoor(final Pair<Integer, Integer> size) {
    final List<Pair<Integer, Integer>> tmp = new ArrayList<>();
    tmp.add(new Pair<Integer, Integer>(size.getX() - 1, size.getY() / 2));
    if (size.getY() % 2 == 0) {
      tmp.add(new Pair<Integer, Integer>(size.getX() - 1, size.getY() / 2 - 1));
    }
    return tmp;
  }

  @Override
  public void addButtonToCells(final Pair<Integer, Integer> pos, final GameButton button) {
    this.cells.put(pos, button);
  }

  @Override
  public void updatePosition(final Pair<Integer, Integer> oldPos, final Pair<Integer, Integer> newPos) {
    if (RoomConstant.searchEnemy(oldPos, enemyList) != null) {
      RoomConstant.searchEnemy(oldPos, enemyList).setPos(newPos);
    } else if (this.player.getPos().equals(oldPos)) {
      this.player.setPos(newPos);
    }
  }

  @Override
  public void removeObject(final Pair<Integer, Integer> pos) {
    if (RoomConstant.searchEnemy(pos, enemyList) != null) {
      enemyList.remove(RoomConstant.searchEnemy(pos, enemyList));
    } else if (RoomConstant.searchArtefact(pos, artefactList) != null) {
      artefactList.remove(RoomConstant.searchArtefact(pos, artefactList));
    } else if (player.getPos().equals(pos)) {
      player = null;
    }
  }

  @Override
  public Map<Pair<Integer, Integer>, GameButton> getCells() {
    return this.cells;
  }

  @Override
  public Pair<Integer, Integer> getSize() {
    return this.size;
  }

  @Override
  public List<SimpleEnemy> getEnemyList() {
    return this.enemyList;
  }

  @Override
  public List<Artefact> getArtefactList() {
    return this.artefactList;
  }

  @Override
  public Player getPlayer() {
    return this.player;
  }

  @Override
  public List<Pair<Integer, Integer>> getDoor() {
    return this.door;
  }
}
