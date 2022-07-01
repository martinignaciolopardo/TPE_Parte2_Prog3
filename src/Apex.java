import java.util.ArrayList;
import java.util.Iterator;

public class Apex<T> {

	private String genero;
	private ArrayList<Bow> arcos;
	private String color;
	private int tiempoInicial = 0;
	private int tiempoFinal = 0;
	
	public Apex(String genero) {
		this.genero = genero;
	}

	public ArrayList<Apex> getAdyacentes(){
		ArrayList adyacentes = new ArrayList<>();
		for (int i = 0; i < arcos.size(); i++) {
			adyacentes.add(arcos.get(i).getVerticeDestino());
		}
		return adyacentes;
	}

	public String getGenero() {
		return genero;
	}
	
	public boolean esAdyacente(String v) {
		for (int i = 0; i < arcos.size(); i++) {
			if (arcos.get(i).getVerticeDestino().getGenero() == v ) {
				return true;
			}
		}return false;
	}
	
	public void borrarArco(String genero) {
		for (int i = 0; i < arcos.size(); i++) {
			if (arcos.get(i).getVerticeDestino().getGenero() == genero ) {
				arcos.remove(i);
			}
		}
	}

	public void borrarArco(){
		this.arcos.remove(0);
	}

	public boolean sinArco(){
		return this.arcos.isEmpty();
	}

	// Agrega ordenado
	public void agregarArco(Bow a) {
		if (!arcos.contains(a)) {
			for (int i = 0; i < arcos.size(); i++) {
				if (a.getEtiqueta() > arcos.get(i).getEtiqueta()) {
					arcos.add(i, a);
					return;
				}
			}
			if (!arcos.contains(a)) {
				arcos.add(arcos.size(), a);
			}
		}
	}

	public Bow getMayorArco(){
		return arcos.get(0);
	}
	
	public boolean tieneArco(String vertice) {
		return arcos.contains(vertice);
	}
	
	public Bow<T> getArco(String vertice){
		if (tieneArco(this.getGenero())) {
			for (Bow arco : arcos) {
				if (arco.getVerticeDestino().getGenero() == vertice) {
				return arco;
				}
			}
		}
		return null;
	}
	
	public int getCantidadArcos() {
		return arcos.size();
	}

	@Override
	public boolean equals(Object obj) {
		Apex v = (Apex) obj;
		if (v.getGenero() == this.getGenero()) {
			return true;
		}return false;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTiempoInicial() {
		return tiempoInicial;
	}

	public void setTiempoInicial(int tiempoInicial) {
		this.tiempoInicial = tiempoInicial;
	}

	public int getTiempoFinal() {
		return tiempoFinal;
	}

	public void setTiempoFinal(int tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}


	public Iterator<Bow> getArcos() {
		return arcos.iterator();
	}
}