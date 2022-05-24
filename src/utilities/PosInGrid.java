package utilities;

@SuppressWarnings("PMD.UseUtilityClass")
public class PosInGrid {

	/**
	 * 
	 * @param pos  represents the position to check (coordinate in 0 based sistem)
	 * @param size represents the grid size. First coordinate determinates the
	 *             horizontal number of cells (1 based) and second one the vertical
	 *             number of cells.
	 * @return true if the position is in the grid, false if it isn't
	 */
	public static final boolean checkPosInGrid(final Pair<Integer, Integer> pos,final Pair<Integer, Integer> size) {
		return !(pos.getX() < 0 || pos.getY() < 0 || pos.getX() >= size.getX() || pos.getY() >= size.getY()) ;
	}
}
