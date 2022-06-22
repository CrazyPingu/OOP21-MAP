package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import utilities.Pair;
import utilities.PosInGrid;

/**
 * 
 * Test PosInGrid class
 */
class PosInGridTest {

  private final Pair<Integer, Integer> size = new Pair<>(6, 4);
  private Pair<Integer, Integer> pos;

  /**
   * Test the correct result of the algorithm when is chosen a cell in the center
   * of the grid.
   */
  @Test
  void innerAreaTest() {
    this.pos = new Pair<>(1, 1);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
  }

  /**
   * Test the correct result of the algorithm when is chosen a cell in the border
   * of the grid.
   */
  @Test
  void sideCoordinateTest() {
    this.pos = new Pair<>(1, 0);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
    this.pos = new Pair<>(0, 1);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
    this.pos = new Pair<>(this.size.getX() - 1, 1);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
    this.pos = new Pair<>(1, this.size.getY() - 1);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
  }

  /*
   * Test the correct result of the algorithm when is chosen a cell in the border
   * of the grid.
   */
  @Test
  void cornerCoordinateTest() {
    this.pos = new Pair<>(0, 0);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
    this.pos = new Pair<>(0, this.size.getY() - 1);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
    this.pos = new Pair<>(this.size.getX() - 1, this.size.getY() - 1);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
    this.pos = new Pair<>(this.size.getX() - 1, 0);
    assertTrue(PosInGrid.checkPosInGrid(pos, size));
  }

  /**
   * test all the possible coordinate in the grid
   */
  @Test
  void allCoordinateTest() {
    for (int i = 0; i < size.getX(); i++) {
      for (int j = 0; j < size.getY(); j++) {
        pos = new Pair<>(i, j);
        assertTrue(PosInGrid.checkPosInGrid(pos, size));
      }
    }
  }

  /**
   * Test some wrong coordinates that don't belong to the grid
   */
  @Test
  void wrongCoordinateTest() {
    pos = new Pair<>(-1, 0);
    assertFalse(PosInGrid.checkPosInGrid(pos, size));
    pos = new Pair<>(-1, -1);
    assertFalse(PosInGrid.checkPosInGrid(pos, size));
    pos = new Pair<>(size.getX(), 0);
    assertFalse(PosInGrid.checkPosInGrid(pos, size));
    pos = new Pair<>(0, size.getY());
    assertFalse(PosInGrid.checkPosInGrid(pos, size));
    pos = new Pair<>(size.getX(), size.getY());
    assertFalse(PosInGrid.checkPosInGrid(pos, size));
  }

}
