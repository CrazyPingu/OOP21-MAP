package utilities.counter;

public class CounterImpl implements Counter {
	
	private int countValue;
	
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
