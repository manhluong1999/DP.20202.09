package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: Coupling - Stamp
 * Reason: Method refund truyền param nhưng không sử dụng
 * */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: DesignPattern - Singleton
 * Reason: Nên áp dụng singleton
 * */

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
