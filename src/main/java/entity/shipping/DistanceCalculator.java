package entity.shipping;

public abstract class DistanceCalculator {
	
	protected DistanceCalculatorFactory distanceCalculatorFactory;
	
	public DistanceCalculator(DistanceCalculatorFactory factory) {
		this.distanceCalculatorFactory = factory;
	}
	public abstract int calculateDistance();
}
