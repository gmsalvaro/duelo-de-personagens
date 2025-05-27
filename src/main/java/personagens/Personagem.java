package personagens;

public class Personagem {
    protected String nome;
    protected int pontosDeVida = 100; //PVD
    protected int forcaDeAtaque;
    protected int forcaDeDefesa;
    protected int alcanceDeAtaque;
    protected int linha;
    protected int coluna;

    //Contrutor
    public Personagem(String nome, int forcaDeAtaque, int forcaDeDefesa, int alcanceDeAtaque){
        this.nome = nome;
        this.forcaDeAtaque = forcaDeAtaque;
        this.forcaDeDefesa = forcaDeDefesa;
        this.alcanceDeAtaque = alcanceDeAtaque;
    }


}