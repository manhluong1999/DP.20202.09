package entity.order;

import entity.order.OrderState;

public class OrderContext {
	private OrderState state;
	
	public void orderContext(OrderState initState) {
		this.state = initState;
		OrderState.setOrderContext(this);
	}
	
	public void cancel() {
		OrderState.cancel(state);
	}
	
	public void changeState(OrderState state) {
		this.state = state;
	}
}
