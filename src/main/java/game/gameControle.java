package game;
import personagens.*;
import java.util.Objects;
import java.util.Random;

public class gameControle {
    private campoDoJogo tabuleiro;
    private personagem player1;
    private personagem player2;
    private Random numAleatorio = new Random();
    private prints prints = new prints();

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
        this.tabuleiro = new campoDoJogo(player1, player2);
        while (player1.estaVivo() && player2.estaVivo()) {
            prints.imprimirStatus(player1, player2);
            tabuleiro.exibirTabuleiro();
            if(player1.estaVivo()) {
                executarTurnoPVP(player1, player2);
            }
            if(player2.estaVivo()) {
                executarTurnoPVP(player2, player1);
            }
        }
        encerrarJogo(player1,player2);
    }

    private void encerrarJogo(personagem player1, personagem player2) {
        String escolha = prints.mensagemFinal(player1, player2);
        if(Objects.equals(escolha, "S")){
            new gameControle();
            start();
        }
        else
        {
          prints.agradecimentoFinal();
        }
    }

    private personagem personagemPlayer() {
        personagem player = null;
        String nome = prints.escolherNome();
        System.out.println("Escolha qual será o seu Perosnagem " + nome + " : ");
        int escolhas = prints.escolherPersonagem();
        switch(escolhas) {
            case 1:
                player = new arqueiro(nome);
                break;
            case 2:
                player = new guerreiro(nome);
                break;
            case 3:
                player = new mago(nome);
                break;
        }
        return player;
    }

    private void executarTurnoPVP(personagem atacante, personagem defensor) {
        int escolhas = prints.escolherAcao();
        switch (escolhas) {
            case 1:
                atacante.atacarPlayer(defensor);
                break;
            case 2://Defender
                if(atacante.getDefesaMax() > 0) {
                    atacante.restaurarDefesa();
                    atacante.setDefesaMax(atacante.getDefesaMax() - 1);
                    System.out.println("Quantidade de usos Restantes: " + atacante.getDefesaMax());
                }
                else{
                    System.out.println("Você usou seu limite de Resturar defesas!");
                    executarTurnoPVP(atacante, defensor);
                }
                    break;
            case 3:
                moverPVP(atacante);
                break;
            case 4:
                if(atacante.getLimitesPoderMax() > 0) {
                    atacante.usarPoderEspecial(defensor);
                    atacante.setLimitesPoderMax(atacante.getLimitesPoderMax() - 1);
                    System.out.println("Quantidade de usos Restantes: " + atacante.getLimitesPoderMax());
                }
                else{
                    System.out.println("Você usou seu limite de poder maximos!");
                    executarTurnoPVP(atacante, defensor);
                }
                break;
        }
    }

    private void moverPVP(personagem player) {
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
                tabuleiro.tentarExecutarMovimento(player, linha, coluna - 1);
                break;
            case "D":
                tabuleiro.tentarExecutarMovimento(player, linha, coluna + 1);

                break;
        }
        tabuleiro.exibirTabuleiro();
    }

    private void gameIA() {
        player1 = personagemPlayer();
        player2 = personagemIA();
        System.out.println("Iniciando Duelo de Personagens!");
        System.out.println("---------------------------------");
        tabuleiro = new campoDoJogo(player1, player2);
        while (player1.estaVivo() && player2.estaVivo()) {
            prints.imprimirStatus(player1, player2);
            tabuleiro.exibirTabuleiro();
            if(player1.estaVivo()) {
                executarTurnoPVP(player1, player2);
            }
            if(player2.estaVivo()) {
                executarTurnoIA(player2, player1);
            }
        }
        encerrarJogo(player1, player2);

    }

    private personagem personagemIA() {
        int escolha = numAleatorio.nextInt(1, 4);
        personagem player = null;
        System.out.println("A IA está analisando suas opções...");
        switch(escolha) {
            case 1:
                player = new arqueiro("Legolas");
                System.out.println("IA escolheu Arqueiro! ");
                break;
            case 2:
                player = new guerreiro("Garrosh");
                System.out.println("IA escolheu Guerreiro!");
                break;
            case 3:
                player = new mago("Ryze");
                System.out.println("IA escolheu Mago!");
                break;
        }
        return player;
    }

    private void executarTurnoIA(personagem playerIA, personagem player) {
        int distancia = tabuleiro.calcularDistancia();

        if (distancia > playerIA.getAlcanceDeAtaque()) {
            moverIA(playerIA, player);
            return;
        }
        if (playerIA.getPontosDeVida() <= 25 && player.getPontosDeVida() > 30) {
            if(playerIA.getDefesaMax() > 0){
            playerIA.restaurarDefesa();
            playerIA.setDefesaMax(playerIA.getDefesaMax() - 1);
            }
            else{
                playerIA.atacarPlayer(player);
            }
        } else if (playerIA.getPontosDeVida() >= 50 || playerIA.getPontosDeVida() <= 10) {
            playerIA.atacarPlayer(player);
        } else {
            if (player.getPontosDeVida() <= 30) {
                if(playerIA.getLimitesPoderMax() > 0){
                playerIA.usarPoderEspecial(player);
                playerIA.setLimitesPoderMax(playerIA.getLimitesPoderMax() - 1);
                }
                else{playerIA.atacarPlayer(player);
                }
            }
            else {
                playerIA.atacarPlayer(player);
            }

        }
    }

    private void moverIA(personagem playerIA, personagem player){
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



