import java.util.ArrayList;
import java.util.Iterator;

public class GuidedGraph<T>{

	private ArrayList<Apex> vertices;
	
	public GuidedGraph(ArrayList<Apex> vertice) {
		super();
		vertice = new ArrayList<Apex>();
	}


	/*public ArrayList<Apex> obtenerAdyacentes2(String genero){
		for (Apex vertice : vertices) {
			if (vertice.getGenero().equals("genero")) {
				return vertice.getAdyacentes();
			}
		}
	}*/

	public GuidedGraph<String> DFS(String genero) {
		ArrayList<Apex> a = new ArrayList<>();
		GuidedGraph g = new GuidedGraph(a);
		for (Apex vertex : vertices) {
			if (vertex.getGenero().equals(genero)){
				g = new GuidedGraph(dfsVisit(vertex, vertex));
			}
		}return g;
	}
	public ArrayList<Apex> dfsVisit(Apex verticeI, Apex verticeOrigen) {
		ArrayList<Apex> vertices = new ArrayList<>();
		vertices.add(verticeOrigen);
		verticeI.setColor("AMARILLO");
		ArrayList<Apex> adyacentes = verticeI.getAdyacentes();
		for (Apex adyacente : adyacentes) {
			if (adyacente.getColor().equals("blanco")) {
				vertices.add(adyacente);
				dfsVisit(adyacente, verticeOrigen);
			} else if (adyacente.getColor().equals("amarillo") && adyacente.getGenero().equals(verticeOrigen.getGenero())) {
				return vertices;
			}
		}
		vertices = new ArrayList<>();
		verticeI.setColor("negro");
		return vertices;
	}

	public Iterator<Bow<T>> obtenerArcos(String genero) {
		for (Apex ver : vertices) {
			if(ver.getGenero().equals(genero)){
				return ver.getArcos();
			}
		}
		return null;
	}

	public void agregarVertice(String genero) {
		Apex v = new Apex(genero);
		if (!this.contieneVertice(genero)) {
			vertices.add(v);
		}
		//agregarArco(entre vertice actual y anterior)
	}

	public void borrarVertice(String vertice) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getGenero() == vertice) {
				vertices.remove(i--);
			}
			else {
				vertices.get(i).borrarArco(vertice);
			}
		}
	}

	public void agregarArco(String genero1, String genero2) {
		Apex a = new Apex(genero1);
		Apex b = new Apex(genero2);
		if (!existeArco(genero1, genero2)) {
			Bow bow = new Bow<T>(a, b);
			for (int i = 0; i < vertices.size(); i++) {
				if (vertices.get(i).getGenero().equals(genero1)) {
					vertices.get(i).agregarArco(bow);
				}
			}
		}
	}

	public void borrarArco(String genero1, String genero2) {
		for (Apex vertice : vertices) {
			vertice.borrarArco(genero2);
		}
	}

	public boolean contieneVertice(String genero) {
		return vertices.contains(genero);
	}

	public boolean existeArco(String genero1, String genero2) {
		if (this.contieneVertice(genero1)) {
			for (Apex vertice : vertices) {
				if (vertice.tieneArco(genero2)) {
					return true;
				}
			}return false;
		}
		return false;
	}

	public Bow<T> obtenerArco(String genero1, String genero2) {
		if (this.contieneVertice(genero1)) {
			for (Apex vertice : vertices) {
				if (vertice.tieneArco(genero2)) {
					return vertice.getArco(genero2);
				}
			}
		}
		return null;
	}

	public int cantidadVertices() {
		return vertices.size();
	}

	/*
	@Override
	public int cantidadArcos() {
		int cantidad = 0;
		for (Vertice vertice : vertices) {
			cantidad += vertice.getCantidadArcos();
		}return cantidad;
	}*/



	/*@Override
	public Iterator<Integer> obtenerVertices() {
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {

		return null;
	}

	@Override
	public Iterator<Bow<T>> obtenerArcos() {

		return null;
	}*/

}