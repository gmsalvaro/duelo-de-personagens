package Personagem;

public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        super(nome, 8, 5, 5);
         }
    public void usarPoderEspecial(Personagem alvo){
        //"Flecha Precisa": O arqueiro incrementa permanentemente um no seu alcance.
        System.out.println(getNome()+ " ativa Flecha Precisa! Seu alcance de ataque aumenta permanentemente em +1. ");
        this.setAlcanceDeAtaque(getAlcanceDeAtaque() + 1 );  //Incrementa o alcance permanentemente
        System.out.println("Novo alcance de ataque de " + getNome() + ": " + getAlcanceDeAtaque());
    }
}
