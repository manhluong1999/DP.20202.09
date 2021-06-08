package entity.shipping;

import org.example.AlternativeDistanceCalculator;

/**
 * AdapterFactory - Example_4
 *
 * */
public class AltDistanceCalculatorAdaptee implements IDistanceCalculator{

    private AlternativeDistanceCalculator distanceCalculator;

    public AltDistanceCalculatorAdaptee() {
        this.distanceCalculator = new AlternativeDistanceCalculator();
    }

    @Override
    public int calculateDistance(String province, String address) {
        return distanceCalculator.calculateDistance(province, address);
    }
}
