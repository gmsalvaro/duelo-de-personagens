package game;
import Personagem.Personagem;
import Personagem.*;

import java.util.Scanner;

public class Game {
    private Tabuleiro tabuleiro;
    private Personagem player1;
    private Personagem player2;
    private PlayerIA ia;


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
        this.tabuleiro = new Tabuleiro(player1, player2);
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        tabuleiro.definirPosicoesIniciaisAleatorias();

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

    public void gamePlayerXIA(){

        Prints prints = new Prints();
        int valor;
        System.out.println("Escolha Player1: "); //Melhorar
        player1 = escolhaPersonagem();
            Scanner teclado = new Scanner(System.in);
            System.out.println("Qual bot gostaria de enfrentar?(Insira o numero de referencia!) ");
            System.out.println("1 - Arqueiro, 2- Guerreiros, 3-Mago ");
            //Criar validador para entrada
            valor = teclado.nextInt();

            switch(valor) //escolha de IA
            {
                case 1:
                    ia = new PlayerIA("Legolas",8,5,5);
                    break;

                case 2:
                    ia = new PlayerIA("Garrosh",15,10,1);
                    break;

                case 3:
                    ia = new PlayerIA("Ryze",10,7,3);
                    break;

            }
        this.tabuleiro = new Tabuleiro(player1, ia);
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        tabuleiro.definirPosicoesIniciaisAleatorias();

        while(player1.estaVivo() && ia.estaVivo()) { //Enquanto estiverem vivos vai rodar;
            prints.imprimirStatus(player1,ia);
            tabuleiro.exibirTabuleiro();
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

                break;
            case 4:// ataque especial
                atacante.usarPoderEspecial(defensor);
                break;
            }

        }

    }

public void gameAcaoIA(PlayerIA ia, Personagem player ){
    // atacante representa quem vai executar a ação no turno e defensor quem receberá a ação
    Prints prints = new Prints();
    int escolhas = prints.escolherAcao();
    switch (escolhas){
        case 1:
            player.atacar(ia);
            break;
        case 2://Defender
            player.restaurarDefesa();
            break;
        case 3:// Mover

            break;
        case 4:// ataque especial
            player.usarPoderEspecial(ia);
            break;
    }



 }

}



