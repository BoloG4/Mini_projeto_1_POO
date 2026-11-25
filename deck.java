import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class deck {
    private List<card> cards;

    //cria um array que vai ser usada para armazenar todas as cartas do baralho, e chama o metodo createDeck para criar o baralho
    public deck() {
        cards = new ArrayList<>(); 
        createDeck();
    }
    //o metodo createDeck cria 2 arrays um para guardar os naipes e outro para guardar os valores das cartas,
    //e depois cria um loop que vai criar todas as combinações de naipes e valores e adicionar ao array cards

    private void createDeck() {
        ArrayList<String> suits = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        suits.add("clubs");
        suits.add("spades");
        suits.add("hearts");
        suits.add("diamonds");

        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(8);
        values.add(9);
        values.add(10);
        values.add(11);
        values.add(12);
        values.add(13);
        
        //for each que vai percorrer cada naipe e cada valor e criar uma nova carta com esses valores e adicionar ao array cards
        for(String suit : suits) {
            for(int value : values) {
                cards.add(new card(value, suit));
            }
        }
    }

    //usando o metodo shuffle da classe Collections para embaralhar o array cards 
    public void shuffle() {
           Collections.shuffle(cards);
    }
    
    //o metodo dealCard vai remover a primeira carta do array cards e retornar ela, se o array estiver vazio ele retorna null
    public card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
    //o metodo cardsLeft retorna o tamanho do array cards, que é a quantidade de cartas restantes no baralho
    public int cardsLeft() {
        return cards.size();
    }
}
