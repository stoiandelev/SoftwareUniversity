public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        //Card.values(); -> масив с enum (CLUBS, DIAMONDS, HEARTS, SPADES)
        //.ordinal() -> oт печатва номерата в списъка с enum както са добавени
        //от горе на долу
        for (Card card : Card.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    card.ordinal(), card.toString());
        }
    }
}
