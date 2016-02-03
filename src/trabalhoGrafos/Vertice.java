package grafo;

import java.util.ArrayList;
import java.util.List;

	/**
	 *
	 * @author tayanemoura e carlossarcinelli
	 */
	class Vertice {

	    int indice;
	    private int cor;
	    List<Vertice> vizinhos;
	    private int PE;
	    private int PS;
	    private Vertice pai;
	    private int back;

	    Vertice(int indice) {
	        this.indice = indice;
	        this.vizinhos = new ArrayList<>();
	    }

	    void setPai(Vertice v){
	        this.pai = v;
	    }
	    
	    void setPE (int n){
	        this.PE = n;
	    }
	    
	    void setPS(int n){
	        this.PS = n;
	    }
	    
	    Vertice getPai(){
	        return this.pai;
	    }
	    
	    int getPE (){
	        return this.PE;
	    }
	    
	    int getPS(){
	        return this.PS;
	    }

		public void setCor(int cor) {
			this.cor = cor;
		}

		public int getCor() {
			return this.cor;
		}

		public void setBack(int back) {
			this.back = back;
		}

		public int getBack() {
			return this.back;
		}
	    
		public String toString(){
			String retorno = "";
			retorno += "indice: " + String.valueOf(this.indice) + " cor: " + this.cor + " PE: " + this.PE + " PS: " + this.PS + 
					" back: " + this.back;
			
			if (this.pai != null){
				retorno += " pai: " + this.pai.getIndice();
			}
			
			return retorno;
		}

		private int getIndice() {
			return this.indice;
		}
		
		
	}
