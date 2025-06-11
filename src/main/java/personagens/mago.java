package personagens;

public class mago extends personagem {
    public mago(String nome) {
        super(nome, 10, 7, 3);
    }

    public void usarPoderEspecial(personagem alvo) {
        System.out.println(getNome() + " ativa Troca de Vida!");
        int auxVida = getPontosDeVida();
        setPontosDeVida(alvo.getPontosDeVida());
        alvo.setPontosDeVida(auxVida);
        System.out.println(getNome() + " agora tem " + getPontosDeVida() + " PV.");
        System.out.println(alvo.getNome() + " agora tem " + alvo.getPontosDeVida() + " PV.");
    }
}
