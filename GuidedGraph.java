import java.util.ArrayList;
import java.util.Iterator;

public class GuidedGraph<T> implements Graph<T>{

	private ArrayList<Vertice> vertices;
	private int tiempo;
	
	public GuidedGraph(ArrayList<Integer> vertice, ArrayList<Arco> arcos) {
		super();
		vertice = new ArrayList<Integer>();
		arcos = new ArrayList<Arco>();
	}

	@Override
	public void agregarVertice(int verticeId) {

		if (!vertices.contains(verticeId)) {
			Vertice v = new Vertice(verticeId);
			vertices.add(v);
		}
		agregarArco(entre vertice actual y anterior)
		
	}

	@Override
	public void borrarVertice(int verticeId) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getValor() == verticeId) {
				vertices.remove(i--);
			}
			else {
				vertices.get(i).borrarArco(verticeId);
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2) {
		if (!existeArco()) {
			Arco a = new Arco<T>(verticeId1, verticeId2);
			for (int i = 0; i < vertices.size(); i++) {
				if (vertices.get(i).getValor() == verticeId1) {
					vertices.get(i).agregarArco(a);
				}
			}
		}
	}


	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		for (Vertice vertice : vertices) {
			vertice.borrarArco(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(Vertice verticeId) {
		return vertices.contains(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			for (Vertice vertice : vertices) {
				if (vertice.tieneArco(verticeId2)) {
					return true;
				}
			}return false;
		}
		return false;
	}

	@Override
	public Bow<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			for (Vertice vertice : vertices) {
				if (vertice.tieneArco(verticeId2)) {
					return vertice.getArco(verticeId2);
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cantidad = 0;
		for (Vertice vertice : vertices) {
			cantidad += vertice.getCantidadArcos();
		}return cantidad;
	}

	public ArrayList<> obtenerAdyacentes2(int v){
		for (Vertice vertice : vertices) {
			if (vertice.getValor() == v) {
				return vertice.getAdyacentes();
			}
		}
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {

		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {

		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {

		return null;
	}
	
	public void depthFirstSearch() {
		for (Vertice vertice : vertices) {
			vertice.setColor("BLANCO");
		}
		int tiempo = 0;
		for (Vertice vertice : vertices) {
			if (vertice.getColor().equals("BLANCO")) {
				depthFirstSearchVisit(vertice);
			}
		}
	}
	
	public void depthFirstSearchVisit(Vertice vertice) {
		vertice.setColor("AMARILLO");
		vertice.setTiempoInicial(tiempo++);
		for (/*recorrer adyacentes*/) {
			if (/*si es blanco*/) {
				//llamo recursivo
			}
			//setColor("NEGRO");
			//setTiempoFinal(tiempo++);
		}
	}
	

}