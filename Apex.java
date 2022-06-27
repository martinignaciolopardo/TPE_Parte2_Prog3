import java.util.ArrayList;

public class Apex<T> {

	private int valor;
	private ArrayList<Arco> arcos;
	private String color;
	private int tiempoInicial = 0;
	private int tiempoFinal = 0;
	
	public Apex(int valor) {
		this.valor = valor;
	}

	public ArrayList<> getAdyacentes(){
		ArrayList adyacentes = new ArrayList<>();
		for (int i = 0; i < arcos.size(); i++) {
			adyacentes.add(arcos.get(i).getVerticeDestino());
		}
		return adyacentes;
	}

	public int getValor() {
		return valor;
	}
	
	public boolean esAdyacente(int v) {
		for (int i = 0; i < arcos.size(); i++) {
			if (arcos.get(i).getVerticeDestino() == v ) {
				return true;
			}
		}return false;
	}
	
	public void borrarArco(int vertice) {
		for (int i = 0; i < arcos.size(); i++) {
			if (arcos.get(i).getVerticeDestino() == vertice ) {
				arcos.remove(i);
			}
		}
	}

	public ArrayList<Bow> getBiggestsBows(int amount){
		//arcos.ordenarDescendente
		ArrayList nueva = new ArrayList<Bow>;
		for (int i; i < amount; i++ ) {
			nueva.add(arcos[i])
		}return nueva;
	}
	
	public void agregarArco(Arco a) {
		if (!arcos.contains(a)) {
			arcos.add(a);
		}
	}
	
	public boolean tieneArco(int vertice) {
		return arcos.contains(vertice);
	}
	
	public Bow<T> getArco(int vertice){
		if (tieneArco(this.getValor())) {
			for (Bow arco : arcos) {
				if (arco.getVerticeDestino() == vertice) {
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
		Vertice v = (Vertice) obj; 
		if (v.getValor() == this.getValor()) {
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
	
	
}