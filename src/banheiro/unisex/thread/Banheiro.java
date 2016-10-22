package banheiro.unisex.thread;

import java.util.ArrayList;

public class Banheiro {
	ArrayList<Pessoa> vagas;
	int totalVagas;
	
	public Banheiro(int total){
		vagas = new ArrayList<Pessoa>();
		totalVagas = total;
	}
	
	public synchronized void entrar(Pessoa pessoa){
		if(vagas.size() < totalVagas){
			try{
				if(pessoa instanceof Homem){
					System.out.println("Homem #" + ((Homem) pessoa).getManId() + " está se preparando para entrar");
				}else{
					System.out.println("Mulher #" + ((Mulher) pessoa).getMulherId() + " está se preparando para entrar");
				}
				//wait();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(vagas.isEmpty()){
				//Adiciona a pessoa ao banheiro, dando acesso a zona de risco	
				vagas.add(pessoa);
				System.out.println("Banheiro com #" + vagas.size() + " pessoa");
				notifyAll();
			}else{
				if(pessoa instanceof Homem && vagas.get(0) instanceof Homem){
					//Adiciona a pessoa ao banheiro, mesma coisa
					vagas.add(pessoa);
					System.out.println("Homem #" + ((Homem) pessoa).getManId() + " entrou no banheiro");
					System.out.println("Banheiro com #" + vagas.size() + " pessoa");
					notifyAll();
				}else if(pessoa instanceof Mulher && vagas.get(0) instanceof Mulher){
					vagas.add(pessoa);
					System.out.println("Mulher #" + ((Mulher) pessoa).getMulherId() + " entrou no banheiro");
					System.out.println("Banheiro com #" + vagas.size() + " pessoa");
					notifyAll();
				}else{
					System.out.println("Não se encaixa no padrão do banheiro");
				}
			}
		}else{
			System.out.println("Banheiro está cheio");
		}
	}
	
	public synchronized void sair(Pessoa pessoa){
		
		if(!vagas.isEmpty()){
			try{
				if(pessoa instanceof Homem){
					System.out.println("Homem #" + ((Homem) pessoa).getManId() + " está se preparando para sair");
				}else{
					System.out.println("Mulher #" + ((Mulher) pessoa).getMulherId() + " está se preparando para sair");
				}
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(pessoa instanceof Homem && vagas.get(0) instanceof Homem){
				//Remove a pessoa do banheiro
				vagas.remove(pessoa);
				System.out.println("Homem #" + ((Homem) pessoa).getManId() + " saiu do banheiro");
				System.out.println("Banheiro com #" + vagas.size() + " pessoa");
				notifyAll();
			}else if(pessoa instanceof Mulher && vagas.get(0) instanceof Mulher){
				vagas.remove(pessoa);
				System.out.println("Mulher #" + ((Mulher) pessoa).getMulherId() + " saiu do banheiro");
				System.out.println("Banheiro com #" + vagas.size() + " pessoa");
				notifyAll();
			}else{
				System.out.println("Não se encaixa no padrão do banheiro");
			}
		}else{
			System.out.println("Banheiro está vazio");
		}
	}

	public void tentandoEntrar(Pessoa pessoa) {
		if(pessoa instanceof Homem){
			System.out.println("Homem #" + ((Homem) pessoa).getManId() + " está tentando entrar no banheiro");
		}else{
			System.out.println("Mulher #" + ((Mulher) pessoa).getMulherId() + " está tentando entrar no banheiro");
		}
	}
}
