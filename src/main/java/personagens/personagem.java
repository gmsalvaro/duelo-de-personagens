package personagens;

public class personagem {
    private String nome;
    private int pontosDeVida;
    private int forcaDeAtaque;
    private int forcaDeDefesa;
    private int baseDefesa;
    private int alcanceDeAtaque;
    private int linha;
    private int coluna;
    private int limitesPoderMax = 1;
    private int defesaMax = 4;

      public personagem(String nome, int forcaDeAtaque, int forcaDeDefesa, int alcanceDeAtaque) {
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

    public int getLimitesPoderMax() {
        return limitesPoderMax;
    }

    public int getDefesaMax() {
        return defesaMax;
    }


    public void setPontosDeVida(int pontosDeVida) {
         this.pontosDeVida = pontosDeVida;
    }

    public void setForcaDeAtaque(int forcaDeAtaque){this.forcaDeAtaque = forcaDeAtaque; }

    public void setForcaDeDefesa(int forcaDeDefesa) {
        this.forcaDeDefesa = forcaDeDefesa;
    }

    public void setAlcanceDeAtaque(int alcanceDeAtaque) {
        this.alcanceDeAtaque = alcanceDeAtaque;
    }

    public void setLimitesPoderMax(int limitesPoderMax) {
        this.limitesPoderMax = limitesPoderMax;
    }

    public void setDefesaMax(int defesaMax) {
        this.defesaMax = defesaMax;
    }

    public void setPosicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    protected void receberDano(int danoRecebido) {
            int novoPV = getPontosDeVida() - danoRecebido;
            setPontosDeVida(Math.max(0, novoPV));
    }

    public void restaurarDefesa() {
        this.forcaDeDefesa = this.baseDefesa;
        System.out.println(this.nome + " restaurou sua defesa para " + this.forcaDeDefesa + ".");
    }

    protected int calcularDano(personagem alvo) {
        return Math.max(0, this.forcaDeAtaque - alvo.getForcaDeDefesa());
    }

    public void atacarPlayer(personagem alvo) {
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

    public int calcularDistancia( personagem player2){
        int distLinha = Math.abs(getLinha() - player2.getLinha());
        int distColuna = Math.abs(getCol() - player2.getCol());
        return Math.max(distLinha, distColuna);
    }

    public void usarPoderEspecial(personagem alvo) {}

    public boolean estaVivo() {
         return getPontosDeVida() > 0;
    }
}