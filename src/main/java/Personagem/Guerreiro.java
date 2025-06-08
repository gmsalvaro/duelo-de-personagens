package Personagem;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 15, 10, 1);
    }
    public void usarPoderEspecial(Personagem alvo) { // concertar
        System.out.println(this.nome + " ativa Carga Brutal! Seu alcance de ataque é aumentado para 30.");
         // Define o ataque para 30
        System.out.println("Novo alcance de ataque do " + this.nome + ": " + this.alcanceDeAtaque);
    }
}
