package entity.payment;

import java.util.Map;

/**
 * @author
 */
public class CreditCard implements Card{

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }

    public CreditCard() {}

    @Override
    public String print() {
        return "Credit_Card";
    }

    @Override
    public void setInfo(Map<String, Object> info) {
        this.cardCode = (String) info.get("cardCode");
        this.owner = (String) info.get("owner");
        this.dateExpired = (String) info.get("dateExpired");
        this.cvvCode = (int) info.get("cvvCode");
    }
}
