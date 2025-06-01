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

    public int escolherPersonagem(){
        int escolha = -1;
        boolean entradaValida = false;
        System.out.println("1. Arqueiro"); // Acho importante colocar uma breve descrição;
        System.out.println("2. Guerreiro");
        System.out.println("3. Mago");
        while (!entradaValida) { // Sai do loop quando é falso, logo entrada é true
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
        System.out.println(player1.getNome() + "                 " + player2.getNome());
        System.out.println(player1.getPontosDeVida() + "                 " + player2.getPontosDeVida());
        System.out.println(player1.getForcaDeDefesa() + "                 " + player2.getForcaDeDefesa());

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

    public void mensagemFinal(Personagem player1, Personagem player2){
        if(player1.estaVivo()){
            System.out.println("Parabens ao " + player1.getNome());
        } else {
            System.out.println("Parabens ao " + player1.getNome());
        }
    //fazer com que o jogo retorne novamente;
    }

}
