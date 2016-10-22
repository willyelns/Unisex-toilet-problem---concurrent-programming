package banheiro.unisex.thread;

import java.util.concurrent.Semaphore;

 public abstract class Pessoa extends Thread {
	private Banheiro wc;
	private int tempoNoBanheiro;
	private Semaphore semaforo;
	
	
	public Pessoa(Banheiro wc, Semaphore semaforo,int tempo){
		this.wc = wc;
		this.semaforo = semaforo;
		this.tempoNoBanheiro = tempo;
	}
	
	public void run(){
		wc.tentandoEntrar(this); //Imprime uma mensagem, avisando que quer ir ao banheiro
		try{
			semaforo.acquire();
			wc.entrar(this);
			Thread.sleep(tempoNoBanheiro);
			wc.sair(this);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("DEU RUIM, PRO CABA(O) ENTRAR");
		}finally{
			semaforo.release();
		}
	}
}
