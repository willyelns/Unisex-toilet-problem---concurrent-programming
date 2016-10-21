package banheiro.unisex.thread;

public class Homem extends Pessoa {
	private int manId;
	
	public Homem(int id, Banheiro wc, int tempo){
		super(wc, tempo);
		this.setManId(id);
	}

	public int getManId() {
		return manId;
	}

	public void setManId(int manId) {
		this.manId = manId;
	}
	
}
