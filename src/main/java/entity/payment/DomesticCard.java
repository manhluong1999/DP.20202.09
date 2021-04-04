package entity.payment;

import java.util.Date;

public class DomesticCard extends PaymentType{
    private String issuingBank;
    private String cardNumber;
    private Date date;
    private String cardHolderName;

    public DomesticCard(String issuingBank, String cardNumber, Date date, String cardHolderName){
        this.issuingBank = issuingBank;
        this.cardNumber = cardNumber;
        this.date = date;
        this.cardHolderName = cardNumber;
    }
}
