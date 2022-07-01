import java.util.ArrayList;
import java.util.Iterator;

public class Library{
	private GuidedGraph genreGraph;

	public void addGenre(String[] item){
		for (int i = 0; i < item.length; i++) {
			if (i == 0) {
				genreGraph.agregarVertice(item[i]);
			}else{
				genreGraph.agregarVertice(item[i]);
				if (!genreGraph.existeArco(item[i-1], item[i])) {
					genreGraph.agregarArco(item[i-1], item[i]);
				}else{
					genreGraph.obtenerArco(item[i-1], item[i]).sumEtiqueta();
				}
			}
		}
	}

	public ArrayList<String> mostPopularGenres(String genero, int amount){
			ArrayList popularGenres = new ArrayList<String>();
		if (genreGraph.obtenerArcos(genero) != null) {
			Iterator<Bow> arcos = genreGraph.obtenerArcos(genero);
			ArrayList<Bow> biggestBows = new ArrayList<>();
			int i = 1;
			while (arcos.hasNext() && i <= amount){
				biggestBows.add(arcos.next());
				i++;
			}
			for (int x = 0; x < biggestBows.size(); x++) {
				popularGenres.add(biggestBows.get(x).getVerticeDestino().getGenero());
			}
		}
			return popularGenres;
	}

	public void getMayorSecuencia(String genero){
		ArrayList<String> solucion = new ArrayList<>();
		Iterator<Bow> arcos = genreGraph.obtenerArcos(genero);
		boolean fin = false;
		Apex origen = arcos.next().getVerticeOrigen();
		solucion.add(genero);
		while (!fin){ //mientras el vertice actual siga teniendo adyacentes
			Apex seleccionado = seleccionar(solucion, origen);
			factible(solucion, seleccionado, origen, fin); // chequea que sea factible el vertice seleccionado
			if (origen.sinArco()){
				fin = true;
			}
			origen = seleccionado; //origen se vuelve destino
			/*if(a == null){ //si retorna null, termina greedy
				fin = true;
			}*/
		}
	}

	public Apex seleccionar(ArrayList<String> solucion, Apex a) {
		Apex destino = a.getMayorArco().getVerticeDestino();
		return destino;
		/*if (!solucion.contains(destino)) { // si la lista solucion no contiene el vertice destino
			solucion.add(destino.getGenero()); // lo agrega
			return destino; // retorna destino
		} else {
			a.borrarArco(); //borra el primer arco( el de etiqueta mayor porque estan ordenados)
			if (a.sinArco()) { //si se queda sin adyacentes, retorna null
				return null;
			} else {
				return destino; // retorna destino y en el while se llama a seleccionar con el destino como
			}
		}*/
	}

	public boolean factible(ArrayList<String> solucion, Apex destino, Apex origen, boolean fin){
		if (!solucion.contains(destino)) { // si la lista solucion no contiene el vertice destino
			solucion.add(destino.getGenero()); // lo agrega
			return true;
		} else {
			origen.borrarArco();
			return false;
		}
	}





}