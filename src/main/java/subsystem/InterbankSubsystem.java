package subsystem;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
/*
* SOLID: Đều vi phạm OCP, DIP : Vì mở rộng nhiều phương thức thanh toán
* Vi phạm ICP: trong method refund luôn trả về null, tức là phương thức không cần tiền vậy ta không cần thiết phải implement nó
* */
	/*
	DP: Nên là Singleton
	 */
public class InterbankSubsystem implements InterbankInterface {

	/**
	 * Represent the controller of the subsystem
	 */
	private InterbankSubsystemController ctrl = new InterbankSubsystemController();

	private static volatile InterbankSubsystem interbankSubsystem = null;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	private InterbankSubsystem() {
	}

	public static synchronized InterbankSubsystem getInstance() {
		if(interbankSubsystem == null){
			interbankSubsystem = new InterbankSubsystem();
		}
		return interbankSubsystem;
	}

	/**
	 * @see InterbankInterface#payOrder(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		// StampCoupling - Truyền thừa dữ liệu
		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
		return transaction;
	}
}
