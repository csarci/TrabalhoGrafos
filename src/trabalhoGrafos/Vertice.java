/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoGrafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tayanemoura
 */
class Vertice {

    String nome;
    List<Aresta> adj;

    Vertice(String nome) {
        this.nome = nome;
        this.adj = new ArrayList<Aresta>();
    }

    void addAdj(Aresta e) {
        adj.add(e);
    }
}
