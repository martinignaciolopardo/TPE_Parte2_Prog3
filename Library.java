public class Library{
	private GrafoDirigido genreGraph;


	public addGenre(String[] item){
		for (int i = 0; i < item.size(); i++) {
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

	public ArrayList<String> mostPopularGenres(W, int amount){
		//Apex v= obtenerVertice(genre)
		Apex v = new Apex();
		ArrayList biggestBows = new ArrayList<Bow>; 
		ArrayList popularGenres = newArrayList<String>;
		for(int = 0; int < biggestBows.size(); i++){
			popularGenres.add(biggestBows[i].getVerticeDestino.getValor());
		}
		return popularGenres;
		
	}

}