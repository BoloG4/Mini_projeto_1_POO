
import java.util.ArrayList;
import java.util.List;

public abstract class player {

    private String name;
    private int totalScore;
    private int roundsPlayed;
    private List<Integer> scoreHistory;

    // Construtor
    public player(String name) {
        this.name = name;
        this.totalScore = 0;
        this.roundsPlayed = 0;
        this.scoreHistory = new ArrayList<>();
    }

    // Retorna o nome do jogador
    public String getName() {
        return name;
    }

    // Retorna a pontuação acumulada do jogador
    public int getTotalScore() {
        return totalScore;
    }

    // Retorna o número de rondas realizadas pelo jogador
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    // Retorna o histórico de pontuações do jogador
    public List<Integer> getScoreHistory() {
        return new ArrayList<>(scoreHistory);
    }

    // Adiciona pontos à pontuação acumulada 
    public void addPoints(int points) {
        totalScore += points;
    }
    // Adiciona 1 ponto à pontuação acumulada (overload do método addPoints)
    public void addPoints() {
    totalScore++;
    }

    // Regista a pontuação de uma ronda e incrementa o número de rondas realizadas
    public void finishRound(int roundScore) {
        scoreHistory.add(roundScore);
        roundsPlayed++;
    }

    // Calcula a média de pontos por ronda 
    public double getAverageScore() {

        if (roundsPlayed == 0) {
            return 0;
        }

        return (double) totalScore / roundsPlayed;
    }

    // Devolve a melhor pontuação obtida numa ronda
    public int getBestScore() {

        int bestScore = 0;

        for (int score : scoreHistory) {
            if (score > bestScore) {
                bestScore = score;
            }
        }

        return bestScore;
    }

    // Método abstrato para identificar o tipo de jogador
    public abstract String getPlayerType();

    // Método abstrato para determinar se o jogador pode continuar
    public abstract boolean canContinue(boolean correctPrediction);
}
