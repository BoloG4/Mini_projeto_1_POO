
public class specialPlayer extends player {

    private boolean secondChanceAvailable;

    // Construtor com o objeto name da classe player 
    public specialPlayer(String name) {
        super(name);
        this.secondChanceAvailable = true;
    }

    // Identifica o tipo de jogador
    @Override
    public String getPlayerType() {
        return "Special";
    }

    // Verifica se o jogador pode continuar
    @Override
    public boolean canContinue(boolean correctPrediction) {

        // Se acertou pode continuar
        if (correctPrediction) {
            return true;
        }

        // Se falhou e ainda tem segunda oportunidade pode advinhar outra vez
        if (secondChanceAvailable) {
            secondChanceAvailable = false;
            return true;
        }

        // se falhou e não tem segunda oportunidade termina a partida
        return false;
    }

    // Reativa a segunda oportunidade
    public void resetSecondChance() {
        secondChanceAvailable = true;
    }

    // Verifica se a segunda oportunidade está disponível
    public boolean isSecondChanceAvailable() {
        return secondChanceAvailable;
    }
}
