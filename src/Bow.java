public class Bow<T> {

	private Apex verticeOrigen;
	private Apex verticeDestino;
	private int etiqueta;

	public Bow(Apex verticeOrigen, Apex verticeDestino) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = 1;
	}
	
	public Apex getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public Apex getVerticeDestino() {
		return verticeDestino;
	}

	public int getEtiqueta() {
		return etiqueta;
	}

	public int setEtiqueta(int etiqueta){
		return this.etiqueta = etiqueta;
	}

	public void sumEtiqueta(){
		this.etiqueta++;
	}
	
	@Override
	public boolean equals(Object obj) {
		Bow a = (Bow) obj;
		if (a.getVerticeOrigen().getGenero() == this.getVerticeOrigen().getGenero() &&
				a.getVerticeDestino().getGenero() == this.getVerticeDestino().getGenero()) {
			return true;
		}return false;
	}

}
