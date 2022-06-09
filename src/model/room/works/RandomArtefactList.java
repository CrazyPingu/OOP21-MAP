package model.room.works;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.game_object.artefact.ActionNumberArtefactFactoryImpl;
import model.game_object.artefact.Artefact;
import model.game_object.artefact.HealthArtefactFactoryImpl;
import model.game_object.artefact.MovementArtefactFactoryImp;
import model.game_object.artefact.WeaponArtefactFactoryImpl;
import model.game_object.entity.Player;
import model.game_object.entity.SimpleEnemy;
import model.weapon.WeaponFactoryImpl;
import utilities.Constant;
import utilities.Pair;
import utilities.RoomConstant;

/**
 * 
 * Class that is a random generated List with random artefact
 *
 */
public class RandomArtefactList extends ArrayList<Artefact> {

  private static final long serialVersionUID = -6692451133647329784L;
  private final Map<Object, Integer> factoryOfArtefact = new HashMap<>();

  /**
   * 
   * @param size      the size of the room
   * @param enemyList the list of the enemy
   * @param player    the player
   * @param door      the position of the door
   */
  public RandomArtefactList(final Pair<Integer, Integer> size, final List<SimpleEnemy> enemyList, final Player player,
      final List<Pair<Integer, Integer>> door) {
    factoryOfArtefact.put(new WeaponArtefactFactoryImpl(),
        new WeaponFactoryImpl().getClass().getDeclaredMethods().length);
    factoryOfArtefact.put(new HealthArtefactFactoryImpl(),
        new HealthArtefactFactoryImpl().getClass().getDeclaredMethods().length);
    factoryOfArtefact.put(new ActionNumberArtefactFactoryImpl(),
        new ActionNumberArtefactFactoryImpl().getClass().getDeclaredMethods().length);
    factoryOfArtefact.put(new MovementArtefactFactoryImp(),
        new MovementArtefactFactoryImp().getClass().getDeclaredMethods().length);
    Pair<Integer, Integer> artefactPos;
    for (int i = 0; i < size.getX() * size.getY() / RoomConstant.SPAWNING_RATIO; i++) {
      do {
        artefactPos = new Pair<>(Constant.RANDOM.ints(0, size.getX()).findFirst().getAsInt(),
            Constant.RANDOM.ints(0, size.getY()).findFirst().getAsInt());
      } while (RoomConstant.cellsOccupated(enemyList, this, null, player, artefactPos) || door.contains(artefactPos));
      generateRandomArtefact(generateRandomArtefactFactory(), artefactPos);
    }
  }

  /**
   * 
   * @param artefactFactory the artefactFactory that will be called
   * @param pos             the position of the artefact generated
   */
  private void generateRandomArtefact(final Object artefactFactory, final Pair<Integer, Integer> pos) {
    Artefact generatedArtefact = null;
    try {
      generatedArtefact = (Artefact) artefactFactory.getClass().getDeclaredMethods()[Constant.RANDOM
          .ints(0, factoryOfArtefact.get(artefactFactory)).findAny().getAsInt()].invoke(artefactFactory, pos);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
      System.out.println("Error during artefact generation");
      e.printStackTrace();
    }
    this.add(generatedArtefact);
  }

  /**
   * @return a random ArtefactFactory
   */
  private Object generateRandomArtefactFactory() {
    return new ArrayList<Object>(factoryOfArtefact.keySet())
        .get(Constant.RANDOM.nextInt(new ArrayList<Object>(factoryOfArtefact.keySet()).size()));
  }
}
