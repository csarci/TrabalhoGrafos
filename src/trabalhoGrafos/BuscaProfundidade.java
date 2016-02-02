import java.util.ArrayList;

public class BuscaProfundidade {
	
	Grafo grafo;
	int relogio;
	
	BuscaProfundidade(Grafo g){
		this.relogio = 0;
		this.grafo = g;
	}

	void resetaValores(){
		for (int i = 0; i < grafo.vertices.size(); i++) {
			grafo.vertices.get(i).setPE(0);
			grafo.vertices.get(i).setPS(0);
			grafo.vertices.get(i).setPai(null);
			grafo.vertices.get(i).setCor(0);
			grafo.vertices.get(i).setBack(0);
	    }
		for (int j = 0; j < grafo.arestas.size(); j++){
			grafo.arestas.get(j).desvisita();
		}
	}
	
	void realizaBusca(Vertice raiz) {
		relogio++;
        raiz.setPE(relogio);
        for (int i = 0; i < raiz.vizinhos.size(); i++) {
            if (raiz.vizinhos.get(i).getPE() == 0){
            	grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
            	grafo.compConexa.add(new Aresta(raiz, raiz.vizinhos.get(i)));
                raiz.vizinhos.get(i).setPai(raiz);
                realizaBusca(raiz.vizinhos.get(i));
            }
            else{
                if ((raiz.vizinhos.get(i).getPS() == 0)
                		&& (raiz.getPai() != raiz.vizinhos.get(i))){
                			grafo.setCiclico();
                			grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                        	grafo.compConexa.add(new Aresta(raiz, raiz.vizinhos.get(i)));
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
			  grafo.compConexas.add(grafo.compConexa);
			  grafo.compConexa = new ArrayList<Aresta>();
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
	
	private void verificaBipartidariedade(Vertice raiz) {
		relogio++;
        raiz.setPE(relogio);
        for (int i = 0; i < raiz.vizinhos.size(); i++) {
            if (raiz.vizinhos.get(i).getPE() == 0){
            	grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                raiz.vizinhos.get(i).setPai(raiz);
                raiz.vizinhos.get(i).setCor(1 - raiz.getCor());
                verificaBipartidariedade(raiz.vizinhos.get(i));
            }
            else{
                if ((raiz.vizinhos.get(i).getPS() == 0)
                		&& (raiz.getPai() != raiz.vizinhos.get(i))){
                			if (raiz.vizinhos.get(i).getCor() != raiz.getCor()){
                				grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                			}
                			else{
                				i = raiz.vizinhos.size();
                				grafo.setBipartido(false);
                				System.out.println("O grafo não é bipartido, ciclo ímpar");
                			}
                		}
            }
        }
        relogio++;
        raiz.setPS(relogio);
    }
	
	private void calculaBacks(Vertice raiz) {
		relogio++;
        raiz.setPE(relogio);
        raiz.setBack(raiz.getPE());
        for (int i = 0; i < raiz.vizinhos.size(); i++) {
            if (raiz.vizinhos.get(i).getPE() == 0){
            	grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                raiz.vizinhos.get(i).setPai(raiz);
                calculaBacks(raiz.vizinhos.get(i));
                if (raiz.vizinhos.get(i).getBack() < raiz.getBack()){
                	raiz.setBack(raiz.vizinhos.get(i).getBack());
                }
            }
            else{
                if ((raiz.vizinhos.get(i).getPS() == 0)
                		&& (raiz.getPai() != raiz.vizinhos.get(i))){
                				grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                				if (raiz.vizinhos.get(i).getPE() < raiz.getBack()){
                					raiz.setBack(raiz.vizinhos.get(i).getPE());
                				}
                			}
                }
        }
        relogio++;
        raiz.setPS(relogio);
    }
	
	
	private void encontraArticulacoes() {
		for (int i=0; i < grafo.vertices.size(); i++){
			if (grafo.vertices.get(i).getPai() == null){
				if  (contaFilhosRaiz(grafo.vertices.get(i)) > 1){
					grafo.articulacoes.add(grafo.vertices.get(i));
				}
			}
			else{
				if (contaFilhos(grafo.vertices.get(i)) > 0){
					grafo.articulacoes.add(grafo.vertices.get(i));
				}
			}
		}
	}

	private int contaFilhos(Vertice vertice) {
		int numFilhos = 0;
		for(int i = 0; i < grafo.vertices.size(); i++) {
			if (grafo.vertices.get(i).getPai() == vertice){
				if (grafo.vertices.get(i).getBack() >= vertice.getPE())
					numFilhos++;
			}
		}
		return numFilhos;
	}

	private int contaFilhosRaiz(Vertice vertice){
		int numFilhos = 0;
		for(int i = 0; i < grafo.vertices.size(); i++) {
			if (grafo.vertices.get(i).getPai() == vertice){
				numFilhos++;
			}
		}
		return numFilhos;
	}

	private void encontraBlocos(Vertice raiz) {
		relogio++;
        raiz.setPE(relogio);
        raiz.setBack(raiz.getPE());
        for (int i = 0; i < raiz.vizinhos.size(); i++) {
            if (raiz.vizinhos.get(i).getPE() == 0){
            	grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
            	grafo.bloco.add(new Aresta(raiz, raiz.vizinhos.get(i)));
                raiz.vizinhos.get(i).setPai(raiz);
                encontraBlocos((raiz.vizinhos.get(i)));
                grafo.blocos.add(grafo.getBloco());
                grafo.zeraBloco();
                if (raiz.vizinhos.get(i).getBack() >= raiz.getPE()){
                	raiz.setBack(raiz.vizinhos.get(i).getBack());
                }
            }
            else{
                if ((raiz.vizinhos.get(i).getPS() == 0)
                		&& (raiz.getPai() != raiz.vizinhos.get(i))){
                				grafo.visitaAresta(raiz, raiz.vizinhos.get(i));
                				grafo.bloco.add(new Aresta(raiz, raiz.vizinhos.get(i)));
                				if (raiz.vizinhos.get(i).getPE() < raiz.getBack()){
                					raiz.setBack(raiz.vizinhos.get(i).getPE());
                				}
                			}
                }
        }
        relogio++;
        raiz.setPS(relogio);
    }
	
	private void encontraPontes(){
		for (int i=0; i < grafo.blocos.size(); i++){
			if (grafo.blocos.get(i).size() == 1){
				grafo.pontes.add(grafo.blocos.get(i).get(0));
			}
		}
	}
	
	private void verificaEuleriano(){
		boolean euleriano = true;
		for(int i=0; i < grafo.vertices.size(); i++){
			if (grafo.vertices.get(i).vizinhos.size() %2 != 0){
				euleriano = false;
			}
		}
		if (euleriano == true && grafo.conexo == true){
			grafo.setEuleriano(euleriano);
		}
	}
	
	private void algoritmoFleury(){
		Grafo novo = grafo;
		Vertice v1 = novo.vertices.get(0);
		
		while (novo.arestas.size() > 0){
			if (v1.vizinhos.size() == 1){
				grafo.caminhoEuleriano.add(new Aresta(v1, v1.vizinhos.get(0)));
				v1 = v1.vizinhos.get(0);
				novo.arestas.remove(0);
			}
			else{
				for (int i = 0; i < novo.arestas.size(); i++) {
					if (novo.arestas.get(i).v1 == v1){
						if (!grafo.pontes.contains(novo.arestas.get(i))){
							grafo.caminhoEuleriano.add(novo.arestas.get(i));
							v1 = novo.arestas.get(i).v2;
							i = novo.arestas.size();
							novo.arestas.remove(i);
						}
					}
				}
				
			}
		}
	}
	
}
