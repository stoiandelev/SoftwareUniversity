package entities;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail{

    //card type, expiration month, expiration year

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name = "expiration_months")
    private Integer expirationMonth;

    @Column(name = "expiration_years")
    private Integer expirationYears;

    public CreditCard() {
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYears() {
        return expirationYears;
    }

    public void setExpirationYears(Integer expirationYears) {
        this.expirationYears = expirationYears;
    }
}
