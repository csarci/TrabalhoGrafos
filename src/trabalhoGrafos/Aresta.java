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

	public Vertice getPrimVertice() {
		return this.v1;
	}

	public Vertice getSegVertice() {
		return this.v2;
	}

}
