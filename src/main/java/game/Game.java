package game;
import Personagem.Personagem;
import Personagem.*;

import java.util.Objects;
import java.util.Random;

public class Game {
    private Tabuleiro tabuleiro;
    private Personagem player1;
    private Personagem player2;
    private Random numAleatorio = new Random();
    private Prints prints = new Prints();



    public Game() {}

    public void start() {
        prints.exibirMensagemInicial();
        int escolha = prints.escolherModoDeJogo();
        if (escolha == 1) {
            gamePlayerXPlayer();
        } else {
            gameIA();
        }
    }

    private void gamePlayerXPlayer() {
        player1 = personagemPlayer();
        player2 = personagemPlayer();
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        this.tabuleiro = new Tabuleiro(player1, player2);
        while (player1.estaVivo() && player2.estaVivo()) {
            prints.imprimirStatus(player1, player2);
            tabuleiro.exibirTabuleiro();
            //Player 1
            executarTurnoPVP(player1, player2);
            //Player 2
            executarTurnoPVP(player2, player1);
        }
        encerrarJogo(player1,player2);
    }

    private void encerrarJogo(Personagem player1, Personagem player2) {
        String escolha = prints.mensagemFinal(player1, player2);
        if(Objects.equals(escolha, "S")){
            new Game();
        }
        prints.agradecimentoFinal();
    }

    private Personagem personagemPlayer() {
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

    private void executarTurnoPVP(Personagem atacante, Personagem defensor) {
        int escolhas = prints.escolherAcao();
        switch (escolhas) {
            case 1:
                atacante.atacar(defensor);
                break;
            case 2://Defender
                atacante.restaurarDefesa();
                break;
            case 3:// Mover
                moverPVP(atacante);
                break;
            case 4:// ataque especial
                atacante.usarPoderEspecial(defensor);
                break;
        }
    }

    private void moverPVP(Personagem player) {
        String escolha = prints.escolherPosicao();
        int linha = player.getLinha();
        int coluna = player.getCol();
        switch (escolha) {
            case "C":
                tabuleiro.tentarExecutarMovimento(player, linha - 1, coluna);
                break;
            case "B":
                tabuleiro.tentarExecutarMovimento(player, linha + 1, coluna);
                break;
            case "E":
                tabuleiro.tentarExecutarMovimento(player, linha, coluna + 1);
                break;
            case "D":
                tabuleiro.tentarExecutarMovimento(player, linha, coluna - 1);
                break;
        }
        tabuleiro.exibirTabuleiro();
    }

    private void gameIA() {
        System.out.println("Escolha Player1: ");
        player1 = personagemPlayer();
        player2 = personagemIA();
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        tabuleiro = new Tabuleiro(player1, player2);
        while (player1.estaVivo() && player2.estaVivo()) {
            prints.imprimirStatus(player1, player2);
            tabuleiro.exibirTabuleiro();
            //Player 1
            executarTurnoPVP(player1, player2);
            //Player IA
            executarTurnoIA(player2, player1);
        }
        encerrarJogo(player1, player2);
    }

    private Personagem personagemIA() {
        int escolha = numAleatorio.nextInt(1, 4);
        Personagem player = null;
        System.out.println("A IA está analisando suas opções...");
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

    private void executarTurnoIA(Personagem playerIA, Personagem player) {
        int distancia = tabuleiro.calcularDistancia();

        if (distancia > playerIA.getAlcanceDeAtaque()) {
            System.out.println("IA está se aproximando para o ataque.");
            moverIA(playerIA, player);
            return;
        }
        if (playerIA.getPontosDeVida() <= 25 && player.getPontosDeVida() > 30) {
            playerIA.usarPoderEspecial(player);
        } else if (playerIA.getPontosDeVida() >= 50) {
            playerIA.atacar(player);
        } else {
            if (player.getPontosDeVida() <= 30) {
                playerIA.usarPoderEspecial(player);
            } else {
                playerIA.atacar(player);
            }
        }
    }

    private void moverIA(Personagem playerIA, Personagem player){
        int linhaIA = playerIA.getLinha();
        int colunaIA = playerIA.getCol();
        int linhaPlayer = player.getLinha();
        int colunaPlayer = player.getCol();
        int moverLinha = Math.abs(linhaIA - linhaPlayer);
        int moverColuna = Math.abs(colunaIA - colunaPlayer);

        if (moverColuna > moverLinha) {
            if (colunaIA > colunaPlayer)
                tabuleiro.tentarExecutarMovimento(playerIA, linhaIA, colunaIA - 1);
            else
                tabuleiro.tentarExecutarMovimento(playerIA, linhaIA, colunaIA + 1);
        }
        else {
            if (linhaIA > linhaPlayer)
                tabuleiro.tentarExecutarMovimento(playerIA, linhaIA - 1, colunaIA);
            else
                tabuleiro.tentarExecutarMovimento(playerIA, linhaIA + 1, colunaIA);
        }

    }
}



