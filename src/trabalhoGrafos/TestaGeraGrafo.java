package grafo;

public class TestaGeraGrafo {

		public static void main(String[] args) {
			Grafo g = new Grafo();
			g.geraGrafo(5, 0.8f);
			System.out.println(g.toString());
			Vertice raiz = g.vertices.get(0);
			
			BuscaProfundidade dps = new BuscaProfundidade(g);
			
			dps.resetaValores();
			dps.realizaBusca(raiz);
			
			dps.resetaValores();
			dps.verificaConexo();
			dps.verificaArvore();
			
			dps.resetaValores();
			dps.verificaBipartidariedade(raiz);
			System.out.println("O grafo é bipartido? " + g.bipartido);
			
			dps.resetaValores();
			dps.calculaBacks(raiz);
			dps.encontraArticulacoes();
			System.out.println("Articulações: " + g.articulacoes.toString());
			
			dps.resetaValores();
			dps.encontraBlocos(raiz);
			dps.encontraPontes();
			System.out.println("Blocos: " + g.blocos.toString());
			System.out.println("Pontes: " + g.pontes.toString());
			
			dps.verificaEuleriano();
			dps.algoritmoFleury();
//			System.out.println("Caminho Euleriano: " + g.caminhoEuleriano.toString());

//			for (int i = 0; i < g.vertices.size(); i++) {
//				System.out.println(g.vertices.get(i).toString());
//			}
		}
	}
