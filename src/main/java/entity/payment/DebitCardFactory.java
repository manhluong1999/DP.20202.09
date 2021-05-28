package entity.payment;

public class DebitCardFactory implements CardFactory{
    @Override
    public Card createCard() {
        return new DebitCard();
    }
}
