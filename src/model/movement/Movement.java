package model.movement;

import java.util.List;

import utilities.Pair;

/**
 * 
 * Interface that declare methods for the movement sistem. Represent the
 * "Context" of the Strategy interface.
 */
public interface Movement {
  /**
   * 
   * @param pos  an absolute position in the map grid
   * @param size represent the size of the map grid
   * @return the selectable position calculated by an internal algoritm
   */
  List<Pair<Integer, Integer>> reachableCells(Pair<Integer, Integer> pos, Pair<Integer, Integer> size);

}
