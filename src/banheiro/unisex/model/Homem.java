package banheiro.unisex.model;

import java.util.concurrent.Semaphore;

import banheiro.unisex.recurso.Banheiro;
import banheiro.unisex.thread.Pessoa;

public class Homem extends Pessoa {
	private int manId;
	
	public Homem(int id, Banheiro wc,Semaphore semaforo, int tempo){
		super(wc, semaforo,tempo);
		this.setManId(id);
	}

	public int getManId() {
		return manId;
	}

	public void setManId(int manId) {
		this.manId = manId;
	}
	
}
