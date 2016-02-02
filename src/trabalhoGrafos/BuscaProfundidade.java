package grafo;

public class BuscaProfundidade {
	
	Grafo grafo;
	int relogio;
	
	BuscaProfundidade(Grafo g){
		this.relogio = 0;
		this.grafo = g;
	}

	void inicializaBusca(){
		for (int i = 0; i < grafo.vertices.size(); i++) {
			grafo .vertices.get(i).setPE(0);
			grafo .vertices.get(i).setPS(0);
			grafo .vertices.get(i).setPai(null);
	    }
		for (int j = 0; j < grafo.arestas.size(); j++){
			grafo .arestas.get(j).desvisita();
		}
	}
	
	private void realizaBusca(Vertice raiz) {
		relogio++;
        raiz.setPE(relogio);
        for (int i = 0; i < raiz.vizinhos.size(); i++) {
            if (raiz.vizinhos.get(i).getPE() == 0){
            	grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                raiz.vizinhos.get(i).setPai(raiz);
                realizaBusca(raiz.vizinhos.get(i));
            }
            else{
                if ((raiz.vizinhos.get(i).getPS() == 0)
                		&& (raiz.getPai() != raiz.vizinhos.get(i))){
                			grafo.setCiclico();
                			grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                		}
            }
        }
        relogio++;
        raiz.setPS(relogio);
    }

	public void verificaConexo() {
		  int compConexas = 0;
		  
		  for(int i=0; i < grafo.vertices.size(); i++){
			  if (grafo.vertices.get(i).getPE() == 0){
				  compConexas++;
				  realizaBusca(grafo.vertices.get(i));
			  }
		  }
		  
		  if(compConexas == 1){
			  grafo.setConexo();
			  System.out.println("O grafo é conexo");
		  }
		  else{
			  System.out.println("O grafo não é conexo e possui " + compConexas + " componentes conexas");
		  }
	}

	public void verificaArvore() {
		if ((grafo.conexo) && (!grafo.temCiclos)){
			grafo.setArvore();
		}
	}

}
	
	

