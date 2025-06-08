package Personagem;
import game.Tabuleiro;

public class Personagem { // Classe Mãe
    protected String nome;
    protected int pontosDeVida; //PVD
    protected int forcaDeAtaque;
    protected int forcaDeDefesa;
    protected int baseDefesa;
    protected int alcanceDeAtaque;
    protected int linha;
    protected int coluna;

    //Contrutor
     Personagem(String nome, int forcaDeAtaque, int forcaDeDefesa, int alcanceDeAtaque) {
        this.nome = nome;
        this.forcaDeAtaque = forcaDeAtaque;
        baseDefesa = this.forcaDeDefesa = forcaDeDefesa;
        this.alcanceDeAtaque = alcanceDeAtaque;
        this.pontosDeVida = 100;
        this.linha = -1;
        this.coluna = -1;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public int getForcaDeAtaque() {
        return forcaDeAtaque;
    }

    public int getForcaDeDefesa() {
        return forcaDeDefesa;
    }

    public int getAlcanceDeAtaque() {
        return alcanceDeAtaque;
    }

    public int getLinha() {
        return linha;
    }

    public int getCol() {
        return coluna;
    }


    //Setters
    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public void setForcaDeAtaque(int forcaDeAtaque){ this.forcaDeAtaque = forcaDeAtaque; }

    public void setForcaDeDefesa(int forcaDeDefesa) {
        this.forcaDeDefesa = forcaDeDefesa;
    }

    public void setAlcanceDeAtaque(int alcanceDeAtaque) {
        this.alcanceDeAtaque = alcanceDeAtaque;
    }

    public void setPosition(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }


    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0)
            this.pontosDeVida = 0;
    }

    public void restaurarDefesa() {
        this.forcaDeDefesa = this.baseDefesa;
        System.out.println(this.nome + " restaurou sua defesa para " + this.forcaDeDefesa + ".");
    }

    public int calcularDano(Personagem alvo) {
        // O dano é força de ataque do atacante - força de defesa do alvo
        return Math.max(0, this.forcaDeAtaque - alvo.getForcaDeDefesa());
    }

    public void atacar(Personagem alvo) {
        if(calcularDistancia(alvo) > getAlcanceDeAtaque()) {
            System.out.println("Erro: Alcance invalido/n");
            return;
        }
        int danoCausado = calcularDano(alvo);
        if( danoCausado <= 0){
            System.out.println("o Alvo não sofreu dano/n");
            return;
        }
        System.out.println(getNome() + " ataca " + alvo.getNome() + "!");
        alvo.receberDano(danoCausado);
        System.out.println(alvo.getNome() + " sofreu " + danoCausado + " de dano. PV restantes: " + alvo.getPontosDeVida());
        // Regra: Após o ataque, qualquer efeito de defesa temporária no alvo é removido, ou seja, defesa volta ao inicial.
        alvo.setForcaDeDefesa(alvo.baseDefesa);
    }

    public int calcularDistancia( Personagem p2){
        int distLinha = Math.abs(getLinha() - p2.getLinha());
        int distColuna = Math.abs(getCol() - p2.getCol());
        return distLinha + distColuna;
    }

    public void usarPoderEspecial(Personagem alvo) {}

    public boolean estaVivo() {
        return getPontosDeVida() > 0;
    }
}