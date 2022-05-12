package utilis;

import java.util.List;

import logics.game_object.GameObject;
import logics.game_object.artefact.Artefact;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;

public class RoomConstant {

	public static final int SPAWNING_RATIO = 30;
	public static final int FORBIDDEN_ZOMBIE_SPAWN = 3;

	public static final int MAX_X = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 15);
	public static final int MAX_Y = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 10);

	public static final int MIN_X = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 6);
	public static final int MIN_Y = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 5);

	/**
	 * @param pos            the position of the GameObject to be found
	 * @param gameObjectList the list of GameObject to search out
	 * @return the gameObject if found, else null
	 */
	public static GameObject findGameObject(Pair<Integer, Integer> pos, List<GameObject> gameObjectList) {
		for (var x : gameObjectList) {
			if (x.getPos().equals(pos)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * @param pos  the position of the Artefact to be found
	 * @param list the list of artefact to search out
	 * @return the artefact if found, else null
	 */
	public static Artefact searchArtefact(Pair<Integer, Integer> pos, List<Artefact> list) {
		for (var x : list) {
			if (x.getPos().equals(pos)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * @param pos  the position of the SimpleEntity to be found
	 * @param list the list of SimpleEntity to search out
	 * @return the SimpleEntity if found, else null
	 */
	public static SimpleEnemy searchEnemy(Pair<Integer, Integer> pos, List<SimpleEnemy> list) {
		for (var x : list) {
			if (x.getPos().equals(pos)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * @param enemyList    the list of the enemy
	 * @param artefactList the list of the artefact
	 * @param player       the player
	 * @param pos          the position to check
	 * @return true if an enemy, the player or a artefact is in that position, else
	 *         false
	 */
	public static boolean cellsOccupated(List<SimpleEnemy> enemyList, List<Artefact> artefactList, Player player,
			Pair<Integer, Integer> pos) {
		return player.getPos().equals(pos) || searchEnemy(pos, enemyList) != null
				|| searchArtefact(pos, artefactList) != null;
	}
}
