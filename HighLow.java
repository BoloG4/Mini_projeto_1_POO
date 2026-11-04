public class HighLow {
    
    
    private int guess;
    
    
    public static void main(String[] args) {
        
        
        deck deck = new deck();
        deck.shuffle();
        card newcard = deck.dealCard();
        
        System.out.println("Welcome to the High-Low game!\n");
        System.out.println("Lets get started!\n");
        System.out.println("Your first card is: " + newcard + "\n");


    }
}