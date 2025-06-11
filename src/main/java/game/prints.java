package game;
import personagens.*;
import java.util.Scanner;

public class prints {
    private Scanner teclado = new Scanner(System.in);

    public void exibirMensagemInicial() {
        System.out.println("---------------------------------");
        System.out.println(" Bem-vindo ao Duelo de Personagens!");
        System.out.println("       Prepare-se para a batalha!");
        System.out.println("---------------------------------");
    }

    public int escolherModoDeJogo() {
        System.out.println("\nEscolha o modo de jogo:");
        System.out.println("1. Jogador vs Jogador");
        System.out.println("2. Jogador vs IA");
        System.out.print("Qual sua escolha: ");
        return lerOpcaoValidaInt(new int[]{1, 2});
    }

    public void imprimirDescricaoArqueiro() {
        System.out.println("Poder Especial: FLECHA PRECISA");
        System.out.println("Aumenta permanentemente seu alcance em +1.");
        System.out.println("Atributos: Ataque 8 | Defesa 5 | Alcance 5");
    }
    public void imprimirDescricaoGuerreiro() {
        System.out.println("Poder Especial: CARGA BRUTAL");
        System.out.println(" Dobra seu dano de ataque.");
        System.out.println("Atributos: Ataque 15 | Defesa 10 | Alcance 1");
    }
    public void imprimirDescricaoMago() {
        System.out.println("Poder Especial: TROCA DE VIDA");
        System.out.println("Troca seus PV com os do inimigo.");
        System.out.println("Atributos: Ataque 10 | Defesa 7 | Alcance 3");
    }


    public int escolherPersonagem(){
        System.out.println();
        System.out.println("1. Arqueiro");
        imprimirDescricaoArqueiro();
        System.out.println();
        System.out.println("2. Guerreiro");
        imprimirDescricaoGuerreiro();
        System.out.println();
        System.out.println("3. Mago");
        imprimirDescricaoMago();
        return lerOpcaoValidaInt(new int[]{1, 2, 3});
    }

    public String escolherNome(){
        System.out.println("\nEscolha qual será o nome do seu personagem: ");
        return teclado.nextLine();
    }

    public void imprimirStatus(personagem player1, personagem player2){
        System.out.println("---------------------------------");
        System.out.printf("%-15s  %-15s\n", player1.getNome(), player2.getNome());
        System.out.printf("PV: %-13d PV: %-13d\n", player1.getPontosDeVida(), player2.getPontosDeVida());
        System.out.printf("DEF: %-13d DEF: %-13d\n", player1.getForcaDeDefesa(), player2.getForcaDeDefesa());
        System.out.println("---------------------------------");
    }

    public int escolherAcao(){
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Mover");
        System.out.println("4. Ataque especial");
        System.out.println("5. Desistir");
        return lerOpcaoValidaInt(new int[]{1, 2, 3, 4, 5});
    }

    public String escolherPosicao(){
        System.out.println("C - CIMA");
        System.out.println("B - BAIXO");
        System.out.println("E - ESQUERDA");
        System.out.println("D - DIREITA");
        System.out.print("Escolha a posição: ");
        return lerLetraValidaString(new String[]{"C", "B", "E", "D"});
    }

    public String mensagemFinal(personagem player1, personagem player2) {
        System.out.println("\n=================================");
        System.out.println("           FIM DE JOGO");
        System.out.println("=================================");
        if (player1.estaVivo()) {
            System.out.println("Vitória de " + player1.getNome() + " ! ");
        } else {
            System.out.println("Vitória de " + player2.getNome() + " ! ");
        }
        System.out.println("\nJogar Novamente?");
        System.out.println("SIM - DIGITE 'S' ");
        System.out.println("NÃO - DIGITE 'N' ");
        return lerLetraValidaString(new String[]{"S", "N"});
    }

    public void agradecimentoFinal(){
        System.out.println("=================================");
        System.out.println(" Obrigado por jogar Duelo de Personagens!");
        System.out.println("=================================");
    }


    public int lerOpcaoValidaInt(int[] opcoesValidas) {
            boolean valido = false;
            String entrada = null;
            int escolha = 0;

            while (!valido) {
                entrada = teclado.nextLine().trim();
                try {
                    escolha = Integer.parseInt(entrada);
                    for (int op : opcoesValidas) {
                        if (escolha == op) {
                            valido = true;
                            break;
                        }
                    }
                    if (!valido) {
                        System.out.println("Opção inválida. Por favor, digite uma das opções válidas.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                }
            }
            return escolha;
        }

    public String lerLetraValidaString(String[] opcoesValidas) {
        boolean valido = false;
        String entrada = null;
        while (!valido) {
            entrada = teclado.nextLine().trim().toUpperCase();
            for (String op : opcoesValidas) {
                if (entrada.equals(op.toUpperCase())) {
                    valido = true;
                    break;
                }
            }
            if (!valido) {
                System.out.println("Opção inválida. Por favor, digite uma das letras válidas.");
            }
        }
        return entrada;
    }
}





