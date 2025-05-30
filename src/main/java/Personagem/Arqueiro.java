package Personagem;

public class Arqueiro extends Personagem {

    //Contrutor - Passar informações da classe escolhida para o personagem ( geral );
    public Arqueiro(String nome) {
        super(nome, 8, 5, 5);
        /* forcaDeAtaque = 8;
         forcaDeDefesa = 5;
         alcanceDeAtaque = 5; */
         }

    public void usarPoderEspecial(Personagem alvo){
        //"Flecha Precisa": O arqueiro incrementa permanentemente um no seu alcance.
        System.out.println(this.nome + " ativa Flecha Precisa! Seu alcance de ataque aumenta permanentemente em +1. ");
        this.setAlcanceDeAtaque(this.getAlcanceDeAtaque() + 1 );  //Incrementa o alcance permanentemente
        System.out.println("Novo alcance de ataque de " + this.getNome() + ": " + this.getAlcanceDeAtaque());
    }
}
