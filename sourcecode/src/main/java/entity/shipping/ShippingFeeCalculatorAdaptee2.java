package entity.shipping;

import entity.order.Order;

public class ShippingFeeCalculatorAdaptee2 implements IShippingFeeCalculator{
	@Override
	public int calculateShippingFee(Order order, int distanceFee) {
		// Cách tính khác
		return distanceFee;
	}
}
