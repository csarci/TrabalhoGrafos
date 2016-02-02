package grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tayanemoura e carlossarcinelli
 */
class Vertice {

    int indice;
    List<Vertice> vizinhos;
    private int PE;
    private int PS;
    private Vertice pai;

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
    
}
