import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tournament {

    private List<player> players;
    private Scanner scanner;
    private round gameRound;

    private int completedRounds;
    private int correctPredictions;
    private int totalPointsAwarded;
    private deck gameDeck;

    // Construtor
    public tournament(Scanner scanner) {
        this.scanner = scanner;
        this.players = new ArrayList<>();
        this.gameRound = new round(scanner);
        this.gameDeck = new deck();

        this.gameDeck.shuffle();

        this.completedRounds = 0;
        this.correctPredictions = 0;
        this.totalPointsAwarded = 0;
    }

    // Regista um jogador
    public void registerPlayer(player newPlayer) {
        players.add(newPlayer);
        System.out.println("Jogador registado: " + newPlayer.getName());
    }

    // Devolver o número de jogadores registados
    public int getNumberOfPlayers() {
        return players.size();
    }

    // Inicia o torneio
    public void startTournament() {

        if (players.isEmpty()) {
            System.out.println("Não existem jogadores registados.");
            return;
        }

        boolean continueTournament = true;

        while (continueTournament && gameDeck.cardsLeft() > 0) {

                // Cada jogador realiza uma ronda
                for (player currentPlayer : players) {

                    // Verifica se ainda existem cartas
                    if (gameDeck.cardsLeft() == 0) {
                        continueTournament = false;
                    break;
                    }
                    //diz o nome do jogador que vai jogar
                    System.out.println("\n========================");
                    System.out.println("Vez de: " + currentPlayer.getName());
                    System.out.println("========================");

                    gameRound.playRound(currentPlayer, this, gameDeck);
                    completedRounds++;

                    // Verifica novamente se o baralho acabou
                    if (gameDeck.cardsLeft() == 0) {
                        continueTournament = false;
                    break;
                    }
                }

                if (continueTournament) {
                    System.out.print("\nQueres continuar o torneio? (S/N): ");
                    String answer = scanner.next();

                    if (!answer.equalsIgnoreCase("S")) {
                        continueTournament = false;
                    }
                }
        }
        //o torneio por causa do baralho acabar ou por escolha do utilizador termina e mostra o relatório final
        if (gameDeck.cardsLeft() == 0) {
        System.out.println("\nO baralho terminou!");
        }
        // Mostra o relatório final do torneio
        showFinalReport();
    }
    
    // Incrementa o número de previsões corretas e pontos atribuídos globais
    public void recordCorrectPrediction() {
        correctPredictions++;
        totalPointsAwarded++;
    }

    // Apresenta o relatório final
    public void showFinalReport() {

        System.out.println("\n========== RELATÓRIO FINAL ==========");
        // Mostra as estatísticas de cada jogador
        for (player currentPlayer : players) {

            System.out.println("\nJogador: " + currentPlayer.getName());
            System.out.println("Tipo: " + currentPlayer.getPlayerType());
            System.out.println("Pontuação total: " + currentPlayer.getTotalScore());
            System.out.println("Rondas realizadas: " + currentPlayer.getRoundsPlayed());
            System.out.println("Média por ronda: " + currentPlayer.getAverageScore());
            System.out.println("Melhor ronda: " + currentPlayer.getBestScore());
            System.out.println("Histórico: " + currentPlayer.getScoreHistory());
        }
        // Mostra as estatísticas globais do torneio
        System.out.println("\n========== ESTATÍSTICAS GLOBAIS ==========");
        System.out.println("Jogadores registados: " + getNumberOfPlayers());
        System.out.println("Rondas concluídas: " + completedRounds);
        System.out.println("Previsões corretas: " + correctPredictions);
        System.out.println("Pontos atribuídos: " + totalPointsAwarded);
        // Identifica o vencedor ou vencedores
        showWinners();
    }

    // Identifica o vencedor ou vencedores
    private void showWinners() {

        int highestScore = -1;

        for (player currentPlayer : players) {
            if (currentPlayer.getTotalScore() > highestScore) {
                highestScore = currentPlayer.getTotalScore();
            }
        }

        System.out.println("\n========== VENCEDOR ==========");

        for (player currentPlayer : players) {
            if (currentPlayer.getTotalScore() == highestScore) {
                System.out.println(currentPlayer.getName());
            }
        }
    }
}