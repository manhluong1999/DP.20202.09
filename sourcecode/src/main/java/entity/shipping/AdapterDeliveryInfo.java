package entity.shipping;

import entity.order.Order;

/**
 * AdapterFactory - Example_4
 *
 * */
public class AdapterDeliveryInfo extends DeliveryInfo{

    private IDistanceCalculator distanceCalculator;
    private IShippingFeeCalculator shippingFeeCalculator;
    public AdapterDeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, IDistanceCalculator distanceCalculator, IShippingFeeCalculator shippingFeeCalculator) {
        super(name, phone, province, address, shippingInstructions);
        this.distanceCalculator = distanceCalculator;
        this.shippingFeeCalculator= shippingFeeCalculator;
    }

    public void setDistanceCalculator(IDistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
    public int calculateDistanceFee(Order order) {
    	return distanceCalculator.calculateDistance(province, address);
    }
    public void setShippingFeeCalculator(IShippingFeeCalculator shippingFeeCalculator) {
    	this.shippingFeeCalculator = shippingFeeCalculator;
    }
    @Override
    public int calculateShippingFee(Order order) {
        int distanceFee = calculateDistanceFee(order);
        return shippingFeeCalculator.calculateShippingFee(order, distanceFee);
    }
}
