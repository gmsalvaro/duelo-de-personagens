import personagens.Personagem;
import personagens.Arqueiro;

public class Main {
    public static void main(String[] args) {

        //Teste de
        Personagem meuPersonagem = new Arqueiro("Robin Hood"); // Exemplo
        System.out.println("Nome: " + meuPersonagem.getNome());
        //System.out.println("Tipo: " + meuPersonagem.getTipo());
        System.out.println("PV: " + meuPersonagem.getPontosDeVida());
        System.out.println("Força de Ataque: " + meuPersonagem.getForcaDeAtaque());
        System.out.println("Defesa: " + meuPersonagem.getForcaDeDefesa());
        System.out.println("Alcance: " + meuPersonagem.getAlcanceDeAtaque());
        System.out.println(meuPersonagem.estaVivo());

        }
}