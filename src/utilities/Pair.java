package utilities;

/**
 *
 * Class that model a pair of value
 *
 */
public class Pair<X, Y> {

  private final X x;
  private final Y y;

  /**
   * @param x the first parameter
   * @param y the second parameter
   */
  public Pair(final X x, final Y y) {
    super();
    this.x = x;
    this.y = y;
  }

  /**
   * @param pair the original pair to revert
   * @return a new Pair with the x and y inverted of the original pair passed
   */
  public static Pair<Integer, Integer> revertPair(final Pair<Integer, Integer> pair) {
    return new Pair<Integer, Integer>(pair.getY(), pair.getX());
  }

  /**
   * @return the first value of the pair
   */
  public X getX() {
    return x;
  }
  
  /**
   * @return the second value of the pair
   */
  public Y getY() {
    return y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((x == null) ? 0 : x.hashCode());
    result = prime * result + ((y == null) ? 0 : y.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Pair<X, Y> other = (Pair<X, Y>) obj;
    if (x == null) {
      if (other.x != null) {
        return false;
      }
    } else if (!x.equals(other.x)) {
      return false;
    }
    if (y == null) {
      if (other.y != null) {
        return false;
      }
    } else if (!y.equals(other.y)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Pair [x=" + x + ", y=" + y + "]";
  }
}
