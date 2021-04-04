package entity.payment;

public class PaymentTransaction {
	private String errorCode;
	private PaymentType card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	// SOLID: Vi pham DOP - vi class PaymentTransaction chi ho tro CreditCard nen khi co loai Card moi se phai sua code
	public PaymentTransaction(String errorCode, PaymentType card, String transactionId, String transactionContent,
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
