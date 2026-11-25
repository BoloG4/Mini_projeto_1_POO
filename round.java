
import java.util.Scanner;

public class round {

    private Scanner scanner;

    // Construtor
    public round(Scanner scanner) {
        this.scanner = scanner;
    }

    // Executa uma ronda para um jogador
    public void playRound(player currentPlayer, tournament currentTournament, deck gameDeck) {

        card currentCard = gameDeck.dealCard();
        int roundScore = 0;

        // Reinicia a segunda oportunidade do jogador especial
        if (currentPlayer instanceof specialPlayer) {
            ((specialPlayer) currentPlayer).resetSecondChance();
        }

        System.out.println("\n--- Nova ronda ---");
        System.out.println("Jogador: " + currentPlayer.getName());
        System.out.println("Carta inicial: " + currentCard);
        System.out.println("cards left: " + gameDeck.cardsLeft());

        boolean continuePlaying = true;

        while (continuePlaying && gameDeck.cardsLeft() > 0) {

            System.out.println("\n1 - Maior");
            System.out.println("2 - Menor");
            System.out.print("A tua escolha: ");

            int choice = readChoice();

            card nextCard = gameDeck.dealCard();

            System.out.println("\n");
            System.out.println("Carta revelada: " + nextCard);

            // Cartas com o mesmo valor terminam a ronda
            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("As cartas têm o mesmo valor!");
                System.out.println("A ronda terminou.");
                break;
            }

            boolean correctPrediction =
                checkPrediction(choice, currentCard, nextCard);

            if (correctPrediction) {

                System.out.println("Acertaste!");
                System.out.println("cards left: " + gameDeck.cardsLeft());
                currentPlayer.addPoints(1);
                roundScore++;

                currentTournament.recordCorrectPrediction();

                currentCard = nextCard;

            } else {

                System.out.println("Falhaste a previsão!");
                System.out.println("cards left: " + gameDeck.cardsLeft());
                // Verifica se o jogador pode ter uma segunda oportunidade
                continuePlaying = currentPlayer.canContinue(false);

                if (continuePlaying) {

                    System.out.println("Tens uma segunda oportunidade!");
                    System.out.println("A mesma carta continua em jogo.");

                    System.out.println("\n1 - Maior");
                    System.out.println("2 - Menor");
                    System.out.print("Nova previsão: ");

                    int secondChoice = readChoice();

                    boolean secondCorrectPrediction =
                        checkPrediction(secondChoice, currentCard, nextCard);

                    if (secondCorrectPrediction) {

                        System.out.println("Acertaste na segunda tentativa!");

                        currentPlayer.addPoints(1);
                        roundScore++;

                        currentTournament.recordCorrectPrediction();

                        // A carta revelada passa a ser a nova referência
                        currentCard = nextCard;

                        System.out.println("A tua carta é: "
                        + currentCard);
                        System.out.println("cards left: " + gameDeck.cardsLeft());
                        System.out.println("Podes continuar a jogar!");

                    } else {

                        System.out.println("Também falhaste a segunda tentativa!");
                        continuePlaying = false;
                    }
                }
            }
        }

        // Regista o resultado da ronda
        currentPlayer.finishRound(roundScore);

        System.out.println("\n--- Fim da ronda ---");
        System.out.println("Pontos nesta ronda: " + roundScore);
        System.out.println("Pontuação acumulada: "
                + currentPlayer.getTotalScore());
    }

    // Ler e validar a escolha do jogador
    private int readChoice() {

        int choice = scanner.nextInt();

        while (choice != 1 && choice != 2) {
            System.out.print("Escolha inválida. Escolhe 1 ou 2: ");
            choice = scanner.nextInt();
        }

        return choice;
    }

    // Verifica se a previsão está correta
    private boolean checkPrediction(int choice, card currentCard, card nextCard) {

        if (choice == 1) {
            return nextCard.getValue() > currentCard.getValue();
        }

        return nextCard.getValue() < currentCard.getValue();
    }
}
