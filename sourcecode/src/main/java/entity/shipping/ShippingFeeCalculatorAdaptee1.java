package entity.shipping;

import entity.order.Order;

public class ShippingFeeCalculatorAdaptee1 implements IShippingFeeCalculator {
	
	@Override
	public int calculateShippingFee(Order order, int distanceFee) {
		// cách tính hiện tại
		return (int) (1.2*distanceFee);
	}

}
