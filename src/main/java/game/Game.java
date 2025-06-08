package game;
import Personagem.Personagem;
import Personagem.*;

import java.util.Scanner;

public class Game {
    private Tabuleiro tabuleiro;
    private Personagem player1;
    private Personagem player2;
    private Personagem  ia;


    public Game() {
        Prints prints = new Prints();
        int escolhas;
        prints.exibirMensagemInicial();
        escolhas = prints.escolherModoDeJogo();
        switch (escolhas) {
            case 1: // 1 vs 1
                gamePlayerXPlayer();
                break;
            case 2: // vs IA
                gamePlayerXIA();
                break;
        }
    }

    public void gamePlayerXPlayer() {
        //Escolha de Personagens
        Prints prints = new Prints();
        System.out.println("Escolha Player1: "); //Melhorar
        player1 = escolhaPersonagem();
        System.out.println("Escolha Player2: "); // Melhorar
        player2 = escolhaPersonagem();
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        this.tabuleiro = new Tabuleiro(player1, player2);
        while(player1.estaVivo() && player2.estaVivo()) { //Enquanto estiverem vivos vai rodar;
            prints.imprimirStatus(player1,player2);
            tabuleiro.exibirTabuleiro();
            //Player 1
            gameAcao(player1, player2);
            //Player 2
            gameAcao(player2,player1);
        }
        prints.mensagemFinal(player1,player2);
    }

    public Personagem escolhaPersonagem() {
        Prints prints = new Prints();
        Personagem player = null;
        String nome = prints.escolherNome();
        int escolhas = prints.escolherPersonagem();
        switch(escolhas) {   //escolha de personagens para o jogo
            case 1:
                player = new Arqueiro(nome);
                break;
            case 2:
                player = new Guerreiro(nome);
                break;
            case 3:
                player = new Mago(nome);
                break;
        }
        return player;
    }

    // cria personagem IA
    public Personagem escolherIA() {
        int val;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual bot gostaria de enfrentar?(Insira o numero de referencia!) ");
        System.out.println("1 - Arqueiro, 2- Guerreiro, 3-Mago ");
        do {
            val = teclado.nextInt();
        }
        while(val > 3 && val < 1 ); //Validador de valores, podendo inserir apenas entre 1 e 3

        switch(val) //escolha de IA
        {
            case 1:
                ia = new Arqueiro("Legolas");
                break;

            case 2:
                ia = new Guerreiro("Garrosh");
                break;

            case 3:
                ia = new Mago("Ryze");
                break;

        }
        return ia;
    }





    public void gamePlayerXIA(){

        Prints prints = new Prints();
       // int valor;
        System.out.println("Escolha Player1: "); //Melhorar
        player1 = escolhaPersonagem();
        player2 = escolherIA();
        this.tabuleiro = new Tabuleiro(player1, ia);
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        tabuleiro.definirPosicoesIniciaisAleatorias();

        while(player1.estaVivo() && ia.estaVivo()) { //Enquanto estiverem vivos vai rodar;
            prints.imprimirStatus(player1,ia);
            tabuleiro.exibirTabuleiro();

            //Implementar Forma de randomizar quem inicia o turno Inicial!!(Lembrando este loop e o jogo inteiro nao alterar dentro dele)

            //Player 1
            gameAcaoIA(player1, ia);
            //IA
            gameAcaoIA(ia,player1);
        }
        prints.mensagemFinal(player1,ia);


    }

    public void gameAcao(Personagem atacante, Personagem defensor ){
        // atacante representa quem vai executar a ação no turno e defensor quem receberá a ação
        Prints prints = new Prints();
        int escolhas = prints.escolherAcao();
        switch (escolhas){
            case 1:
                atacante.atacar(defensor);
                break;
            case 2://Defender
                atacante.restaurarDefesa();
                break;
            case 3:// Mover
                mover(player1);
                break;
            case 4:// ataque especial
                atacante.usarPoderEspecial(defensor);
                break;
            }
        }

public void gameAcaoIA(Personagem atacante, Personagem defensor ){
    // atacante representa quem vai executar a ação no turno e defensor quem receberá a ação
    Prints prints = new Prints();
    int escolhas = prints.escolherAcao();
    switch (escolhas){
        case 1:
            atacante.atacar(defensor);
            break;
        case 2://Defender
            atacante.restaurarDefesa();
            break;
        case 3:// Mover

            break;
        case 4:// ataque especial
            atacante.usarPoderEspecial(defensor);
            break;
    }
}

 }

}



