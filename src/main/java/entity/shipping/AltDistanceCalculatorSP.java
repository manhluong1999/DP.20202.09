package entity.shipping;

import org.example.AlternativeDistanceCalculator;

/**
 * StrategyPattern
 */
public class AltDistanceCalculatorSP implements IDistanceCalculatorSP{

    private AlternativeDistanceCalculator altDistanceCalculator;

    public AltDistanceCalculatorSP(AlternativeDistanceCalculator altDistanceCalculator) {
        this.altDistanceCalculator = altDistanceCalculator;
    }

    @Override
    public int calculateDistance(String address, String province) {
        return altDistanceCalculator.calculateDistance(address, province);
    }
}
