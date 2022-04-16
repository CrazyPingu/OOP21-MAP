package utilis;

public class PosInGrid {

	private PosInGrid() {
	};

	/**
	 * 
	 * @param pos  represents the position to check
	 * @param size represents the grid size. First cordinate determinate the
	 *             orizontal size (1 based) and second ones the vertical size.
	 * @return true if the position is in the grid, false if it isn't
	 */
	public static final boolean checkPosInGrid(Pair<Integer, Integer> pos, Pair<Integer, Integer> size) {
		return pos.getX() < size.getX() ? (pos.getY() < size.getY() ? true : false) : false;
	}
}
