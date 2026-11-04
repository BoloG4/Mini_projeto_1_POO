public class card {

    private int value;
    private String suit;


    public card(int value, String suit) {
        this.suit = suit;
        this.value = value;
        
    }

    public int getValue() {

        return value;
    }

    public String getSuit() {

        return suit;
    }

    @Override
    public String toString() {


        switch(value) {
        case 1:
            return "Ace of " + suit;
        case 11:
            return "Jack of " + suit;
        case 12:
            return "Queen of " + suit;
        case 13:
            return "King of " + suit;      
        default:
            return value + " of " + suit;
        }

    }
}