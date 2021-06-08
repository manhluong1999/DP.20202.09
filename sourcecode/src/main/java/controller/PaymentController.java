package controller;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.Card;
import entity.payment.CardFactory;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject: SOLID - OCP, DIP
 * Reason: Khi thêm các ngân hàng mới (bank) , các loại thẻ mới (card) lớp payOrder phải modified và Class giao tiếp qua AbstractClass or Interface
 * Subject: SRP
 * Reason: Lớp thực hiện cả việc getExpirationDate()
 * */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject_2: Cohesion - Procedural
 * Reason_2: Các hàm getExpirationDate() được đặt trong class để thực hiện method payOrder() mà về chức năng chúng không liên quan đến nhau
 * */

/*
 * Date: 22/05/2021
 * Author: Minh
 * Subject_2: Code Smell
 * Reason_2: Các number nên thay bằng các enum parameter dễ kiển soát (Sự thay đổi sẽ được comment ở dưới)
 * */

public class PaymentController extends BaseController {

	/**
	 * Represent the card used for payment
	 */
	private Card card;

	/**
	 * Represent the Interbank subsystem
	 */
	private InterbankInterface interbank;

	/**
	 * Example_5
	 * */
	private CardFactory factory;

	/**
	 * Validate the input date which should be in the format "mm/yy", and then
	 * return a {@link String String} representing the date in the
	 * required format "mmyy" .
	 * 
	 * @param date - the {@link String String} represents the input date
	 * @return {@link String String} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid date
	 *                              in the expected format
	 */
	/*
	*
	* SmellCode
	* */
	public String getExpirationDate(String date) throws InvalidCardException {
		String[] strs = date.split("/");
		if (strs.length != Constant.MAX_LENGTH_DATE) {
			throw new InvalidCardException();
		}

		String expirationDate = null;
		int month = -1;
		int year = -1;

		try {
			month = Integer.parseInt(strs[0]);
			year = Integer.parseInt(strs[1]);
			if (month < Constant.MIN_MONTH || month > Constant.MAX_MONTH || year < Calendar.getInstance().get(Calendar.YEAR) % Constant.ONE_HUNDRED || year > Constant.ONE_HUNDRED) {
				throw new InvalidCardException();
			}
			expirationDate = strs[0] + strs[1];

		} catch (Exception ex) {
			throw new InvalidCardException();
		}

		return expirationDate;
	}

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @param amount         - the amount to pay
	 * @param contents       - the transaction contents
	 * @param cardNumber     - the card number
	 * @param cardHolderName - the card holder name
	 * @param expirationDate - the expiration date in the format "mm/yy"
	 * @param securityCode   - the cvv/cvc code of the credit card
	 * @return {@link Map Map} represent the payment result with a
	 *         message.
	 */

	/*
	 * SOLID
	 * */
	public Map<String, String> payOrder(int amount, String contents, String cardNumber, String cardHolderName,
			String expirationDate, String securityCode) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.card = new CreditCard(
					cardNumber,
					cardHolderName,
					getExpirationDate(expirationDate),
					Integer.parseInt(securityCode));

			this.interbank = new InterbankSubsystem();

			PaymentTransaction transaction = interbank.payOrder(card, amount, contents);

			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have successfully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}

	public void setFactory(CardFactory factory) {
		this.factory = factory;
	}

	public Map<String, String> payOrderRefactor(int amount, String contents, Card Card) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {

			this.interbank = new InterbankSubsystem();

			PaymentTransaction transaction = interbank.payOrder(card, amount, contents);

			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have successfully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}

	public void emptyCart(){
        SessionInformation.cartInstance.emptyCart();
    }
}