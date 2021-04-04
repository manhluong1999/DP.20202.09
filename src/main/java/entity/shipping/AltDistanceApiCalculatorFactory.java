package entity.shipping;

public class AltDistanceApiCalculatorFactory extends DistanceCalculatorFactory {

	@Override
	public AltDistanceApiCalculatorFactory createDistanceCalculator(DistanceCalculatorFactory factory) {
		return new AltDistanceApiCalculatorFactory();
	}
}
