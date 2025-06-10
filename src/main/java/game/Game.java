package game;
import Personagem.Personagem;
import Personagem.*;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Tabuleiro tabuleiro;
    private Personagem player1;
    private Personagem player2;
    private Random numAleatorio = new Random();


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
        player1 = escolhaPersonagem();
        player2 = escolhaPersonagem();
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        this.tabuleiro = new Tabuleiro(player1, player2);
        while (player1.estaVivo() && player2.estaVivo()) { //Enquanto estiverem vivos vai rodar;
            prints.imprimirStatus(player1, player2);
            tabuleiro.exibirTabuleiro();
            //Player 1
            gameAcao(player1, player2);
            //Player 2
            gameAcao(player2, player1);
        }
    }

    public void finalGame(Personagem player1, Personagem player2) {
        Prints prints = new Prints();
        String escolha = prints.mensagemFinal(player1, player2);
        if(Objects.equals(escolha, "S")){
            new Game();
        }
    }


    public Personagem escolhaPersonagem() {
        Prints prints = new Prints();
        Personagem player = null;
        String nome = prints.escolherNome();
        System.out.println("Escolha qual será o seu Perosnagem " + nome + " : ");
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

    public void gameAcao(Personagem atacante, Personagem defensor) {
        Prints prints = new Prints();
        int escolhas = prints.escolherAcao();
        switch (escolhas) {
            case 1:
                atacante.atacar(defensor);
                break;
            case 2://Defender
                atacante.restaurarDefesa();
                break;
            case 3:// Mover
                mover(atacante);
                break;
            case 4:// ataque especial
                atacante.usarPoderEspecial(defensor);
                break;
        }
    }

    public void mover(Personagem player) {
        Prints prints = new Prints();
        String escolha = prints.escolherPosicao();
        int linha = player.getLinha();
        int coluna = player.getCol();
        switch (escolha) {
            case "C": // Cima
                tabuleiro.tentarMover(player, linha - 1, coluna);
                break;
            case "B"://Baixo
                tabuleiro.tentarMover(player, linha + 1, coluna);
                break;
            case "E":// Esquerda
                tabuleiro.tentarMover(player, linha, coluna + 1);
                break;
            case "D":// Direita
                tabuleiro.tentarMover(player, linha, coluna - 1);
                break;
        }
        tabuleiro.exibirTabuleiro();
    }

    public void gamePlayerXIA() {
        Prints prints = new Prints();
        System.out.println("Escolha Player1: ");
        player1 = escolhaPersonagem();
        player2 = escolherPersonagemIA();
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        tabuleiro = new Tabuleiro(player1, player2);
        while (player1.estaVivo() && player2.estaVivo()) {
            prints.imprimirStatus(player1, player2);
            tabuleiro.exibirTabuleiro();
            //Player 1
            gameAcao(player1, player2);
            //Player IA
            gameAcaoIA(player2, player1);
        }
        finalGame(player1, player2);
    }

    public Personagem escolherPersonagemIA() {
        int escolha = numAleatorio.nextInt(1, 4); // vai gerar um valor de 0 a 2
        Personagem player = null;
        System.out.println("IA estar pensando na melhor opção...");
        switch(escolha) {
            case 1:
                player = new Arqueiro("Legolas");
                System.out.println("IA escolheu Arqueiro! ");

                break;
            case 2:
                player = new Guerreiro("Garrosh");
                System.out.println("IA escolheu Guerreiro!");
                break;
            case 3:
                player = new Mago("Ryze");
                System.out.println("IA escolheu Mago!");
                break;
        }
        return player;
    }

    public void gameAcaoIA(Personagem playerIA, Personagem player) {
        int distancia = tabuleiro.calcularDistancia();
        if (distancia > playerIA.getAlcanceDeAtaque()) {
            moverIA(playerIA, player);
            return;
        }
        if (distancia <= playerIA.getAlcanceDeAtaque()) {
            if (playerIA.getPontosDeVida() >= 50) {
                playerIA.atacar(player);
            }
            else if (playerIA.getPontosDeVida() <= 25) {
                playerIA.restaurarDefesa();
            }
            else {
                playerIA.usarPoderEspecial(player);
            }
        }
    }

    public void moverIA(Personagem playerIA, Personagem player){
        int linhaIA = playerIA.getLinha();
        int colunaIA = playerIA.getCol();
        int linhaPlayer = player.getLinha();
        int colunaPlayer = player.getCol();
        int moverLinha = Math.abs(linhaIA - linhaPlayer);
        int moverColuna = Math.abs(colunaIA - colunaPlayer);

        if (moverColuna > moverLinha) {
            if (colunaIA > colunaPlayer)
                tabuleiro.tentarMover(playerIA, linhaIA, colunaIA - 1); // Esquerda
            else
                tabuleiro.tentarMover(playerIA, linhaIA, colunaIA + 1); // Direita
        }
        else {
            if (linhaIA > linhaPlayer)
                tabuleiro.tentarMover(playerIA, linhaIA - 1, colunaIA); // Cima
            else
                tabuleiro.tentarMover(playerIA, linhaIA + 1, colunaIA); // Baixo
        }

    }
}



