public class card {

    private int value;
    private String suit;

    //construtor da classe card que recebe o valor e o naipe da carta e inicializa os atributos da classe
    public card(int value, String suit) {
        this.suit = suit;
        this.value = value;
        
    }
    
    //metodo getValue que retorna o valor da carta
    public int getValue() { 

        return value;
    }

    //metodo getSuit que retorna o naipe da carta
    public String getSuit() {

        return suit;
    }

    @Override
    public String toString() {

        //switch case para retornar o nome da carta de acordo com o valor dela, se for 1 retorna Ace, se for 11 retorna Jack, 
        //se for 12 retorna Queen, se for 13 retorna King, caso contrario retorna o valor da carta
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