import java.util.Iterator;

public interface Graph<T> {
	
	// Agrega un vertice 
	public void agregarVertice(String genero);

	// Borra un vertice
	public void borrarVertice(String genero);

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(String genero1, String genero2);

	// Borra el arco que conecta el verticeId1 con el verticeId2
	public void borrarArco(String genero1, String genero2);

	// Verifica si existe un vertice
	public boolean contieneVertice(String genero);

	// Verifica si existe un arco entre dos vertices
	public boolean existeArco(String genero1, String genero2);
	
	// Obtener el arco que conecta el verticeId1 con el verticeId2
	public Bow<T> obtenerArco(String genero1, String genero2);

	// Devuelve la cantidad total de vertices en el grafo
	public int cantidadVertices();

	// Devuelve la cantidad total de arcos en el grafo
	public int cantidadArcos();

	// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
	public Iterator<Integer> obtenerVertices();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
	public Iterator<Integer> obtenerAdyacentes(String genero);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Bow<T>> obtenerArcos();
		
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	public Iterator<Bow<T>> obtenerArcos(String genero);
	
	
}
