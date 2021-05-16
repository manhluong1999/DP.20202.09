package entity.payment;

public class CardHandle {
private  PaymentStrategy paymentStrategy;
public void setStrategy(PaymentStrategy strategy) {
	this.paymentStrategy=strategy;
}
public void chooseCard(int amount) {
	paymentStrategy.pay(amount);
}
}
