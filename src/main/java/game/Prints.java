package game;
import Personagem.Personagem;

import java.util.Scanner;

public class Prints {
    private Scanner teclado = new Scanner(System.in);

    //Função Inicial
    public void exibirMensagemInicial() {
        System.out.println("---------------------------------");
        System.out.println(" Bem-vindo ao Duelo de Personagens!");
        System.out.println("       Prepare-se para a batalha!");
        System.out.println("---------------------------------");
    }


    public int escolherModoDeJogo() {
        int escolha = -1;
        boolean entradaValida = false;
        System.out.println("\nEscolha o modo de jogo:");
        System.out.println("1. Jogador vs Jogador");
        System.out.println("2. Jogador vs IA");
        System.out.print("Qual sua escolha: ");
        while (!entradaValida) {
            escolha = teclado.nextInt();
            if (escolha == 1 || escolha == 2) {
                entradaValida = true;
            } else {
                System.out.println("Opção inválida. Por favor, digite 1 ou 2.");
            }
        }
        return escolha;
    }
    public void printDescricaoArqueiro() {
        System.out.println("Especialista em ataques de longa distância.");
        System.out.println("Poder Especial: FLECHA PRECISA");
        System.out.println("  - Aumenta permanentemente seu alcance em +1.");
        System.out.println("Atributos: Ataque 8 | Defesa 5 | Alcance 5");
    }
    public void printDescricaoGuerreiro() {
        System.out.println("Combatente corpo a corpo com alta resistência.");
        System.out.println("Poder Especial: CARGA BRUTAL");
        System.out.println("  - Dobra seu dano de ataque temporariamente.");
        System.out.println("Atributos: Ataque 15 | Defesa 10 | Alcance 1");
    }
    public void printDescricaoMago() {
        System.out.println("Mestre de magias que manipulam a vida.");
        System.out.println("Poder Especial: TROCA DE VIDA");
        System.out.println("  - Troca seus PV com os do inimigo.");
        System.out.println("Atributos: Ataque 10 | Defesa 7 | Alcance 3");
    }


    public int escolherPersonagem(){
        int escolha = -1;
        boolean entradaValida = false;
        System.out.println();
        System.out.println("1. Arqueiro");
        printDescricaoArqueiro();
        System.out.println();
        System.out.println("2. Guerreiro");
        printDescricaoGuerreiro();
        System.out.println();
        System.out.println("3. Mago");
        printDescricaoMago();
        while (!entradaValida) {
            escolha = teclado.nextInt();
            if (escolha == 1 || escolha == 2 || escolha == 3) {
                entradaValida = true;
            } else {
                System.out.println("Opção inválida. Por favor, digite 1, 2 ou 3.");
            }
        }
        return escolha;
    }

    public String escolherNome(){
        System.out.println("\nEscolha qual será o nome do seu personagem: ");
        return teclado.nextLine();
    }

    public void imprimirStatus( Personagem player1, Personagem player2){ //Melhorar depois
        System.out.println("---------------------------------");
        System.out.printf("%-15s %-15s\n", player1.getNome(), player2.getNome());
        System.out.printf("PV: %-13d PV: %-13d\n", player1.getPontosDeVida(), player2.getPontosDeVida());
        System.out.printf("DEF: %-12d DEF: %-12d\n", player1.getForcaDeDefesa(), player2.getForcaDeDefesa());
        System.out.println("---------------------------------");
    }

    public int escolherAcao(){
        int escolha = -1;
        boolean entradaValida = false;
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Mover");
        System.out.println("4. Ataque especial");
        while (!entradaValida) {
            escolha = teclado.nextInt();
            if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4) {
            entradaValida = true;
        } else {
            System.out.println("Opção inválida. Por favor, digite 1, 2 ou 3.");
        }
        }
        return escolha;
    }


    public int escolherPosicao(){
        int escolha = -1;
        boolean entradaValida = false;
        System.out.println("1. Cima");
        System.out.println("2. Baixo");
        System.out.println("3. Esquerda");
        System.out.println("4. Direita");
        while (!entradaValida) {
            escolha = teclado.nextInt();
            if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4) {
                entradaValida = true;
            } else {
                System.out.println("Opção inválida. Por favor, digite 1, 2, 3 e 4.");
            }
        }
        return escolha;
    }


    public int mensagemFinal(Personagem player1, Personagem player2) {
        int escolha = -1;
        boolean entradaValida = false;
        if (player1.estaVivo()) {
            System.out.println("Parabens ao " + player1.getNome());
        } else {
            System.out.println("Parabens ao " + player2.getNome());
        }
        System.out.println("Jogar Novamente?");
        System.out.println("1 - SIM");
        System.out.println("2 - NÃO");
        while (!entradaValida) {
            escolha = teclado.nextInt();
            if (escolha == 1 || escolha == 2) {
                entradaValida = true;
            } else {
                System.out.println("Opção inválida. Por favor, digite 1 ou 2.");
            }
        }
        return escolha;
    }
    }
