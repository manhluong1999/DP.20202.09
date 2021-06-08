package entity.shipping;

import entity.order.Order;

public interface IShippingFeeCalculator {
	int calculateShippingFee(Order order,int distanceFee);
}
