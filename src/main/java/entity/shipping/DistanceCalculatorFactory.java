package entity.shipping;

public abstract class DistanceCalculatorFactory {
	public abstract DistanceCalculatorFactory createDistanceCalculator(DistanceCalculatorFactory factory);
}
