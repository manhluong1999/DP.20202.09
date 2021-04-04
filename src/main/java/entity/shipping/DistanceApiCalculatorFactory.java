package entity.shipping;

public class DistanceApiCalculatorFactory extends DistanceCalculatorFactory {
	public DistanceApiCalculatorFactory createDistanceCalculator(DistanceCalculatorFactory factory) {
		return new DistanceApiCalculatorFactory();
	}
}
