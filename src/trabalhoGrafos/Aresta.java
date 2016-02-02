package grafo;

/**
 *
 * @author tayanemoura e carlossarcinelli
 */
class Aresta {
    Vertice v1;
    Vertice v2;
    boolean visitada;

    Aresta(Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public boolean getVisitada() {
		return this.visitada;
	}

	public void setVisitada() {
		this.visitada = true;
	}

	public void desvisita() {
		this.visitada = false;
	}
}
