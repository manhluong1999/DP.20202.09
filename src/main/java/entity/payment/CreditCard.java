package entity.payment;

/**
 * @author
 */
public class CreditCard implements PaymentStrategy {

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        super();
    	this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
    
    @Override
    public void pay(int amount) {
    	System.out.println(amount + "paid using Credit Card");
    }
}
