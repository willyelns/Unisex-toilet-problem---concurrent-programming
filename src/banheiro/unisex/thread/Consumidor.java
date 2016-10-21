package banheiro.unisex.thread;

public class Consumidor extends Thread {
	private int consumidorId;
	private Buffer pilha;
	private int totalConsumir;
	
	public Consumidor(int id, Buffer p, int total){
		consumidorId = id;
		pilha = p;
		this.totalConsumir = total;
	}
	
	public void run(){
		for(int i = 0; i < totalConsumir; i++){
			pilha.get(consumidorId);
		}
		System.out.println("Consumidor #" + this.consumidorId + " concluído");
	}
}
