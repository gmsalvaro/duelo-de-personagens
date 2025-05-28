package personagens;

public class Personagem { // Classe Mãe
    protected String type;
    protected String nome;
    protected int pontosDeVida; //PVD
    protected int forcaDeAtaque;
    protected int forcaDeDefesa;
    protected int baseDefesa; // Base para calculo;
    protected int alcanceDeAtaque;
    //Posição
    protected int linha;
    protected int coluna;

    //Contrutor
    public Personagem(String nome, int forcaDeAtaque, int forcaDeDefesa, int alcanceDeAtaque) {
        this.nome = nome;
        this.forcaDeAtaque = forcaDeAtaque;
        baseDefesa = this.forcaDeDefesa = forcaDeDefesa;
        this.alcanceDeAtaque = alcanceDeAtaque;
        this.pontosDeVida = 100;
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

    public String getType() {
        return type;
    }

    //Setters
    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

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
        //Não levei em consideração a defesa ainda !!!!
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
        return this.forcaDeAtaque - alvo.getForcaDeDefesa();
    }

    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " ataca " + alvo.getNome() + "!");
        int danoCausado = calcularDano(alvo);
        alvo.receberDano(danoCausado);
        System.out.println(alvo.getNome() + " sofreu " + danoCausado + " de dano. PV restantes: " + alvo.getPontosDeVida());

        // Regra: Após o ataque, qualquer efeito de defesa temporária no alvo é removido, ou seja, defesa volta ao inicial.
        alvo.setForcaDeDefesa(alvo.baseDefesa);
    }

    public void usarPoderEspecial(Personagem alvo) {
    }

    public boolean estaVivo() {
        if (this.pontosDeVida > 0)
            return true;
        return false;
    }
}