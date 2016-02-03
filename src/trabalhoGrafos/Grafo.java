package grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grafo{

	List<Vertice> vertices;
	List<Vertice> articulacoes;
    List<Aresta> arestas;
    List<Aresta> bloco;
    List<Vertice> compConexa;
    List<Aresta> pontes;
    List<Aresta> caminhoEuleriano;
    boolean temCiclos;
	boolean conexo;
	boolean arvore;
	boolean bipartido;
	boolean euleriano;
	public List<List<Aresta>> blocos;
	public List<List<Vertice>> compConexas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice>();
        this.articulacoes = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
        this.pontes = new ArrayList<Aresta>();
        this.bloco = new ArrayList<Aresta>();
        this.compConexa = new ArrayList<Vertice>();
        this.blocos = new ArrayList<List<Aresta>>();
        this.compConexas = new ArrayList<List<Vertice>>();
        this.caminhoEuleriano = new ArrayList<Aresta>();

        this.temCiclos = false;
        this.conexo = false;
        this.arvore = false;
        this.bipartido = true;
        this.euleriano = false;
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

	public void visitaAresta(Vertice v1, Vertice v2) {
		for(int i=0; i < arestas.size(); i++){
			if (arestas.get(i).getPrimVertice() == v1){
				if (arestas.get(i).getSegVertice() == v2){
					arestas.get(i).setVisitada();
					//System.out.println("Aresta " + v1 + "-" + v2 + " visitada.");
				}
			}
		}
	}

	public void setTemCiclos() {
		this.temCiclos = true;
	}

	public void setAciclico() {
		this.temCiclos = false;
	}

	public void setConexo() {
		this.conexo = true;
	}

	public void setArvore(boolean b) {
		this.arvore = b;
	}

	public void setBipartido(boolean bipartido) {
		this.bipartido = bipartido;
	}

	public List<Aresta> getBloco() {
		return this.bloco;
	}
	
	public void zeraBloco(){
		this.bloco = new ArrayList<Aresta>();
	}

	public void setEuleriano(boolean euleriano) {
		this.euleriano = euleriano;
	}

	public boolean getArvore() {
		return this.arvore;
	}
}
