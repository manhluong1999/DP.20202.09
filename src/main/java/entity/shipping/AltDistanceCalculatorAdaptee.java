package entity.shipping;

import org.example.AlternativeDistanceCalculator;

public class AltDistanceCalculatorAdaptee implements IDistanceCalculator{

    private AlternativeDistanceCalculator alternativeDistanceCalculator;

    public AltDistanceCalculatorAdaptee() {
        this.alternativeDistanceCalculator = new AlternativeDistanceCalculator();
    }

    @Override
    public int calculateDistance(String province, String address) {
        return alternativeDistanceCalculator.calculateDistance(province, address);
    }
}
