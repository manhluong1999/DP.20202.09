package entity.payment;

import java.util.Map;

public class DebitCard implements Card{
    private String issueBank;
    private String cardNumber;
    private String validDate;
    private String cardHolderName;

    public DebitCard(String issueBank, String cardNumber, String validDate, String cardHolderName) {
        this.issueBank = issueBank;
        this.cardNumber = cardNumber;
        this.validDate = validDate;
        this.cardHolderName = cardHolderName;
    }

    public DebitCard() {}

    @Override
    public String print() {
        return "DebitCard";
    }

    @Override
    public void setInfo(Map<String, Object> info) {
        this.issueBank = (String) info.get("issueBank");
        this.cardNumber = (String) info.get("cardNumber");
        this.cardHolderName = (String) info.get("cardHolderName");
        this.validDate = (String) info.get("validDate");
    }
}
