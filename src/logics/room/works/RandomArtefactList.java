package logics.room.works;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import logics.game_object.GameObject;
import logics.game_object.artefact.ActionNumberArtefactFactoryImpl;
import logics.game_object.artefact.HealthArtefactFactoryImpl;
import logics.game_object.artefact.MovementArtefactFactoryImp;
import logics.strategy.weapon.WeaponFactoryImpl;
import utilis.Constant;
import utilis.Pair;

public class RandomArtefactList extends ArrayList<GameObject> {

	private static final long serialVersionUID = -6692451133647329784L;
	private Map<Object, Integer> factoryOfArtefact = new HashMap<>();

	public RandomArtefactList(Pair<Integer, Integer> size) {
		factoryOfArtefact.put(new WeaponFactoryImpl(), new WeaponFactoryImpl().getClass().getDeclaredMethods().length);
		factoryOfArtefact.put(new HealthArtefactFactoryImpl(),
				new HealthArtefactFactoryImpl().getClass().getDeclaredMethods().length);
		factoryOfArtefact.put(new ActionNumberArtefactFactoryImpl(),
				new ActionNumberArtefactFactoryImpl().getClass().getDeclaredMethods().length);
		factoryOfArtefact.put(new MovementArtefactFactoryImp(),
				new MovementArtefactFactoryImp().getClass().getDeclaredMethods().length);

		Pair<Integer, Integer> artefactPos;
		for (int i = 0; i < size.getX() * size.getY() / Constant.SPAWNING_RATIO; i++) {
			do {
				artefactPos = new Pair<Integer, Integer>(new Random().ints(0, size.getX()).findFirst().getAsInt(),
						new Random().ints(0, size.getY()).findFirst().getAsInt());
			} while (Constant.findGameObject(artefactPos, this) != null);
			Object randomFactory = generateRandomArtefactFactory();
		}

	}

	private Object generateRandomArtefactFactory() {
		List<Object> keys = new ArrayList<Object>(factoryOfArtefact.keySet());
		Object randomKey = keys.get(new Random().nextInt(keys.size()));
		return factoryOfArtefact.get(randomKey);
	}
}
