# Mini_projeto_2_POO
Mini projeto 2 de programação orientada a objetos grupo 7
Membros: 
Afonso Piçarra 22506165
Madalena Nunes 22400641
Keenan Bezerra 22405069

usarmo of farmeworks:
java.util.Scanner
java.util.ArrayList;
java.util.Collections;
java.util.List;
java.util.Scanner

A round termina quando todos os jogadores jogarem é pergunta se é para terminar o torneio no fim de um round 

Para "player.java":

Escolhemos fazer a classe player abstrata devido ao facto do jogador normal e o especial conterem os mesmos dados, sendo estes:
Nome;
Pontos;
Rondas;
Histórico. e só mudam na regra de quando falham. Desta maneira o que é comum fica só aqui e não se repete o código;
Os atributos são private para somente se mudarem pelos métodos (addPoints e finishRound);
O getScoreHistory devolve uma cópia da lista para ninguém alterar o histórico original;
O addPoints tem 2 versões (overload): uma com valor e outra que soma 1 ponto.
Para "normalPlayer.java":

O jogador normal herda de player e só define o que é diferente;
O canContinue devolve sempre false quando falha, porque a ronda acaba logo.
Para "specialPlayer.java":

O jogador especial herda de player e acrescenta a segunda oportunidade;
Usámos um boolean (secondChanceAvailable) para saber se ainda a pode usar;
O resetSecondChance é chamado no início de cada ronda, devido ao facto da oportunidade só poder ser usada uma vez por ronda.
Para "card.java":

A carta só guarda o valor e o naipe e os dois são private;
O toString mostra Ace, Jack, Queen e King em vez de 1, 11, 12 e 13 para a carta ser mais fácil e para seguirmos o modelo comum e convencional do baralho de cartas que todos nós conhecemos.
Para "deck.java":

O baralho é uma lista de caras criada com dois ciclos (naipes x valores) o que dá as 52 cartas sem ter de as escrever uma a uma;
O dealCard tira a carta da lista, deste modo a mesma carta não sai duas vezes;
Quando o baralho está vazio -> devolve null;
Para "round.java":

Separámos a ruond do tournament para a round tratar só das regras de uma ronda (cartas, previsões e pontos) e o tournament tratar de quem joga;
Cada ronda cria um baralho novo e baralhado, como pede o enunciado;
A round não precisa de saber as regras de cada jogador - pergunta ao canContinue - e cada tipo de jogador responde à sua maneira (polimorfismo);
O instanceof só é usado para repor a segunda oportunidade do jogador especial.
Para "tournament,java":

O tournament guarda os jogaroes numa list porque mantém a ordem da incrição, que é a ordem em que jogam;
As etatísticas globais ficam aqui porque é o tournament que vê todos os jogadores;
A round avisa-o com o recordCorrectPrediction sempre que há uma previsão certa;
Nos vencedores calculamos primeiro a pontuação máxima e depois mostramos todos os que a têm, para tratar os empates.
Para HighLow.java

A HighLow só lê os dados do utilizador (número de jogadores, nomes e tipos) e arranca o torneio. Criámos só um Scanner e passàmo-lo às outras classes para evitar problemas ao ler do teclado com vários Scanner
