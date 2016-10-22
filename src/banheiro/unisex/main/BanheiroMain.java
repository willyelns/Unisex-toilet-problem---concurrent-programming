package banheiro.unisex.main;

import java.util.Random;
import java.util.concurrent.Semaphore;

import banheiro.unisex.model.Homem;
import banheiro.unisex.model.Mulher;
import banheiro.unisex.recurso.Banheiro;
import banheiro.unisex.thread.Pessoa;

public class BanheiroMain {

	public static void main(String[] args) {
		Random r = new Random();
	    int numeroDePermicoes = 3;
	    int numeroDePessoas = 1 + r.nextInt(10);
	    Banheiro wc = new Banheiro(numeroDePermicoes);
	    Semaphore semaforo = new Semaphore(numeroDePermicoes);
	    Pessoa[] pessoas = new Pessoa[numeroDePessoas];
	    
	    for(int i = 0; i < numeroDePessoas; i++){
	    	int num = 1 + r.nextInt(100);
	    	if(num % 2 == 0){
	    		pessoas[i] = new Homem(i, wc, semaforo, ((int) Math.random()));
	    	}else{
	    		pessoas[i] = new Mulher(i, wc, semaforo, ((int) Math.random()));
	    	}
	    }
	    for(int i = 0; i < numeroDePessoas; i++){
	    	pessoas[i].start();
	    }
	}
}
