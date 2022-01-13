public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        //CardSuits.values(); -> масив с enum (CLUBS, DIAMONDS, HEARTS, SPADES)
        for (CardRanks suit : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.toString());
        }
    }
}
