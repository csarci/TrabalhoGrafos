package grafo;

import java.util.Random;

public class Grafo{

    private int vertices;
    private int arestas;
    private int [][] matrizAdjacencias;
    
    public Grafo(){
    	this.vertices = 0;
    	this.arestas = 0;
    }
    
    public void geraGrafo(int numVertices, float prob) {
      this.vertices = numVertices;
    	Float next;
    	Random gerador = new Random();
    	if (numVertices < 0) 
        	throw new IllegalArgumentException("Número de vértices deve ser maior que 0");
        if (prob < 0 || prob > 1)
        	throw new IllegalArgumentException("A probabilidade de inclusão de arestas deve ser entre 0 e 1");
        
	    this.vertices = numVertices;
	    this.arestas = 0;
	    matrizAdjacencias = new int[numVertices][numVertices];
	    for (int i = 0; i < numVertices; i++){
	        for (int j = 0; j < numVertices; j++){
	        	next = gerador.nextFloat();
	        	if (next <= prob){
	        		adicionaAresta(i,j);
	        		arestas++;
	        	}
	        	else{
	        		matrizAdjacencias[i][j] = 0;
	        	}
	        }
	    }
	    	
    }

    private void adicionaAresta(int v1, int v2) {
		  matrizAdjacencias[v1][v2] = 1;
		  matrizAdjacencias[v2][v1] = 1;
    }

    


}
