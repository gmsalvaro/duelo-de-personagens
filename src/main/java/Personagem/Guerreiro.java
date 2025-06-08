package Personagem;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 15, 10, 1);
    }

    public void usarPoderEspecial(Personagem alvo) {
        System.out.println(this.nome + " ativa Carga Brutal! Seu dano de ataque é aumentado para 30.");
         // Define o ataque para 30
         setForcaDeAtaque(30); //conferir se apenas o set para o aumento deve funcionar no futuro
        System.out.println("Novo dano de ataque de " + this.nome + ": " + this.alcanceDeAtaque);
    }
}
