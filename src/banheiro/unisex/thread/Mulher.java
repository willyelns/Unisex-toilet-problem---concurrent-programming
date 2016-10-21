package banheiro.unisex.thread;

public class Mulher extends Pessoa {
		private int mulherId;
		
		public Mulher(int id, Banheiro wc, int tempo){
			super(wc, tempo);
			this.setMulherId(id);
		}

		public int getMulherId() {
			return mulherId;
		}

		public void setMulherId(int mulherId) {
			this.mulherId = mulherId;
		}
		
}
