package entity.order;

import entity.order.OrderState;

public class OrderApproved implements OrderState {
	public void cancel() {
		System.out.println("Can not Cancel");
	}
}
