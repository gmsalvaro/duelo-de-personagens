package Personagem;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 15, 10, 1);
    }

    public void usarPoderEspecial(Personagem alvo) {
        System.out.println(getNome() + " ativa Carga Brutal! Seu dano de ataque é aumentado para 30.");
         setForcaDeAtaque(30);
        System.out.println("Novo dano de ataque de " + getNome() + ": " + getForcaDeAtaque());
    }
}
