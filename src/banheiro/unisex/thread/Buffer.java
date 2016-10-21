package banheiro.unisex.thread;

public class Buffer {
	
	boolean disponivel;
	int conteudo;
	
	public synchronized void set(int id, int valor){
		while(disponivel == true){
			try{
				System.out.println("Produtor #" + id + "esperando...");
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		conteudo = valor;
		System.out.println("Produtor #" + id + " Colocou " + valor);
		disponivel = true;
		notifyAll();
	}
	
	public synchronized int get(int id){
		while(disponivel == true){
			try{
				System.out.println("Consumidor " + id + "esperando...");
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("Consumidor " + id + " consumiu o conteudo" + conteudo);
		disponivel = false;
		notifyAll();
		return conteudo;
	}
}
