package entity.payment;


/*
* Date: 22/05/2021
* Author: Minh
* Subject: SOLID - DIP
* Reason: Khi ta thêm mới một card thì việc refactor lại code là chắc chắn, Do vậy chỉ nên giao tiếp qua interface ở card
* Solutions: AbstractFactory or StrategyPattern
* */


/**
 * Example_5 - Abstract Factory
 * */
public class PaymentTransaction {
	private String errorCode;
	private Card card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, Card card, String transactionId, String transactionContent,
                              int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
