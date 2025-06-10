package Personagem;
import game.Tabuleiro;

public class Personagem { // Classe Mãe
    private String nome;
    private int pontosDeVida; //PVD
    private int forcaDeAtaque;
    private int forcaDeDefesa;
    private int baseDefesa;
    private int alcanceDeAtaque;
    private int linha;
    private int coluna;

     Personagem(String nome, int forcaDeAtaque, int forcaDeDefesa, int alcanceDeAtaque) {
        this.nome = nome;
        this.forcaDeAtaque = forcaDeAtaque;
        baseDefesa = forcaDeDefesa;
        this.forcaDeDefesa = forcaDeDefesa;
        this.alcanceDeAtaque = alcanceDeAtaque;
        this.pontosDeVida = 100;
        this.linha = -1;
        this.coluna = -1;
    }


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


    public void receberDano(int danoTotal) {
        if (forcaDeDefesa >= danoTotal) {
            forcaDeDefesa -= danoTotal;
        } else {
            int danoRestante = danoTotal - forcaDeDefesa;
            forcaDeDefesa = 0;
            pontosDeVida = Math.max(0, pontosDeVida - danoRestante);
        }
    }

    public void restaurarDefesa() {
        this.forcaDeDefesa = this.baseDefesa;
        System.out.println(this.nome + " restaurou sua defesa para " + this.forcaDeDefesa + ".");
    }

    public int calcularDano(Personagem alvo) {
        return Math.max(0, this.forcaDeAtaque - alvo.getForcaDeDefesa());
    }

    public void atacar(Personagem alvo) {
        if(calcularDistancia(alvo) > getAlcanceDeAtaque()) {
            System.out.println("Erro: Alcance invalido");
            return;
        }
        int danoCausado = calcularDano(alvo);
        int defesaUsada = Math.min(alvo.getForcaDeDefesa(), this.forcaDeAtaque - danoCausado);
        alvo.setForcaDeDefesa(Math.max(0, alvo.getForcaDeDefesa() - defesaUsada));

        if( danoCausado <= 0){
            System.out.println("o Alvo não sofreu dano");
        } else {
            alvo.receberDano(danoCausado);
            System.out.println(getNome() + " ataca " + alvo.getNome() + "!");
            System.out.println(alvo.getNome() + " sofreu " + danoCausado + " de dano. PV restantes: " + alvo.getPontosDeVida());
        }
        System.out.println("Defesa restante: " + alvo.getForcaDeDefesa());
    }

    public int calcularDistancia( Personagem p2){
        int distLinha = Math.abs(getLinha() - p2.getLinha());
        int distColuna = Math.abs(getCol() - p2.getCol());
        return Math.max(distLinha, distColuna);
    }

    public void usarPoderEspecial(Personagem alvo) {}

    public boolean estaVivo() {
         return getPontosDeVida() > 0;
    }
}