package personagens;

public class Guerreiro extends Personagem {

    //Contrutor - Passar informações da classe escolhida para o personagem ( geral );
    public Guerreiro(String nome) {
        super(nome, 15, 10, 1);
        /* forcaDeAtaque = 15;
         forcaDeDefesa = 10;
         alcanceDeAtaque = 1; */

    }

    protected void usarPoderEspecial(Personagem alvo) {
        System.out.println(this.nome + " ativa Carga Brutal! Seu alcance de ataque é aumentado para 30.");
        this.alcanceDeAtaque = 30; // Define o alcance para 30
        System.out.println("Novo alcance de ataque do " + this.nome + ": " + this.alcanceDeAtaque);
    }
}
