public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitePower;

    CardSuits(int suitePower) {
        this.suitePower = suitePower;
    }

    public int getSuitePower() {
        return suitePower;
    }
}
