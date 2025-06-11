package game;
import personagens.*;
import java.util.Random;


public class campoDoJogo {
        private int tamanho = 10;
        private String[][] tabuleiro;
        private personagem player1;
        private personagem player2;
        private Random numAleatorio = new Random();

        public campoDoJogo(personagem player1, personagem player2) {
            this.tabuleiro = new String[tamanho][tamanho];
            this.player1 = player1;
            this.player2 = player2;
            inicializaTabuleiro();
            definirPosicoesIniciaisAleatorias();
        }
        private void definirPosicoesIniciaisAleatorias() {
            System.out.println("Posicionando personagens aleatoriamente no tabuleiro...");
            int linhaP1, colunaP1;
            do {
                linhaP1 = numAleatorio.nextInt(tamanho);
                colunaP1 = numAleatorio.nextInt(tamanho);
            } while (!verificarVazia(linhaP1, colunaP1));
            player1.setPosicao(linhaP1, colunaP1);
            posicionarTabuleiro(linhaP1, colunaP1, player1);

            int linhaP2, colunaP2;
            do {
                linhaP2 = numAleatorio.nextInt(tamanho);
                colunaP2 = numAleatorio.nextInt(tamanho);
            } while (!verificarVazia(linhaP2, colunaP2));
            player2.setPosicao(linhaP2, colunaP2);
            posicionarTabuleiro(linhaP2, colunaP2, player2);
            System.out.println(player1.getNome() + " posicionado em (" + linhaP1 + "," + colunaP1 + ")");
            System.out.println(player2.getNome() + " posicionado em (" + linhaP2 + "," + colunaP2 + ")");
        }


        private void posicionarTabuleiro(int linha, int coluna, personagem player) {
                tabuleiro[linha][coluna] = String.valueOf(player.getNome().charAt(0));
        }

        private void liberaPosicao(int linha, int coluna) {
                tabuleiro[linha][coluna] = ".";
        }

        private void inicializaTabuleiro() {
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    tabuleiro[i][j] = ".";
                }
            }
        }

        private boolean verificarVazia(int linha, int coluna) {
            if (!verificarLimites(linha, coluna)) {
                return false;
            }
            boolean ocupadaPorP1 = (player1 != null && player1.getLinha() == linha && player1.getCol() == coluna);
            boolean ocupadaPorP2 = (player2 != null && player2.getLinha() == linha && player2.getCol() == coluna);
            return !(ocupadaPorP1 || ocupadaPorP2);
        }

        private boolean verificarLimites(int linha, int coluna) {
            return linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho;
        }

        public void exibirTabuleiro() { //
            System.out.println("\n--- TABULEIRO ---");
            // Cabeçalho das colunas
            System.out.print("   ");
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("%2d ", j);
            }
            System.out.println();
            System.out.println("   " + "---".repeat(tamanho));

            for (int i = 0; i < tamanho; i++) {
                System.out.printf("%1d |", i);
                for (int j = 0; j < tamanho; j++) {
                    System.out.print(tabuleiro[i][j] + "  ");
                }
                System.out.println();
            }
            System.out.println("-----------------\n");
        }

        public void tentarExecutarMovimento(personagem playerAcao, int novaLinha, int novaColuna){
            if (!verificarLimites(novaLinha, novaColuna)) {
                System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") fora dos limites do tabuleiro.");
                return;
            }

            if (!verificarVazia(novaLinha, novaColuna)) {
                System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") já está ocupada.");
                return;
            }
            System.out.println(playerAcao.getNome() + " moveu de (" + playerAcao.getLinha()+ "," + playerAcao.getCol() + ") para (" + novaLinha + "," + novaColuna + ").");
            moverPersonagem(playerAcao, novaLinha, novaColuna);
        }

        public int calcularDistancia() {
            int distLinha = Math.abs(player1.getLinha() - player2.getLinha());
            int distColuna = Math.abs(player1.getCol() - player2.getCol());
            return Math.max(distLinha, distColuna);
        }


        private void moverPersonagem(personagem playerAcao, int novaLinha, int novaColuna) {
            int linhaAntiga = playerAcao.getLinha();
            int colunaAntiga = playerAcao.getCol();
            playerAcao.setPosicao(novaLinha, novaColuna);
            liberaPosicao(linhaAntiga, colunaAntiga);
            posicionarTabuleiro(novaLinha, novaColuna, playerAcao);
        }
    }

