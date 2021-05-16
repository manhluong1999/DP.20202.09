package entity.payment;

/**
 * StrategyPattern: Thêm hàm setCard
 */
public class PaymentTransaction {
	private String errorCode;
	private ICard card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	// SOLID: Vi pham DOP - vi class PaymentTransaction chi ho tro CreditCard nen khi co loai Card moi se phai sua code
	public PaymentTransaction(String errorCode, String transactionId, String transactionContent,
                              int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}

	public void setCard(ICard card){
		this.card = card;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
