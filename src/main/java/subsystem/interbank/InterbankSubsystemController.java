package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.DomesticCard;
import entity.payment.PaymentTransaction;
import entity.payment.PaymentType;

import java.util.Date;

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	// StampCoupling -> Truyền dữ liệu nhưng không sử dụng
	public PaymentTransaction refund(PaymentType card, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(PaymentType card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
