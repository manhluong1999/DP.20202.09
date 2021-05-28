package subsystem;

import entity.payment.Card;
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
* Date: 22/05/2021
* Author: Minh
* Subject: Cohesion - Communicational
* Reason: Các param truyền vào payOrder và refund và output, input 2 method này là giống nhau
* */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: SOLID - DIP
 * Reason: Khi có card mới -> Nên giao tiếp qua interface
 * */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: SOLID - ISP
 * Reason: Câu chuyện này sảy ra khi cửa hàng chỉ thanh toán mà không trả lại, -> refund sẽ dư thừa
 * */


public class InterbankSubsystem implements InterbankInterface {

	/**
	 * Represent the controller of the subsystem
	 */
	private InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}

	/**
	 * @see InterbankInterface#payOrder(Card, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(Card card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
		return transaction;
	}
}
