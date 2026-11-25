
public class normalPlayer extends player {

    // Construtor com o objeto name da classe player
    public normalPlayer(String name) {
        super(name);
    }

    // Identifica o tipo de jogador
    @Override
    public String getPlayerType() {
        return "Normal";
    }

    // Verifica se o jogador pode continuar depois de uma previsão
    public boolean canContinue(boolean correctPrediction) {

        if (correctPrediction) {
            return true;
        }

        return false;
    }
}