public class Card {

    private CardRanks cardRanks;
    private CardSuits cardSuits;
    private int power;

    Card(CardRanks cardRanks, CardSuits cardSuits ){
        this.cardRanks = cardRanks;
        this.cardSuits = cardSuits;
    }


    public int getPower() {
        return this.cardRanks.getPower() + this.cardSuits.getSuitePower();
    }

    public CardRanks getCardRanks() {
        return cardRanks;
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }
}
