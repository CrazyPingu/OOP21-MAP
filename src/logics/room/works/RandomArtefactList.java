package logics.room.works;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import logics.game_object.artefact.ActionNumberArtefactFactoryImpl;
import logics.game_object.artefact.Artefact;
import logics.game_object.artefact.HealthArtefactFactoryImpl;
import logics.game_object.artefact.MovementArtefactFactoryImp;
import logics.game_object.artefact.WeaponArtefactFactoryImpl;
import logics.game_object.entity.Player;
import logics.game_object.entity.SimpleEnemy;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Class that is a random generated List with random artefact
 *
 */
public class RandomArtefactList extends ArrayList<Artefact> {

	private static final long serialVersionUID = -6692451133647329784L;
	private Map<Object, Integer> factoryOfArtefact = new HashMap<>();

	/**
	 * @param size the size of the room
	 */
	public RandomArtefactList(Pair<Integer, Integer> size, List<SimpleEnemy> enemyList,Player player) {
		factoryOfArtefact.put(new WeaponArtefactFactoryImpl(), new WeaponFactoryImpl().getClass().getDeclaredMethods().length);
		factoryOfArtefact.put(new HealthArtefactFactoryImpl(), new HealthArtefactFactoryImpl().getClass().getDeclaredMethods().length);
		factoryOfArtefact.put(new ActionNumberArtefactFactoryImpl(),new ActionNumberArtefactFactoryImpl().getClass().getDeclaredMethods().length);
		factoryOfArtefact.put(new MovementArtefactFactoryImp(), new MovementArtefactFactoryImp().getClass().getDeclaredMethods().length);
		Pair<Integer, Integer> artefactPos;
		for (int i = 0; i < size.getX() * size.getY() / RoomConstant.SPAWNING_RATIO; i++) {
			do {
				artefactPos = new Pair<Integer, Integer>(new Random().ints(0, size.getX()).findFirst().getAsInt(),
						new Random().ints(0, size.getY()).findFirst().getAsInt());
			} while (RoomConstant.cellsOccupated(enemyList, this, player, artefactPos));
			generateRandomArtefact(generateRandomArtefactFactory(), artefactPos);
		}
	}

	/**
	 * 
	 * @param artefactFactory the artefactFactory that will be called
	 * @param pos             the position of the artefact generated
	 */
	private void generateRandomArtefact(Object artefactFactory, Pair<Integer, Integer> pos) {
		int random = (int) Math.random() * factoryOfArtefact.get(artefactFactory);
		Artefact generatedArtefact = null;
		try {
			generatedArtefact = (Artefact) artefactFactory.getClass().getDeclaredMethods()[random]
					.invoke(artefactFactory, pos);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error during artefact generation");
		}
		this.add(generatedArtefact);

	}

	/**
	 * @return a random ArtefactFactory
	 */
	private Object generateRandomArtefactFactory() {
		List<Object> keys = new ArrayList<Object>(factoryOfArtefact.keySet());
		Object obj = keys.get(new Random().nextInt(keys.size()));
		return obj;
	}
}
