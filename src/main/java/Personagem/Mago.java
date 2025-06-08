package Personagem;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 10, 7, 3);
    }
    protected void ativarPoderEspecial(Personagem alvo) {
        int aux = this.pontosDeVida;
        this.pontosDeVida = alvo.getPontosDeVida();
        alvo.setPontosDeVida(aux);
        System.out.println(this.nome + " agora tem " + this.pontosDeVida + " PV.");
        System.out.println(alvo.getNome() + " agora tem " + alvo.getPontosDeVida() + " PV.");
    }
}
