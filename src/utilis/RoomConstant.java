package utilis;

import java.util.List;

import logics.game_object.GameObject;
import logics.game_object.artefact.Artefact;
import logics.game_object.entity.SimpleEntity;

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
	public static SimpleEntity searchEnemy(Pair<Integer, Integer> pos, List<SimpleEntity> list) {
		for (var x : list) {
			if (x.getPos().equals(pos)) {
				return x;
			}
		}
		return null;
	}
}
