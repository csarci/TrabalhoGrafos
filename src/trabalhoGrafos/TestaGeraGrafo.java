	public class TestaGeraGrafo {

		public static void main(String[] args) {
			Grafo g = new Grafo();
			g.geraGrafo(5, 0.5f);
			System.out.println(g.toString());
			
			BuscaProfundidade dps = new BuscaProfundidade(g);
			dps.resetaValores();
			dps.realizaBusca(g.vertices.get(0));
		}
	}

