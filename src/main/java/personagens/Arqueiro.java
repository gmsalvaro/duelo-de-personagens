package personagens;

public class Arqueiro extends Personagem {

    //Contrutor - Passar informações da classe escolhida para o personagem ( geral );
    public Arqueiro(String nome) {
        super(nome, 8, 5, 5);
        /* forcaDeAtaque = 8;
         forcaDeDefesa = 5;
         alcanceDeAtaque = 5; */
         }

    protected void usarPoderEspecial(){
        //"Flecha Precisa": O arqueiro incrementa permanentemente um no seu alcance.
        System.out.println(this.nome + " ativa Flecha Precisa! Seu alcance de ataque aumenta permanentemente.");
        this.alcanceDeAtaque += 1; // Incrementa o alcance permanentemente
        System.out.println("Novo alcance de ataque do " + this.nome + ": " + this.alcanceDeAtaque);
    }
}
