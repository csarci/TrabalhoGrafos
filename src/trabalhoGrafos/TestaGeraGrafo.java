package grafo;

public class TestaGeraGrafo {

	public static void main(String[] args) {
		Grafo g = new Grafo();
		g.geraGrafo(7, 0.5f);
		System.out.println(g.toString());
		
		BuscaProfundidade dps1 = new BuscaProfundidade(g);
		
		dps1.inicializaBusca();
		dps1.verificaConexo();
		dps1.verificaArvore();
		
		g.buscaCompConexas();
		g.buscaPontes();
		g.buscaArticulacoes();
		g.buscaBlocos();
	}

}
