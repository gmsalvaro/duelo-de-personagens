package game;

import Personagem.*;
import java.util.Scanner



public class PlayerIA {


    //Mesmo molde de personagem
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

    //Construtor
     PlayerIA(String nome, int forcaDeAtaque, int forcaDeDefesa, int alcanceDeAtaque){

        this.nome =  nome;
        this.forcaDeAtaque = forcaDeAtaque;
        baseDefesa = this.forcaDeDefesa = forcaDeDefesa;
        this.alcanceDeAtaque = alcanceDeAtaque;
        this.pontosDeVida = 100;
        this.linha = -1;
        this.coluna = -1;

    }

    public int getPontosDeVida(){return this.pontosDeVida;}

    public int getForcaDeAtaque(){return this.forcaDeAtaque;}

    public int getForcaDeDefesa(){return this.forcaDeDefesa;}

    public int getAlcanceDeAtaque(){return this.alcanceDeAtaque;}

    public int getLinha(){return this.linha;}

    public int getColuna(){return this.coluna;}

    public String getNome(){return this.nome;}


    public void receberDano(int dano){

         this.pontosDeVida -= dano;
           if(this.pontosDeVida <= 0){
               this.pontosDeVida = 0;
           }
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
        alvo.setForcaDeDefesa(alvo.baseDefesa); //Erro no base defesa
    }

    public void usarPoderEspecial(Personagem alvo) {
         // Nao implementado
    }

    public void turnoIA(Personagem alvo) {

         if(alvo.getPontosDeVida() > 30)
         {
             System.out.println(this.nome + " ataca " + alvo.getNome() + "!");
             int danoCausado = calcularDano(alvo);
             alvo.receberDano(danoCausado);
             System.out.println(alvo.getNome() + " sofreu " + danoCausado + " de dano. PV restantes: " + alvo.getPontosDeVida());

         } else if (getPontosDeVida() < 30)
         {
           restaurarDefesa();
         }
         else
         {
             // Mover em direção ao personagem(Obs: Nao implementado!)
         }

    }


    public boolean estaVivo() {
        if (this.pontosDeVida > 0)
            return true;
        return false;
    }




}
