package entity.payment;

import java.util.Date;

/**
 * StrategyPattern
 */
public class DomesticDebitCard extends ICard {
    private String cardCode;
    private String issuingBank;
    private Date validFrom;
    private String cardholderName;

    public DomesticDebitCard(String cardCode, String issuingBank, Date validFrom, String cardholderName) {
        this.cardCode = cardCode;
        this.issuingBank = issuingBank;
        this.validFrom = validFrom;
        this.cardholderName = cardholderName;
    }
}
