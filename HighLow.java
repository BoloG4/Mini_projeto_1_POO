
import java.util.Scanner;

public class HighLow {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Cria o torneio
        tournament gameTournament = new tournament(scanner);

        System.out.println("================================");
        System.out.println("       TORNEIO HIGH-LOW         ");
        System.out.println("================================");

        // Pergunta o número de jogadores
        System.out.print("\nQuantos jogadores vão participar? ");
        int numberOfPlayers = scanner.nextInt();

        //verifica se tem pelo o menos 1 ou mais jogadores
        while (numberOfPlayers <= 0) {
            System.out.print("Introduz um número válido de jogadores: ");
            numberOfPlayers = scanner.nextInt();
        }

        // Regista os jogadores 1 a 1 até que o número de jogadores seja atingido perguntando o nome e se sao jogadores normais ou especiais
        for (int i = 1; i <= numberOfPlayers; i++) {

            System.out.println("\n--- Jogador " + i + " ---");

            System.out.print("Nome do jogador: ");
            String name = scanner.next();

            System.out.println("Escolhe o tipo de jogador:");
            System.out.println("1 - Jogador Normal");
            System.out.println("2 - Jogador Especial");
            System.out.print("Opção: ");

            int type = scanner.nextInt();

            while (type != 1 && type != 2) {
                System.out.print("Opção inválida. Escolhe 1 ou 2: ");
                type = scanner.nextInt();
            }

            player newPlayer;

            if (type == 1) {
                newPlayer = new normalPlayer(name);
            } else {
                newPlayer = new specialPlayer(name);
            }

            gameTournament.registerPlayer(newPlayer);
        }


        // Inicia o torneio
        System.out.println("\nTodos os jogadores foram registados!");
        gameTournament.startTournament();

        scanner.close();
    }
}
