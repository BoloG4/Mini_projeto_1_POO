import java.util.Scanner;

public class HighLow {
    
    
    public static void main(String[] args) {
        
        
        deck deck = new deck();
        deck.shuffle();
        card currentcard = deck.dealCard();
        
        System.out.println("Welcome to the High-Low game!\n");
        System.out.println("Lets get started!\n");
        System.out.println("ready to play?");

        int choice=0;
        double score=0;
        int rounds=0;
        int again=0;

        while (choice != 3 || deck.cardsLeft() !=0) {   // loop to keep the game running until the user chooses to exit or runs out of cards
        
        if(deck.cardsLeft() == 0) {        // check if there are no cards left in the deck and if so, end the game and display the final score and rounds played
            System.out.println("You have run out of cards, the game is over.");
            System.out.println("You played " + rounds + " rounds and scored an average of " + score/rounds + " points.");
        break;
        }

        again=0;
        System.out.println("cards left: " + deck.cardsLeft());  // display the number of cards left in the deck
        System.out.println("Your current card is: " + currentcard + "\n"); // display the current card to the user
        System.out.println("Do you think the next card will be higher or lower?\n"); // ask the user to guess if the next card will be higher or lower than the current card
        System.out.println("1. Higher"); // display the options for the user to choose from
        System.out.println("2. Lower");
        System.out.println("3. Exit");
        System.out.println("Please enter your choice: ");
        Scanner sc = new Scanner(System.in); // create a scanner object to read user input
        choice = sc.nextInt(); // read the user's choice and store it in the variable 'choice'
        
        
        card nextcard = deck.dealCard(); // deal the next card from the deck and store it in the variable 'nextcard'
        
        
        switch(choice) { // use a switch statement to handle the user's choice
        case 1: // if the user chooses option 1 (higher), check if the next card is higher than the current card
            System.out.println("Your next card is: " + nextcard);
            if(nextcard.getValue() > currentcard.getValue()) {
                System.out.println("You won!");
                score++;
                again=2;
            } else if(nextcard.getValue() < currentcard.getValue()) {
                System.out.println("You guessed wrong! You lose!");
                again=0;
            } else {
                System.out.println("It's a tie! you lose!");
                again=0;
            }
            rounds++;
            currentcard = nextcard;
            break;

        case 2: // if the user chooses option 2 (lower), check if the next card is lower than the current card
            System.out.println("Your next card is: " + nextcard);
            if(nextcard.getValue() < currentcard.getValue()) {
                System.out.println("You won!");
                score++;
                again=2;
            } else if(nextcard.getValue() > currentcard.getValue()) {
                System.out.println("You guessed wrong! You lose!");
                again=0;
            } else {
                System.out.println("It's a tie! you lose!");
                again=0;
            }
            rounds++;
            currentcard = nextcard;
            break;
       
       
        case 3: // if the user chooses option 3 (exit), end the game and display the final score and rounds played
            System.out.println("we are sad to see you go.");
            System.out.println("You played " + rounds + " rounds and scored an average of " + score/rounds + " points there where " + deck.cardsLeft() + " cards left in the deck.");
            again=1;
            break;

        default: // if a non Standard will ask them so try again 
            System.out.println("unvalid choice, please try again.");
            break;
        }

        if(again==0) { // after losing asking if the user would like to play again
        System.out.println("would you like to play again?\n 1. Yes\n 2. No");
        Scanner rt = new Scanner(System.in);
        int restart = rt.nextInt();
        if(restart == 1) {
            choice = 0;
        } else {
            System.out.println("we are sad to see you go.");
            System.out.println("You played " + rounds + " rounds and scored an average of " + score/rounds + " points there where " + deck.cardsLeft() + " cards left in the deck.");
            break;   
        }
        
        } else if(again==1) { // if the user chooses to exit, break the loop and end the game
            break;
        }


    }
    System.out.println("Thank you for playing the High-Low game!"); // display a thank you message to the user at the end of the game
    }
    
}