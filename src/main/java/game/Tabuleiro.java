package game;
import Personagem.Personagem;
import java.util.Random;


public class Tabuleiro {
        private int tamanho = 10;
        private String[][] tabuleiro;
        private Personagem player1;
        private Personagem player2;
        private Random numAleatorio = new Random();

        public Tabuleiro(Personagem p1, Personagem p2) {
            this.tabuleiro = new String[tamanho][tamanho];
            this.player1 = p1;
            this.player2 = p2;
            inicializaTabuleiro();
            definirPosicoesIniciaisAleatorias();
        }
        private void definirPosicoesIniciaisAleatorias() {
            System.out.println("Posicionando personagens aleatoriamente no tabuleiro...");
            int linhaP1, colunaP1;
            do {
                linhaP1 = numAleatorio.nextInt(tamanho);
                colunaP1 = numAleatorio.nextInt(tamanho);
            } while (verificaVazia(linhaP1, colunaP1));
            player1.setPosition(linhaP1, colunaP1);
            posicionarTabuleiro(linhaP1, colunaP1, player1);

            int linhaP2, colunaP2;
            do {
                linhaP2 = numAleatorio.nextInt(tamanho);
                colunaP2 = numAleatorio.nextInt(tamanho);
            } while (verificaVazia(linhaP2, colunaP2));
            player2.setPosition(linhaP2, colunaP2);
            posicionarTabuleiro(linhaP2, colunaP2, player2);
            System.out.println(player1.getNome() + " posicionado em (" + linhaP1 + "," + colunaP1 + ")");
            System.out.println(player2.getNome() + " posicionado em (" + linhaP2 + "," + colunaP2 + ")");
        }


        private void posicionarTabuleiro(int linha, int coluna, Personagem personagem) {
                tabuleiro[linha][coluna] = String.valueOf(personagem.getNome().charAt(0));
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

        private boolean verificaVazia(int linha, int coluna) {
            if (verificaLimites(linha, coluna)) {
                return true;
            }
            boolean ocupadaPorP1 = (player1 != null && player1.getLinha() == linha && player1.getCol() == coluna);
            boolean ocupadaPorP2 = (player2 != null && player2.getLinha() == linha && player2.getCol() == coluna);
            return ocupadaPorP1 || ocupadaPorP2;
        }

        private boolean verificaLimites(int linha, int coluna) {
            return linha < 0 || linha >= tamanho || coluna < 0 || coluna >= tamanho;
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


        public void tentarExecutarMovimento(Personagem playerAcao, int novaLinha, int novaColuna){
            if (verificaLimites(novaLinha, novaColuna)) {
                System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") fora dos limites do tabuleiro.");
                return;
            }
            if(verificaVazia(novaLinha, novaColuna)){
                if(playerAcao.getLinha() == novaLinha && playerAcao.getCol() == novaColuna){
                    System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") voce já estar nessa posição.");
                    return;
                }
                System.out.println("Movimento inválido para " + playerAcao.getNome() + ": Posição (" + novaLinha + "," + novaColuna + ") já estar ocupado.");
                return;
            }
            System.out.println(playerAcao.getNome() + " moveu de (" + playerAcao.getLinha()+ "," + playerAcao.getLinha() + ") para (" + novaLinha + "," + novaColuna + ").");
            moverPersonagem(playerAcao, novaLinha, novaColuna);
        }

        public int calcularDistancia() {
            int distLinha = Math.abs(player1.getLinha() - player2.getLinha());
            int distColuna = Math.abs(player1.getCol() - player2.getCol());
            return Math.max(distLinha, distColuna);
        }


        private void moverPersonagem(Personagem playerAcao, int novaLinha, int novaColuna) {
            int linhaAntiga = playerAcao.getLinha();
            int colunaAntiga = playerAcao.getCol();
            playerAcao.setPosition(novaLinha, novaColuna);
            liberaPosicao(linhaAntiga, colunaAntiga);
            posicionarTabuleiro(novaLinha, novaColuna, playerAcao);
        }
    }

