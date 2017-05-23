package net.juanxxiii.j23guiappframework.gui;

public class Coche {

	private String nModelo;
	private String nMarca;
	private float consumo;
	private float emisiones;
	
	public Coche(String nModelo, String nMarca, float consumo, float emisiones) {
		super();
		this.nModelo = nModelo;
		this.nMarca = nMarca;
		this.consumo = consumo;
		this.emisiones = emisiones;
	}

	public String getnModelo() {
		return nModelo;
	}

	public void setnModelo(String nModelo) {
		this.nModelo = nModelo;
	}

	public String getnMarca() {
		return nMarca;
	}

	public void setnMarca(String nMarca) {
		this.nMarca = nMarca;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public float getEmisiones() {
		return emisiones;
	}

	public void setEmisiones(float emisiones) {
		this.emisiones = emisiones;
	}
	

}
