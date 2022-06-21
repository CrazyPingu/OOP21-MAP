package utilities.counter;

/**
 * 
 * Class to create a generic counter
 *
 */
public class CounterImpl implements Counter {

  private int countValue;

  /**
   * initialize the counter to 0
   */
  public CounterImpl() {
    this.countValue = 0;
  }

  @Override
  public void increment() {
    this.countValue++;

  }

  @Override
  public int getCountValue() {
    return this.countValue;
  }

}
