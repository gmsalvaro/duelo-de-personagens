package game;

import Personagem.Personagem;

import java.util.Random;
import java.util.Scanner;


public class Tabuleiro {
        private static final int TAMANHO = 10; // Definindo o tamanho do tabuleiro como uma constante
        private String[][] tabuleiro;
        private Personagem player1;
        private Personagem player2;
        private static final Random aleatorio = new Random();

        // Construtor do Tabuleiro
        public Tabuleiro(Personagem p1, Personagem p2) {
            this.tabuleiro = new String[TAMANHO][TAMANHO];
            this.player1 = p1;
            this.player2 = p2;
            inicializatabuleiro();
        }

        // Método para determinar de forma aleatória a posição inicial de cada jogador
        public void definirPosicoesIniciaisAleatorias() {
            System.out.println("Posicionando personagens aleatoriamente no tabuleiro...");

            int linhaP1, colunaP1;
            // Gera posições para o player1 até encontrar uma válida e vazia
            do {
                linhaP1 = aleatorio.nextInt(TAMANHO);
                colunaP1 = aleatorio.nextInt(TAMANHO);
            } while (posicaoVazia(linhaP1, colunaP1)); // Continua enquanto a posição não for vazia

            // Define a posição no objeto Personagem
            player1.setPosition(linhaP1, colunaP1);
            // Atualiza a representação visual no Tabuleiro
            posicionarTabuleiro(linhaP1, colunaP1, player1);

            int linhaP2, colunaP2;
            // Gera posições para o player2 até encontrar uma válida e vazia (e diferente da do player1)
            do {
                linhaP2 = aleatorio.nextInt(TAMANHO);
                colunaP2 = aleatorio.nextInt(TAMANHO);
            } while (posicaoVazia(linhaP2, colunaP2)); // Continua enquanto a posição não for vazia

            // Define a posição no objeto Personagem
            player2.setPosition(linhaP2, colunaP2);
            // Atualiza a representação visual no Tabuleiro
            posicionarTabuleiro(linhaP2, colunaP2, player2);

            System.out.println(player1.getNome() + " posicionado em (" + linhaP1 + "," + colunaP1 + ")");
            System.out.println(player2.getNome() + " posicionado em (" + linhaP2 + "," + colunaP2 + ")");
        }


        private void posicionarTabuleiro(int linha, int coluna, Personagem personagem) {
            if (verificaPosicao(linha, coluna)) {
                tabuleiro[linha][coluna] = String.valueOf(personagem.getNome().charAt(0)); // Melhorar;
            }
        }


        public void liberaPosicao(int linha, int coluna) {
            if (verificaPosicao(linha, coluna)) {
                tabuleiro[linha][coluna] = "."; // Preencher o tabuleiro com ponto na posição (provavelmente pós se mover);
            }
        }

        //Preencher todo o tabuleiro;
        private void inicializatabuleiro() {
            for (int i = 0; i < TAMANHO; i++) {
                for (int j = 0; j < TAMANHO; j++) {
                    tabuleiro[i][j] = ".";
                }
            }
        }

        //Verificar se a posição estar Ocupada;

        public boolean posicaoVazia(int linha, int coluna) {
            if (!verificaPosicao(linha, coluna)) {
                return true; // Se a posição não é válida, não pode ser vazia
            }
            // Verifica se a posição não é a do player1 e não é a do player2
            boolean ocupadaPorP1 = (player1 != null && player1.getLinha() == linha && player1.getCol() == coluna);
            boolean ocupadaPorP2 = (player2 != null && player2.getLinha() == linha && player2.getCol() == coluna);

            return ocupadaPorP1 || ocupadaPorP2; // Retorna true se NÃO estiver ocupada
        }



        public boolean verificaPosicao(int linha, int coluna) {
            return linha >= 0 && linha < TAMANHO && coluna >= 0 && coluna < TAMANHO;
        }


         // Exibe o tabuleiro no console usando a matriz de String.

        public void exibirTabuleiro() {
            System.out.println("\n--- TABULEIRO ---");
            // Cabeçalho das colunas
            System.out.print("   ");
            for (int j = 0; j < TAMANHO; j++) {
                System.out.printf("%2d ", j);
            }
            System.out.println();
            System.out.println("   " + "---".repeat(TAMANHO)); // Linha divisória

            // Conteúdo do tabuleiro
            for (int i = 0; i < TAMANHO; i++) {
                System.out.printf("%2d |", i); // Numeração das linhas
                for (int j = 0; j < TAMANHO; j++) {
                    System.out.print(tabuleiro[i][j] + "  ");
                }
                System.out.println();
            }
            System.out.println("-----------------\n");
        }

        //
        public int calcularDistancia() { //Verificar esse calculo
            int distLinha = Math.abs(player1.getLinha() - player2.getLinha());
            int distColuna = Math.abs(player1.getCol() - player2.getCol());
            return distLinha + distColuna;
        }

        //Metodo para mover o personagem
        public void moverPersonagem(Personagem playerAcao, int novaLinha, int novaColuna) {

            if (!verificaPosicao(novaLinha, novaColuna)) {
                System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") fora dos limites do tabuleiro.");
                return;
            }
            // Validação se a nova posição está logicamente ocupada por OUTRO personagem
            if(posicaoVazia(novaLinha, novaColuna)){ // se estiver cheia retornara false, logo sera true
                if(playerAcao.getLinha() == novaLinha && playerAcao.getCol() == novaColuna){
                    System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") voce oucupa essa posição.");
                    return;
                }
                System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") já estar ocupado.");
                return;
            }
            // Se o movimento é válido logicamente:
            int linhaAntiga = playerAcao.getLinha();
            int colunaAntiga = playerAcao.getCol();
            playerAcao.setPosition(novaLinha, novaColuna);

            // Libera a posição antiga e marca a nova
            liberaPosicao(linhaAntiga, colunaAntiga); // Libera a posição antiga
            posicionarTabuleiro(novaLinha, novaColuna, playerAcao); // Marca a nova posição
            System.out.println(playerAcao.getNome() + " moveu de (" + linhaAntiga + "," + colunaAntiga + ") para (" + novaLinha + "," + novaColuna + ").");
            //exibir tabela atualizada
        }
    }

