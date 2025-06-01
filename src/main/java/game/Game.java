package game;
import Personagem.Personagem;
import Personagem.*;

public class Game {
    private Tabuleiro tabuleiro;
    private Personagem player1;
    private Personagem player2;


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
        switch(escolhas) {
            case 1: // Criar um Arqueiro
                player = new Arqueiro(nome);
                break;
            case 2:// Criar um Guerreiro
                player = new Guerreiro(nome);
                break;
            case 3:// Criar um Mago
                player = new Mago(nome);
                break;
        }
        return player;
    }

    public void gamePlayerXIA(){}

    public void gameAcao(Personagem player1, Personagem player2){
        //Player 1 sempre será aquele que efetuará a ação.
        Prints prints = new Prints();
        int escolhas = prints.escolherAcao();
        switch (escolhas){
            case 1:
                player1.atacar(player2);
                break;
            case 2://Defender
                player1.restaurarDefesa();
                break;
            case 3:// Mover

                break;
            case 4:// taque especial
                player1.usarPoderEspecial(player2);
                break;
            }

        }

    }


