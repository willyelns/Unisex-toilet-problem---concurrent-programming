package banheiro.unisex.thread;

import java.util.concurrent.Semaphore;

public class ProcessadorThread extends Thread{
	
	private int threadId;
	private Semaphore semaphore;
	
	public ProcessadorThread(int id, Semaphore semaphore){
		this.setThreadId(id);
		this.setSemaphore(semaphore);
	}
	
	private void processar(){
		try{
			System.out.println("Thread #" + this.threadId + "processando");
			Thread.sleep((long) (Math.random() * 10000));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void entrarRegiaoNaoCritica(){
		System.out.println("Thread #" + this.threadId + " em região não crítica");
		processar();
	}
	
	private void entrarRegiaoCritica(){
		System.out.println("Thread #" + this.threadId + " entrando em região crítica");
		processar();
		System.out.println("Thread #" + this.threadId + " saindo da região crítica");
	}
	
	public void run() {
		entrarRegiaoNaoCritica();
		try {
			semaphore.acquire();
			entrarRegiaoCritica();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			semaphore.release();
		}
	}

	public int getThreadId() { 
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	public static void main(String[] args) {
	    int numeroDePermicoes = 2;
	    int numeroDeProcessos = 6;
	    Semaphore semaphore = new Semaphore(numeroDePermicoes);
	    ProcessadorThread[] processos = new ProcessadorThread[numeroDeProcessos];
	    for (int i = 0; i < numeroDeProcessos; i++) {
	        processos[i] = new ProcessadorThread(i, semaphore);
	        processos[i].start();
	    }
	}
	
}
