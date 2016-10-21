package banheiro.unisex.thread;

import java.util.ArrayList;

public class Banheiro {
	boolean disponivel;
	int conteudo;
	ArrayList<Pessoa> vagas;
	int totalVagas;
	
	public Banheiro(int total){
		vagas = new ArrayList<Pessoa>();
		
	}
	
	public synchronized void entrar(Pessoa pessoa){
		if(vagas.size() < totalVagas){
			if(vagas.size() == 0){
				try{
					if(pessoa instanceof Homem){
						System.out.println("Homem #" + ((Homem) pessoa).getManId() + " está se preparando para entrar");
					}else{
						System.out.println("Mulher #" + ((Mulher) pessoa).getMulherId() + " está se preparando para entrar");
					}
					
				}catch(Exception e){
					e.printStackTrace();			}
				//Adiciona a pessoa ao banheiro, dando acesso a zona de risco	
			}else{
				if(pessoa instanceof Homem && vagas.get(0) instanceof Homem){
					//Adiciona a pessoa ao banheiro, mesma coisa
					//Ver uso do semáforo aqui
				}else if(pessoa instanceof Mulher && vagas.get(0) instanceof Mulher)
			}
		}else{
			System.out.println("Banheiro está cheio");
		}
		
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
	
	public synchronized void sair(Pessoa pessoa){
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
	}

	public void tentandoEntrar(Pessoa pessoa) {
		if(pessoa instanceof Homem){
			System.out.println("Homem #" + ((Homem) pessoa).getManId() + " está tentando entrar no banheiro");
		}else{
			System.out.println("Mulher #" + ((Mulher) pessoa).getMulherId() + " está tentando entrar no banheiro");
		}
	}
}
