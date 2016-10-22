package banheiro.unisex.thread;

import java.util.concurrent.Semaphore;

public class BanheiroMain {

	public static void main(String[] args) {
	    int numeroDePermicoes = 3;
	    int numeroDeProcessos = 7;
	    Banheiro wc = new Banheiro(numeroDePermicoes);
	    Semaphore semaforo = new Semaphore(numeroDePermicoes);
	    Homem[] homens = new Homem[3];
	    //Mulher[] mulheres = new Mulher[4];
	    for(int i = 0; i < 3; i++){
	    	homens[i] = new Homem(i, wc, semaforo,((int) Math.random()));
	    	homens[i].start();
	    }
	    /*for(int i = 0; i < 4; i++){
	    	mulheres[i] = new Mulher(i, wc, semaforo, ((int) Math.random()));
	    }
	    for(int i = 0; i < 7; i++){
	    	
	    }*/
	}
}
