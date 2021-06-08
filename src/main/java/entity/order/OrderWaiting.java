package entity.order;

import entity.order.OrderCanceled;

public class OrderWaiting implements OrderState {
	private OrderState orderCanceled = new OrderCanceled();
	private OrderContext context;
	
	public void cancel() {
		System.out.println("Canceled");
		
		context.changeState(orderCanceled);
	}
}
