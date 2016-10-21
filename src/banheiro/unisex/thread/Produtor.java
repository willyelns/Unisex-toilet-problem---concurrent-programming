package banheiro.unisex.thread;

public class Produtor extends Thread {
	private int produtorId;
	private Buffer pilha;
	private int totalProdutor;
	
	public Produtor(int id, Buffer p, int total){
		produtorId = id;
		pilha = p;
		this.totalProdutor = total;
	}
	
	public void run(){
		for(int i = 0; i < totalProdutor; i++){
			pilha.set(produtorId, i);
		}
		System.out.println("P #" + this.produtorId + " concluído");
	}
}

