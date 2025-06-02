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


    public void gameAcao(Personagem player1, PlayerIA ia){
        Prints prints = new Prints();

        //

        if(player1.getPontosDeVida() > 30);
        {

        }
     }


    public boolean estaVivo() {
        if (this.pontosDeVida > 0)
            return true;
        return false;
    }




}
