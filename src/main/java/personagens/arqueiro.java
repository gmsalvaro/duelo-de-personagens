package personagens;

public class arqueiro extends personagem {
    public arqueiro(String nome) { super(nome, 8, 5, 5); }

    public void usarPoderEspecial(personagem alvo){
        System.out.println(getNome()+ " ativa Flecha Precisa! Seu alcance de ataque aumenta permanentemente em +1. ");
        this.setAlcanceDeAtaque(getAlcanceDeAtaque() + 1 );
        System.out.println("Novo alcance de ataque de " + getNome() + ": " + getAlcanceDeAtaque());
    }
}
