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
		this.etiqueta = etiqueta;
	}

	public void sumEtiqueta(){
		this.etiqueta++;
	}
	
	@Override
	public boolean equals(Object obj) {
		Arco a = (Arco) obj; 
		if (a.getVerticeOrigen() == this.getVerticeOrigen() && 
				a.getVerticeDestino() == this.getVerticeDestino()) {
			return true;
		}return false;
	}

}
