package entity.shipping;

import org.example.DistanceCalculator;

/**
 * StrategyPattern
 */
public class DistanceCalculatorSP implements IDistanceCalculatorSP{

    private DistanceCalculator distanceCalculator;

    public DistanceCalculatorSP(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public int calculateDistance(String address, String province) {
        return distanceCalculator.calculateDistance(address, province);
    }
}
