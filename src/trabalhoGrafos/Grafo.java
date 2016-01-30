/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoGrafos;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author tayanemoura
 */
public class Grafo {

    List<Vertice> vertices;
    List<Aresta> arestas;

    public Grafo() {
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }

    Vertice addVertice(String nome) {
        Vertice v = new Vertice(nome);
        vertices.add(v);
        return v;
    }

    Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta e = new Aresta(origem, destino);
        origem.addAdj(e);
        arestas.add(e);
        return e;
    }

    public String toString() {
        String r = "";
        for (Vertice u : vertices) {
            r += u.nome + " -> ";
            for (Aresta e : u.adj) {
                Vertice v = e.destino;
                r += v.nome + ", ";
            }
            r += "\n";
        }
        return r;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo();
        Vertice s = g.addVertice("s");
        Vertice t = g.addVertice("t");
        Vertice y = g.addVertice("y");
        Aresta st = g.addAresta(s, t);
        Aresta sy = g.addAresta(s, y);
        Aresta ty = g.addAresta(t, y);
        Aresta yt = g.addAresta(y, t);
        System.out.println(g);
    }
}
