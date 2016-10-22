package banheiro.unisex.thread;

import java.util.concurrent.Semaphore;

public class Mulher extends Pessoa {
		private int mulherId;
		
		public Mulher(int id, Banheiro wc, Semaphore semaforo,int tempo){
			super(wc, semaforo,tempo);
			this.setMulherId(id);
		}

		public int getMulherId() {
			return mulherId;
		}

		public void setMulherId(int mulherId) {
			this.mulherId = mulherId;
		}
		
}
