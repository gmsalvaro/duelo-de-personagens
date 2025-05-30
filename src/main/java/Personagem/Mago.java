package Personagem;

public class Mago extends Personagem {

    //Contrutor - Passar informações da classe escolhida para o personagem ( geral );
    public Mago(String nome) {
        super(nome, 10, 7, 3);
        /* forcaDeAtaque = 10;
         forcaDeDefesa = 7;
         alcanceDeAtaque = 3; */
    }

    protected void ativarPoderEspecial(Personagem alvo) {
        //“Trocar vida”: O mago troca o seu pontosDeVida com o do oponente.
        int aux = this.pontosDeVida;
        this.pontosDeVida = alvo.getPontosDeVida();
        alvo.setPontosDeVida(aux);
        System.out.println(this.nome + " agora tem " + this.pontosDeVida + " PV.");
        System.out.println(alvo.getNome() + " agora tem " + alvo.getPontosDeVida() + " PV.");
    }
}
