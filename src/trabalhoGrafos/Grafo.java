package grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grafo{

	List<Vertice> vertices;
    List<Aresta> arestas;
    boolean temCiclos;
	boolean conexo;
	boolean arvore;

    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
        this.temCiclos = false;
        this.conexo = false;
        this.arvore = false;
    }
    
    public void geraGrafo(int numVertices, float prob) {
    	
    	if (numVertices < 0) 
        	throw new IllegalArgumentException("Número de vértices deve ser maior que 0");
        if (prob < 0 || prob > 1)
        	throw new IllegalArgumentException("A probabilidade de inclusão de arestas deve ser entre 0 e 1");
        
	    geraVertices(numVertices);
	    geraArestas(prob);
	}

    private void geraArestas(float prob) {
    	
    	Float numGerado;
    	Random gerador = new Random();
    	
    	for(int i=0; i < vertices.size(); i++){
    		for(int j=i+1; j < vertices.size(); j++){
    			numGerado = gerador.nextFloat();
    			if (numGerado <= prob){
    				arestas.add(new Aresta(vertices.get(i),vertices.get(j)));
    				vertices.get(i).vizinhos.add(vertices.get(j));
    				vertices.get(j).vizinhos.add(vertices.get(i));
    			}
    		}
    	}
	}

	private void geraVertices(int numVertices) {
		for (int i = 0; i < numVertices; i++){
			vertices.add(new Vertice(i));
		}
	}

	@Override
    public String toString() {
        String toString = "";
        for (Vertice u : vertices) {
            toString += u.indice + " -- ";
            for (Vertice v : u.vizinhos) {
                toString += v.indice + ", ";
            }
            toString += "\n";
        }
        return toString;
    }

	public void buscaCompConexas() {
		// TODO Auto-generated method stub
		
	}

	public void buscaPontes() {
		// TODO Auto-generated method stub
		
	}

	public void buscaArticulacoes() {
		// TODO Auto-generated method stub
		
	}

	public void buscaBlocos() {
		// TODO Auto-generated method stub
		
	}

	public void visitaAresta(Vertice v1, Vertice v2) {
		for(int i=0; i < arestas.size(); i++){
			if (arestas.get(i).v1 == v1){
				if (arestas.get(i).v2 == v2){
					arestas.get(i).setVisitada();
				}
			}
		}
	}

	public void setCiclico() {
		this.temCiclos = true;
	}

	public void setAciclico() {
		this.temCiclos = false;
	}

	public void setConexo() {
		this.conexo = true;
	}

	public void setArvore() {
		this.arvore = true;
	}
}
