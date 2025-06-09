package Personagem;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 10, 7, 3);
    }
    public void usarPoderEspecial(Personagem alvo) {
        System.out.println(getNome() + " ativa Troca de Vida!");
        int aux = getPontosDeVida();
        setPontosDeVida(alvo.getPontosDeVida());
        alvo.setPontosDeVida(aux);
        System.out.println(getNome() + " agora tem " + getPontosDeVida() + " PV.");
        System.out.println(alvo.getNome() + " agora tem " + alvo.getPontosDeVida() + " PV.");
    }
}
