package personagens;

public class guerreiro extends personagem {
    public guerreiro(String nome) {
        super(nome, 15, 10, 1);
    }

    public void usarPoderEspecial(personagem alvo) {
        System.out.println(getNome() + " ativa Carga Brutal! Seu dano de ataque é aumentado para 30.");
         setForcaDeAtaque(30);
        System.out.println("Novo dano de ataque de " + getNome() + ": " + getForcaDeAtaque());
    }
}
