package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceCalculatorAdaptee implements IDistanceCalculator {

    private DistanceCalculator distanceCalculator;

    public DistanceCalculatorAdaptee(){
        this.distanceCalculator = new DistanceCalculator();
    }

    @Override
    public int calculateDistance(String province, String address) {
        return distanceCalculator.calculateDistance(address, province);
    }


}
