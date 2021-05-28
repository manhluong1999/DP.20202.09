package entity.shipping;

import entity.order.Order;

public class AdapterDeliveryInfo extends DeliveryInfo{

    private IDistanceCalculator distanceCalculator;

    public AdapterDeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, IDistanceCalculator distanceCalculator) {
        super(name, phone, province, address, shippingInstructions);
        this.distanceCalculator = distanceCalculator;
    }

    public void setDistanceCalculator(IDistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public int calculateShippingFee(Order order) {
        return distanceCalculator.calculateDistance(province, address);
    }
}
