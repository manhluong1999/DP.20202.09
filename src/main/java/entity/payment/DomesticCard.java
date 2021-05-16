package entity.payment;

/**
 * @author
 */

public class DomesticCard implements PaymentStrategy {

	private String issuingBank;
	private String owner;
	private String cardNumber;
	private String dateExpired;
	
	public DomesticCard(String issuingBank, String owner, String cardNumber, String dateExpired) {
		super();
		this.issuingBank = issuingBank;
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.dateExpired = dateExpired;
    }
	
	@Override
	public void pay(int amount) {
		
	}
}

